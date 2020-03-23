<template>
    <div>
        <navbar />
        <div class="container-fluid">
            <shoppingList :items="items"/>
        </div>
        <footer />
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import footer from 'pages/components/foot.vue'
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
            footer,
            shoppingList,
        },
        created() {
            console.log(this.items)
        }
    }
</script>

<style scoped>

</style>