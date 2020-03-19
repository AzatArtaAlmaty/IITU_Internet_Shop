<template>
    <div>
        <navbar />
        <div class="container-fluid">
            <cat />
        </div>
        <foot />
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import foot from 'pages/components/foot.vue'
    import cat from 'pages/FindByCategory/components/cat.vue'
    export default {
        name: "category",
        components: {
            navbar,
            cat,
            foot,
        },
    }
</script>

<style scoped>

</style>