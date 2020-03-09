<template>
    <div>
        <navbar />
        <slider />
        <Category />
        <foot />
<!--        <router-link to="/test">Перейти к Foo</router-link>-->
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import slider from 'pages/main/components/slider.vue'
    import Category from 'pages/main/components/CategoryList.vue'
    import foot from 'pages/components/foot.vue'
    import auth from 'pages/login/auth.vue'
    export default {
        name: "app",
        components: {
            navbar,
            slider,
            Category,
            foot,
            auth,
        }
    }

</script>

<style scoped>
</style>