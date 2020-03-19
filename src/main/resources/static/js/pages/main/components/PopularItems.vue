<template>
    <div style="margin-bottom: 5%;">
        <div>
            <div class="cat">
                <div class="m-auto">POPULAR CLOTHES</div>
            </div>
            <div class="m-auto mt-5 d-flex justify-content-center align-content-center flex-wrap mb-5" style="width: 50%;">
                <div class="card d-flex justify-content-center align-content-center m-2" v-for="i in items" style="width: 20%; height: auto;">
<!--                    <router-link class="d-flex flex-column justify-content-center align-content-center" :to="{ name: 'CategoryInfo', params: {id: i.id } }">-->
                        <img :src="'http://localhost:9000/img/' + i.filename" alt="Card image">
                        <div class="w-100 card-text d-inline-flex justify-content-center align-content-center mt-3" style="color: black;">{{i.price}} KZT</div>
                        <div class="w-100 card-text1 d-inline-flex justify-content-center align-content-center mt-3" style="color: black;">{{i.name}}</div>
                        <div class="w-100 d-inline-flex justify-content-center align-content-center mt-3 mb-3" style="color: black;">
                            <input type="button" class="btn btn-warning btnP" value="В КОРЗИНУ">
                        </div>
<!--                    </router-link>-->
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "PopularItems",
        data(){
            return { items: null}
        },
        created() {
            this.$http.get('http://localhost:9000/item/getList')
                .then(response => { console.log(response.data); this.items = response.data});
        },
    }
</script>

<style scoped>
    a, a:hover {
        color: white;
    }

    .card {
        background: #FEC901;
    }

    .card-text {
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 13px;
        line-height: 15px;
        letter-spacing: 0.1em;
    }

    .card-text1 {
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 11px;
        line-height: 13px;
        /* identical to box height */

        letter-spacing: 0.1em;

        color: #4F4F4F;
    }

    .cat {
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;
        line-height: 28px;
        text-align: center;
    }

    .btnP {
        border: 1px solid #000000;
        box-sizing: border-box;
    }

    .btn-warning{
        background: #FEC901;
    }
</style>