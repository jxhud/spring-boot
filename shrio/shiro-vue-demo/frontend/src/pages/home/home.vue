<template>
  <div class="home">
    <Layout class="home">
      <Header style="background-color: #fffee6;height: 50px">
        <h2 style="color: #ffc900">Shiro Demo</h2>
        <div class="layout-ceiling">
          <div class="layout-ceiling-main">
            <a href="#">注册登录</a> |
            <a href="#">帮助中心</a> |
            <a href="#">安全中心</a> |
            <a href="#">服务大厅</a>
          </div>
        </div>
      </Header>
      <Layout>
        <Sider hide-trigger style="background-color:#fffee6;">
          <Menu @on-select="changeItem" @on-open-change="getOpenMenu" :active-name="this.$store.state.menu.active"
                :open-names="this.$store.state.menu.open_names" style="width: 100%;background-color: #fffee6;color:#ffc900 ">
            <Submenu name="1">
              <template slot="title">
                <Icon type="ios-analytics" />
                系统管理
              </template>
              <MenuItem name="1-1" to="/user">用户管理</MenuItem>
              <MenuItem name="1-2" to="/role">角色管理</MenuItem>
              <MenuItem name="1-3" to="/menu">菜单管理</MenuItem>
              <MenuItem name="1-4" to="/dept">部门管理</MenuItem>
            </Submenu>
            <Submenu name="2">
              <template slot="title">
                <Icon type="ios-filing" />
                系统设置
              </template>
              <MenuItem name="2-1">待开发1</MenuItem>
              <MenuItem name="2-2">待开发2</MenuItem>
            </Submenu>
          </Menu>
        </Sider>
        <Content>
          <router-view name="content"></router-view>
        </Content>
      </Layout>
    </Layout>
  </div>
</template>

<script>
  import store from '../../store/store'
  import { mapState,mapMutations,mapActions } from 'vuex';
  import http from '../../components/http'

  export default {
    name: 'App',
    data () {
      return {
      }
    },
    created() {
    },
    computed: {
      ...mapState([
        'menu'
      ])
    },
    store,
    methods: {
      ...mapMutations([
        'setMenu','setOption','initMenus'
      ]),
      changeItem: function (name) {
        this.$store.commit('setMenu',name)
      },
      getOpenMenu: function (name) {
        this.$store.commit('setOption',name)
      },
      loginout :function () {
        http.get('/login/out').then((res) => {
          if (res.code == 100) {
            this.$store.commit('initMenus')
            this.$Message.success('退出成功');
          }
        })
      }
    },
  }
</script>

<style less="scope">
  .home {
    width: 100%;
    height: 100%;
    position: absolute;
    z-index:9999;
  }
</style>
