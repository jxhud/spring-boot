import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/login/login'
import Home from '@/pages/home/home'
import user from '@/pages/system/user'
import menu from '@/pages/system/menu'
import dept from '@/pages/system/dept'
import role from '@/pages/system/role'
import nofound from '../pages/home/404'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      children: [{
        path: '/user',
        components: {
          content: user
        }
      },
      {
        path: '/menu',
        components: {
          content: menu
        }
      },
      {
        path: '/dept',
        components: {
          content: dept
        }
      },
      {
        path: '/role',
        components: {
          content: role
        }
      }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/404',
      name: '404',
      component: nofound
    },
    {
      path: '*', // 此处需特别注意至于最底部
      redirect: '/404'
    }
  ]
})
