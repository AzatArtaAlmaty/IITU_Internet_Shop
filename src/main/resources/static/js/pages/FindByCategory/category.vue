<template>
    <div>
        <navbar :SelectedItems="SelectedItems"/>
        <div class="container-fluid">
            <cat :items="items" :change-items="changeItems" :category="SelectedCategory"/>
            <PopularItems :items="items" title="Резальтаты по вашему запросу" :buttonClick="buttonClick"/>
        </div>
        <foot />
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import foot from 'pages/components/foot.vue'
    import cat from 'pages/FindByCategory/components/cat.vue'
    import PopularItems from 'pages/main/components/PopularItems.vue'
    export default {
        name: "category",
        props: ['category', 'SelectedItems', 'buttonClick'],
        components: {
            navbar,
            cat,
            PopularItems,
            foot,
        },
        data() {
            return {
                items: [],
                SelectedCategory: this.category
            }
        },
        async created() {
            if (this.category == undefined) {
                this.SelectedCategory = {name: '-'}
            }
            if (this.category != undefined) {
                let response = await this.$http.get('http://localhost:9000/category/findItemByCategory?id=' + this.category.id);
                this.items = response.data;
            }
            else{
                let response = await this.$http.get('http://localhost:9000/item/getList')
                this.items = response.data;
            }
        },
        methods: {
            changeItems(items) {
                this.items = items;
            },
        }
    }
</script>

<style scoped>

</style>