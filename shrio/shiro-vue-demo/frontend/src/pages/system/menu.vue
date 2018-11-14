<template>
  <div style="margin: 20px;padding: 20px">
    <Table border :columns="menuCols" :data="menus"></Table>
  </div>
</template>

<script>
  import http from '../../components/http'
  export default {
    data () {
      return {
        menuCols: [
          {
            title: '菜单编号',
            key: 'id'
          },
          {
            title: '菜单名称',
            key: 'menuName'
          },
          {
            title: '权限',
            key: 'permissions'
          },
          {
            title: '创建时间',
            key: 'createTime',
            render: (h,params)=>{
              return h('div',
                this.timeFormat(new Date(params.row.createTime))
              )
            }
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
        menus: [
        ]
      }
    },
    created() {
      this.initMenus()
    },
    methods: {
      initMenus: function () {
        http.post("/menu/query").then((res)=>{
          console.log(res)
          if (res.code === 100) {
            this.menus = res.data
          }
        })
      }
    }
  }
</script>

<style scoped>
</style>
