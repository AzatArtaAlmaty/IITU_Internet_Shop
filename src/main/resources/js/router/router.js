import Vue from 'vue'
import VueRouter from 'vue-router'
import App from 'pages/main/app.vue'
import Category from 'pages/FindByCategory/category.vue'
import auth from 'pages/login/auth.vue'
import admin from 'pages/admin/admin.vue'
import cart from 'pages/cart/cart.vue'
import checkout from 'pages/checkout/checkout.vue'
import NotFound from 'pages/404/404.vue'

Vue.use(VueRouter)
const routes = [
    { path: '/', name: "app", component: App},
    { path: '/cart', name: "cart", component: cart, props:true },
    { path: '/cat', name: "cat", component: Category, props:true },
    // { path: '/CategoryInfo/:id', name: "CategoryInfo", component: CategoryInfo },
    { path: '/login', name: "auth", component: auth },
    // { path: '/admin', name: "admin", component: admin, props:true },
    // { path: '/cart', name: "cart", component: cart },
    // { path: '/cat', name: "cat", component: Category, props:true },
    { path: '/404', name: 'E404', component: NotFound },
    { path: '/checkout', name: "checkout", component: checkout},
    { path: '*', redirect: '/404'},
];

export default new VueRouter({
    mode: 'history',
    routes
})
/*
* Create and Delete Api + table Slider
* Crud for Cart
* Admin Crud
* testing all api
* popular items
* admin vue
* payload vue
* login vue
* cart vue
* */