<template>
    <div style="margin-bottom: 5%;">
        <div>
            <div class="m-auto mt-5 d-flex justify-content-center align-content-center flex-wrap mb-5" style="width: 100%;">
                <div class="d-flex flex-column justify-content-start align-content-start m-3" v-for="i in items" style="width: 80%; height: auto">
                    <div class="d-flex justify-content-start align-content-start">
                        <div class="d-inline-flex mr-5"><img :src="'https://seadev.kz/img/' + i.filename" alt="Card image"></div>
                        <div class="d-flex justify-content-start align-content-start flex-wrap" style="color: black;">
                            <div class="w-75">{{i.name}}</div>
                            <button @click="deleteItem(i)" class="btn krestik" type="reset" title="Click me to clear the input field">&times;</button>
                            <div class="w-100">{{i.price}}</div>
                            <div class="w-100">{{i.info}}</div>
                        </div>
                    </div>
                    <hr class="w-100 mt-5" style="background-color: black;">
                </div>
                <div class="d-flex justify-content-center align-content-center m-5" style="width: 80%; height: auto">
                    <router-link :to="{ name: 'checkout', params: {items: this.items }} " class="btn btn-light">ОПЛАТИТЬ</router-link>
                    <router-link :to="{ name: 'cart' }" class="btn btn-dark ml-4">НА ГЛАВНУЮ</router-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "shoppingList",
        props: ['items', 'deleteItem'],

    }
</script>

<style scoped>
      .krestik {
        color: #000000;
        margin-right: 0px;
        margin-left: auto;
          background: inherit;
    }

    .btn-dark{
        background: #000000;
        border: 2px solid #000000;
        box-sizing: border-box;
        border-radius: 0;
    }

    .btn-light{
        border: 2px solid #000000;
        box-sizing: border-box;
        border-radius: 0;
    }
</style>