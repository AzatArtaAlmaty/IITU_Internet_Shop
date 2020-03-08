<template>
    <div>
        <h1>Items</h1>
        <hr>
        <div class="mt-5 d-flex justify-content-center align-content-center flex-wrap">
            <div @click="clickItem(i)" class="card bg-dark text-white m-4" style="width: 18rem;" v-for="i in items">
<!--                    <router-link :to="{ name: 'CategoryInfo', params: {categoryId: i.id } }">-->
                    <img class="card-img" :src="'data:image/png;base64,' + i.image" alt="Card image">
                    <div class="row card-img-overlay d-flex justify-content-center align-content-end">
                        <h5 class="card-title">{{i.name}}</h5>
                    </div>
<!--                    </router-link>-->
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ItemLstByCategory",
        props: ["selectedItem"],
        data(){
            return {
                items: [],
                id: this.$route.params.id
            }
        },
        created() {
            this.$http.get('http://localhost:9000/category/get?id='+ this.id)
                .then(response => {
                    console.log(response['data']['items'])
                    response['data']['items'].forEach(item => {
                        this.items.push(item)
                    })
                });
        },
        methods: {
            clickItem (event){
                this.selectedItem.push(event)
                this.$emit("item", this.selectedItem)
            }
        }
    }
</script>
<style scoped>

</style>