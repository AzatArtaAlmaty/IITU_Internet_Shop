<template>
    <div>
        <navbar />
        <div class="container-fluid mb-5 mt-5">
            <div class="row">
                <ItemsList :items="items"/>
                <CreateForm :items="items" :token="token"/>
<!--                <create-category />-->
            </div>
        </div>
        <foot />
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import ItemsList from 'pages/admin/components/ItemsList.vue'
    import CreateForm from 'pages/admin/components/CreateForm.vue'
    import CreateCategory from 'pages/admin/components/createCategory.vue'
    import foot from 'pages/components/foot.vue'
    export default {
        name: "rgbh",
        props: ['token'],
        components: {
            navbar,
            ItemsList,
            CreateForm,
            CreateCategory,
            foot,
        },
        data() {
            return {
                items: [],
            }
        },
        async created() {
            this.$http.get('http://localhost:9000/item/getList')
                .then(async response => {
                    console.log(response)
                    for (const item of response.data) {
                        let resp = await this.$http.get('http://localhost:9000/category/get?id=' + item.category);
                        item.category = resp.data;
                        this.items.push(item)
                    }
                });
        }
    }
</script>

<style scoped>

</style>