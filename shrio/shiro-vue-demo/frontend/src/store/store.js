import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

const state = {
  menu: {
    active: '',
    open_names: []
  }
}

const mutations = {
  setMenu(state,activeItem) {
   state.menu.active = activeItem;
  },
  setOption(state,opens) {
    state.menu.open_names = opens;
  },
  initMenus(state) {
    state.menu.active = '',
    state.menu.open_names = []
  }
}

const getters = {
  getMenu:function(){
    return state.menu
  }
}

export default new Vuex.Store({
  state,mutations,getters,
  plugins: [createPersistedState()]
})
