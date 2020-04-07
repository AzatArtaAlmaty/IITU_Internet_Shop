import Vue from 'vue'
import main from 'glav.vue'
import router from "router/router"
import axios from 'axios'
import VueCookie from 'vue-cookies'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)
Vue.use(VueCookie)
Vue.prototype.$http = axios
// Vue.config.devtools = false;
// Vue.config.debug = false;
// Vue.config.silent = true;
new Vue({
    el: '#app',
    router,
    render: a => a(main)
})