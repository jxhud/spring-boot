<template>
  <div style="margin: 20px;padding: 20px">
    <Table border :columns="deptCols" :data="depts"></Table>
  </div>
</template>

<script>
  import http from '../../components/http'

  export default {
    data () {
      return {
        deptCols: [
          {
            title: '部门编号',
            key: 'id'
          },
          {
            title: '部门名称',
            key: 'deptName'
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
        depts: []
      }
    },
    created() {
      this.initDepts()
    },
    methods: {
      initDepts: function () {
        http.post("/dept/query").then((res)=>{
          console.log(res)
          if (res.code === 100) {
            this.depts = res.data
          }
        })
      }
    }
  }
</script>

<style scoped>
</style>
