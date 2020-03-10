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
        },
        async created() {
            let data = {
                'name': "test",
                'count': 50,
                'price': 500,
                'category': {
                    'name': "sdfg"
                },
                'info': "test"
            }
            let response = await this.$http.post("http://localhost:9000/item/create", data)
            console.log(response)
        }
    }

</script>

<style scoped>
</style>