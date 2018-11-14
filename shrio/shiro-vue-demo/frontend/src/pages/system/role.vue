<template>
  <div style="margin: 20px;padding: 20px">
    <Table border :columns="roleCols" :data="roles"></Table>
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
                      this.show(params.index)
                    }
                  }
                }, 'View'),
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
                }, 'Delete')
              ]);
            }
          }
        ],
        roles: []
      }
    },
    created() {
      this.initRoles()
    },
    methods: {
      initRoles: function () {
        http.post("/role/query").then((res)=>{
          if (res.code === 100) {
            this.roles = res.data
          }
        })
      }
    }
  }
</script>

<style scoped>
</style>
