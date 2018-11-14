<template>
  <div class="home">
    <Layout>
      <Header style="background-color: #ffc900;height: 50px">
        <h2 style="color: white">Shiro Demo</h2>
      </Header>
      <Layout>
        <Sider hide-trigger style="background-color: #999">
          <Menu active-name="1-2" :open-names="['1']" style="width: 100%;background-color: #999;color:white ">
            <Submenu name="1">
              <template slot="title">
                <Icon type="ios-analytics" />
                系统管理
              </template>
                <MenuItem name="1-1">用户管理</MenuItem>
                <MenuItem name="1-2">角色管理</MenuItem>
                <MenuItem name="1-3">菜单管理</MenuItem>
                <MenuItem name="1-4">部门管理</MenuItem>
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
          <Breadcrumb  style="background-color: white">
            <BreadcrumbItem to="/">
              <Icon type="ios-home-outline"></Icon> 系统管理
            </BreadcrumbItem>
            <BreadcrumbItem>
              <Icon type="ios-cafe"></Icon> 用户管理
            </BreadcrumbItem>
          </Breadcrumb>
          <div>
            <Table :columns="columns1" :data="data1"></Table>
            <div style="text-align: center;padding-top: 10px;padding-bottom: 10px">
              <Page :total="100" />
            </div>
          </div>
        </Content>
      </Layout>
      <Footer style="text-align: center">Footer</Footer>
    </Layout>
  </div>
</template>

<script>
  export default {
    name: 'App',
    data () {
      return {
        columns1: [
          {
            title: 'Name',
            key: 'name'
          },
          {
            title: 'Age',
            key: 'age'
          },
          {
            title: 'Address',
            key: 'address'
          }
        ],
        data1: [
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
          {
            name: 'Jim Green',
            age: 24,
            address: 'London No. 1 Lake Park',
            date: '2016-10-01'
          },
          {
            name: 'Joe Black',
            age: 30,
            address: 'Sydney No. 1 Lake Park',
            date: '2016-10-02'
          },
          {
            name: 'Jon Snow',
            age: 26,
            address: 'Ottawa No. 2 Lake Park',
            date: '2016-10-04'
          }
        ]
      }
    }
  }
</script>

<style less="scope">
</style>
