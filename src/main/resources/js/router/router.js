import Vue from 'vue'
import VueRouter from 'vue-router'
import App from 'pages/main/app.vue'
import Category from 'pages/FindByCategory/category.vue'
import auth from 'pages/login/auth.vue'
import admin from 'pages/admin/admin.vue'
import cart from 'pages/cart/cart.vue'

Vue.use(VueRouter)
const routes = [
    { path: '/', component: App},
    { path: '/cart', name: "cart", component: cart, props:true },
    { path: '/cat', name: "cat", component: Category, props:true },
    // { path: '/CategoryInfo/:id', name: "CategoryInfo", component: CategoryInfo },
    { path: '/login', name: "auth", component: auth },
    // { path: '/admin', name: "admin", component: admin },
    // { path: '/cart', name: "cart", component: cart },
    // { path: '/cat', name: "cat", component: Category, props:true },
    // { path: '/404', name: '404', component: NotFound },
    // { path: '*', redirect: '/404'},
];

export default new VueRouter({
    mode: 'history',
    routes
})
