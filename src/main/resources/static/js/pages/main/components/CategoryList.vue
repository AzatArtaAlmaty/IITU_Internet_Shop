<template>
    <div style="margin-bottom: 5%;">
        <div>
            <div class="cat">
                <div class="m-auto">Categories</div>
            </div>
            <div class="m-auto mt-5 d-flex justify-content-center align-content-center flex-wrap mb-5" style="width: 50%;">
                <div class="card d-flex justify-content-center align-content-center m-2" v-for="i in categories" style="width: 20%; height: 150px;">
                    <router-link class="d-flex flex-column justify-content-center align-content-center" :to="{ name: 'cat', params: {category: i, buttonClick: buttonClick, SelectedItems: SelectedItems}}">
                        <img :src="'http://localhost:9000/img/' + i.filename" alt="Card image">
                        <div class="w-100 card-text d-inline-flex justify-content-center align-content-center mt-3" style="color: black;">{{i.name}}</div>
                    </router-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "CategoryList",
        props: ['categories', 'SelectedItems', 'buttonClick'],
        // data(){
        //     return { categories: null}
        // },
        // created() {
        //     this.$http.get('http://localhost:9000/category/all')
        //         .then(response => {this.categories = response.data});
        // },
    }
</script>

<style scoped>
    a, a:hover {
         color: white;
     }

    .card {
        background: #FFFFFF;
        border: 1px solid #000000;
        box-sizing: border-box;
        box-shadow: -4px 4px 10px rgba(0, 0, 0, 0.25);
        border-radius: 10px;
    }

    .card-text {
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 14px;
        line-height: 16px;
        text-align: center;
    }

    .cat {
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;
        line-height: 28px;
        text-align: center;
    }
</style>