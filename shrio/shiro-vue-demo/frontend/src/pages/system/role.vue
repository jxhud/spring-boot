<template>
  <div style="margin: 20px;padding: 20px">
    <div style="height: 50px">
      <Button type="success" style="float:right;margin-right: 50px" size="small" @click="addRole">新增</Button>
    </div>
    <Table border :columns="roleCols" :data="roles"></Table>
    <Modal
      v-model="modal5"
      title="添加"
      width="600" z-index="10000">
      <div style="text-align: center">
        <label>角色名称：</label><Input  placeholder="角色名称" style="width: 300px" size="large"/>
      </div>
      <div style="text-align: center;margin-top: 20px">
        <div style="display:inline-block">
          <span >
          角色权限：
        </span>
        </div>
        <Tree :data="menus" show-checkbox multiple style="display:inline-block"></Tree>
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
                      this.remove(params.index)
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
        menus: []
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
      addRole: function () {
        this.modal5 = true;
      },
      getTree: function () {
        http.get("/menu/tree").then((res) => {
          if (res.code === 100) {
             this.menus.push(res.data);
          }
        })
      }
    }
  }
</script>

<style scoped>
</style>
