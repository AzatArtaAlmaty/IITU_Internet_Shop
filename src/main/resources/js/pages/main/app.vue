<template>
    <div>
        <navbar :SelectedItems="SelectedItems"/>
        <slider />
        <div class="container-fluid">
            <Category :categories="categories" :button-click="buttonClick" :SelectedItems="SelectedItems"/>
            <PopularItems :items="PopularItems" title="Популярые товары" :SelectedItems="SelectedItems" :buttonClick="buttonClick"/>
        </div>
        <foot />
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import slider from 'pages/main/components/slider.vue'
    import PopularItems from 'pages/main/components/PopularItems.vue'
    import Category from 'pages/main/components/CategoryList.vue'
    import foot from 'pages/components/foot.vue'
    import auth from 'pages/login/auth.vue'
    export default {
        name: "app",
        components: {
            navbar,
            slider,
            Category,
            PopularItems,
            foot,
            auth,
        },
        data(){
            return {
                categories: null,
                PopularItems: null,
                sliderFileName: null,
                SelectedItems: []
            }
        },
        async created() {
            let response = await this.$http.get('http://localhost:9000/category/all');
            this.categories = response.data;

            response = await this.$http.get('http://localhost:9000/item/getList');
            this.PopularItems = response.data;
        },
        methods: {
            buttonClick(item) {
                console.log(item, this.SelectedItems)
                this.SelectedItems.push(item);
            }
        }
    }

</script>

<style scoped>
</style>