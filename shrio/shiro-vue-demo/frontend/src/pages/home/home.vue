<template>
  <div class="home">
    <Layout class="home">
      <Header style="background-color: #ffc900;height: 50px">
        <h2 style="color: white">Shiro Demo</h2>
      </Header>
      <Layout>
        <Sider hide-trigger style="background-color: #999">
          <Menu active-name="1-1" :open-names="['1']" style="width: 100%;background-color: #999;color:white ">
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
  export default {
    name: 'App',
    data () {
      return {

      }
    }
  }
</script>

<style less="scope">
  .home {
    width: 100%;
    height: 100%;
    position: absolute;
    z-index:999999999999;
  }
</style>
