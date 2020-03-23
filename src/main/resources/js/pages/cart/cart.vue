<template>
    <div>
        <navbar />
        <div class="container-fluid">
            <shoppingList :items="items"/>
        </div>
        <foot />
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import foot from 'pages/components/foot.vue'
    import shoppingList from "pages/cart/components/shoppingList.vue";
    export default {
        name: "cart",
        data() {
            return {
                "items": this.$route.params.items
            }
        },
        components: {
            navbar,
            foot,
            shoppingList,
        },
        created() {
            console.log(this.items)
        }
    }
</script>

<style scoped>

</style>