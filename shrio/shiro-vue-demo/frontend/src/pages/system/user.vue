<template>
  <div style="margin: 20px;padding: 20px">
    <div style="margin-bottom: 10px">
      用户名:
      <Input   clearable style="width: 200px" />
      性别：
      <a href="javascript:void(0)">所有</a>
      状态：
      <a href="javascript:void(0)">所有</a>
    </div>
    <Table border :columns="userCols" :data="users"></Table>
  </div>
</template>

<script>
  import http from '../../components/http'
  export default {
    data () {
      return {
        userCols: [
          {
            title: '用户编号',
            key: 'userId'
          },
          {
            title: '账号',
            key: 'userName'
          },
          {
            title: '姓名',
            key: 'realName'
          },
          {
            title: '手机号码',
            key: 'phone'
          },
          {
            title: '状态',
            key: 'enable',
            render: (h,params)=>{
              return h('div',
                this.statusFormat(params.row.enable)
              )
            }
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
        users: []
      }
    },
    created() {
      this.init()
    },
    methods: {
      init: function () {
        http.post('user/query').then((res) => {
         if (res.code === 100) {
           this.users = res.data;
         }
        })
      },
      statusFormat: function (enable) {
          if (enable === 0) {
            return '正常'
          } else {
            return '锁定'
          }
      },
      show (index) {
        this.$Modal.info({
          title: 'User Info',
          content: `Name：${this.data6[index].name}<br>Age：${this.data6[index].age}<br>Address：${this.data6[index].address}`
        })
      },
      remove (index) {
        this.data6.splice(index, 1);
      }
    }
  }
</script>

<style scoped>
</style>
