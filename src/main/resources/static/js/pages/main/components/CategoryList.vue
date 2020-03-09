<template>
    <div class="container-fluid">
<!--        <div class="row-cols">-->
<!--            <div class="ml-5">-->
<!--                <h1 class="text-center">Categories</h1>-->
<!--            </div>-->
<!--            <div class="mt-5 d-flex justify-content-center align-content-center flex-wrap mb-5">-->
<!--                <div class="card bg-dark text-white m-4" style="width: 18rem;" v-for="i in categories">-->
<!--                    <router-link :to="{ name: 'CategoryInfo', params: {id: i.id } }">-->
<!--                        <img class="card-img" :src="data:image/jpg;base64, {i.image}" alt="Card image">-->
<!--                        <div class="row card-img-overlay d-flex justify-content-center align-content-end">-->
<!--                            <h5 class="card-title">{{i.name}}</h5>-->
<!--                        </div>-->
<!--                    </router-link>-->
<!--                </div>-->
<!--            </div>-->
<!--        </div>-->
    </div>
</template>

<script>
    export default {
        name: "CategoryList",
        data(){
            return { categories: null}
        },
        created() {
            this.$http.get('http://localhost:8080/category/all')
                .then(response => {this.categories = response.data});
        },
    }
</script>

<style scoped>
    a, a:hover {
         color: white;
     }
</style>