<template>
  <div style="margin: 20px;padding: 20px">
    <div style="height: 50px">
      <Button type="success" style="float:right;margin-right: 50px" size="small" @click="addRoleUi">新增</Button>
    </div>
    <Table border :columns="roleCols" :data="roles"></Table>
    <Modal
      v-model="modal5"
      title="添加"
      width="600" :z-index=10000 @on-ok="addRole()">
      <div style="text-align: center">
        <label>角色名称：</label><Input v-model="newRole.roleName" placeholder="角色名称" style="width: 300px" size="large"/>
      </div>
      <div style="text-align: center;margin-top: 20px">
        <div style="display:inline-block">
          <span >
          角色权限：
        </span>
        </div>
        <Tree :data="menus" ref="tree" show-checkbox multiple style="display:inline-block"></Tree>
      </div>
    </Modal>
  </div>
</template>

<script>
  import  http from  '../../components/http'
  export default {
    data () {
      return {
        roleCols: [
          {
            title: '角色编号',
            key: 'id'
          },
          {
            title: '角色名称',
            key: 'roleName'
          },
          {
            title: '操作',
            key: 'action',
            width: 150,
            align: 'center',
            render: (h, params) => {
              return h('div', [
                h('Button', {
                  props: {
                    type: 'primary',
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.modal5 = true;
                    }
                  }
                }, '修改'),
                h('Button', {
                  props: {
                    type: 'error',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.delRole(params.index)
                    }
                  }
                }, '删除')
              ]);
            }
          }
        ],
        roles: [],
        modal5: false,
        loading: false,
        menus: [],
        newRole: {
          roleName: '',
          checkMenus: []
        }
     }
    },
    created() {
      this.initRoles()
      this.getTree()
    },
    methods: {
      initRoles: function () {
        http.post("/role/query").then((res)=>{
          if (res.code === 100) {
            this.roles = res.data
          }
        })
      },
      addRoleUi: function () {
        this.modal5 = true;
      },
      getTree: function () {
        http.get("/menu/tree").then((res) => {
          if (res.code === 100) {
             this.menus.push(res.data);
          }
        })
      },
      addRole: function () {
        const nodes = this.$refs.tree.getCheckedNodes();
        for(var i =0; i < nodes.length; i++) {
          if (nodes[i].id != 0) {
            this.newRole.checkMenus.push(nodes[i].id)
          }
        }
       http.post("/role/add",this.newRole).then((res) => {
         if (res.code === 100) {
           this.initRoles()
          this.$Message.success("角色添加成功");
         } else if(res.code === 400) {
           this.$Message.warning("系统异常");
         }
       })
      },
      delRole: function (index) {
          http.post("/role/delete",{id: this.roles[index].id}).then((res) => {
           if (res.code === 100) {
             this.roles.splice(index, 1);
             this.$Message.success(res.msg);
           } else {
             this.$Message.warning(res.msg);
           }
         })
      }
    }
  }
</script>

<style scoped>
</style>
