// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import iView from 'iview';
import 'iview/dist/styles/iview.css';
import './my-theme/index.less'
import moment from 'moment'
import time from './components/time'
import Vuex from 'vuex'
 import axios from  'axios'




//时间格式化过滤器
Vue.filter('time', function (value, formatString) {
  formatString = formatString || 'YYYY-MM-DD HH:mm'
  return moment(value).format(formatString)
})

//时间格式化方法
Vue.prototype.timeFormat = function (value, formatString) {
  formatString = formatString || 'YYYY-MM-DD HH:mm'
  return moment(value).format(formatString)
}

Vue.config.productionTip = false
axios.defaults.withCredentials = true
Vue.use(iView,time);
Vue.use(Vuex);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
