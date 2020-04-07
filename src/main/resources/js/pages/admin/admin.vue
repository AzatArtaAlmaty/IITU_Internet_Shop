<template>
    <div>
        <navbar />
        <div class="container-fluid mb-5 mt-5">
            <div class="row">
                <ItemsList :items="items" />
                <CreateForm :items="items"/>
                <create-category />
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
        name: "admin",
        props: ['token'],
        components: {
            navbar,
            ItemsList,
            CreateForm,
            CreateCategory,
            foot,
        },
        data() {
            return { items: [] }
        },
        created() {
            const params = new URLSearchParams();
            params.append('id', '' + this.id);
            this.$http.get('http://localhost:9000/item/getList')
                .then(response => {
                    console.log(response)
                    response['data'].forEach(item => {
                        this.items.push(item)
                    })
                });
        }
    }
</script>

<style scoped>

</style>