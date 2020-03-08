import Vue from 'vue'
import VueRouter from 'vue-router'
import App from 'pages/main/app.vue'
import CategoryInfo from 'pages/itemsByCategory/CategoryInfo.vue'
import auth from 'pages/login/auth.vue'
import admin from 'pages/admin/admin.vue'
import cart from 'pages/cart/cart.vue'

Vue.use(VueRouter)
const routes = [
    { path: '/', component: App},
    { path: '/CategoryInfo/:id', name: "CategoryInfo", component: CategoryInfo },
    { path: '/login', name: "auth", component: auth },
    { path: '/admin', name: "admin", component: admin },
    { path: '/cart', name: "cart", component: cart },
]

export default new VueRouter({
    mode: 'history',
    routes
})
