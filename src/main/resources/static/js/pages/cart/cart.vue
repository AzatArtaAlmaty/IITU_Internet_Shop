<template>
    <div>
        <navbar />
        <div class="container">
            <div class="row">
                <h1 class="w-100">Корзина</h1>
                <hr>
                <div class="mt-5 d-flex justify-content-center align-content-center flex-wrap">
                    <div class="card bg-dark text-white m-4" style="width: 18rem;" v-for="i in items">
                        <img class="card-img" :src="'data:image/png;base64,' + i.image" alt="Card image">
                        <div class="row card-img-overlay d-flex justify-content-center align-content-end">
                            <h5 class="card-title">{{i.name}}</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    export default {
        name: "cart",
        data() {
            return {
                "items": this.$route.params.items
            }
        },
        components: {
            navbar,
        },
        created() {
            console.log(this.items)
        }
    }
</script>

<style scoped>

</style>