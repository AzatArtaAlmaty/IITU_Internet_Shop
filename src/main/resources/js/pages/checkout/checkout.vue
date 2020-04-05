<template>
    <div>
        <navbar />
        <div class="container-fluid">
            <div class="w-100 d-inline-flex justify-content-start align-content-center mt-5">
                <div class="w-50 d-inline-flex ml-5 flex-wrap">
                    <div class="w-100 d-inline-flex">
                        <div v-bind:class="{ nomer: !turn, nomer2: turn }" class="mr-3" align="center">1</div>
                        <div style="align-self: center;">ДОСТАВКА</div>
                        <div v-bind:class="{ nomer: turn, nomer2: !turn }"class="mr-3 ml-5" align="center">2</div>
                        <div style="align-self: center;">ОПЛАТА</div>
                    </div>
                    <div v-if="!turn" class="d-inline-flex flex-wrap">
                        <div class="input-container mt-4 mr-5">
                            <input type="text" required=""/>
                            <label>Фамилия</label>
                        </div>
                        <div class="input-container mt-4">
                            <input type="text" required=""/>
                            <label>Имя</label>
                        </div>
                        <div class="input-container mt-4 mr-5">
                            <input type="text" required=""/>
                            <label>Город</label>
                        </div>
                        <div class="input-container mt-4">
                            <input type="text" required=""/>
                            <label>Регион</label>
                        </div>
                        <div class="input-container mt-4" style="width: 97%;">
                            <input type="text" required=""/>
                            <label>Адрес</label>
                        </div>
                        <div class="input-container mt-4 mr-5">
                            <input type="text" required=""/>
                            <label>Почтовый индекс</label>
                        </div>
                        <div class="input-container mt-4">
                            <input type="text" required=""/>
                            <label>Номер телефона</label>
                        </div>
                    </div>
                    <div v-if="turn" class="d-inline-flex flex-wrap w-100">
                        <div class="input-container mt-4 mr-5" style="width: 55%">
                            <input type="text" required=""/>
                            <label>Номер карты</label>
                        </div>
                        <div class="input-container mt-4 mr-5" style="width: 32%;">
                            <input type="text" required=""/>
                            <label>Номер карты</label>
                        </div>
                        <div class="input-container mt-4 mr-5" style="width: 55%">
                            <input type="text" required=""/>
                            <label>Владелец карты</label>
                        </div>
                        <div class="input-container mt-4 mr-5" style="width: 32%;">
                            <input type="text" required=""/>
                            <label>CVV</label>
                        </div>
                    </div>
                    <div class="w-100 d-flex justify-content-center align-content-center m-5">
                        <button @click="turn = !turn" class="btn btn-light">ПЕРЕЙТИ К ОПЛАТЕ</button>
                    </div>
                </div>
                <div class="w-50">
                    <div class="d-flex flex-column justify-content-start align-content-start m-3" v-for="i in items" style="width: 80%; height: auto">
                        <div class="d-flex justify-content-start align-content-start">
                            <div class="d-inline-flex mr-5"><img :src="'http://localhost:9000/img/' + i.filename" alt="Card image" style="width: 150px;"></div>
                            <div class="d-flex justify-content-start align-content-start flex-wrap" style="color: black;">
                                <div class="mr-4">{{i.name}}</div>
                                <div>{{i.price}}</div>
                                <div class="w-100 mt-3">Количество: <span @click="counterMinus(i)">-</span> {{counter}} <span @click="counter += 1">+</span></div>
                            </div>
                        </div>
                        <hr class="w-100 mt-5" style="background-color: black;">
                    </div>
                </div>
            </div>
        </div>
        <foot />
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import foot from 'pages/components/foot.vue'
    import shoppingList from "pages/cart/components/shoppingList.vue";
    export default {
        name: "checkout",
        data() {
            return {
                items: this.$route.params.items,
                turn: false,
                counter: 0
            }
        },
        components: {
            navbar,
            foot,
            shoppingList,
        },
        methods: {
            counterMinus(item) {
                if (this.counter >= 2) this.counter -= 1;
                else this.items.splice(this.items.findIndex(x => x === item), 1);
            }
        }
    }
</script>

<style scoped>
    .nomer {
        width: 30px;
        height: 30px;
        background: #FEC901;
        border: 1px solid #000000;
        box-sizing: border-box;
    }

    .nomer2 {
        width: 30px;
        height: 30px;
        background: #FFFFFF;
        border: 1px solid #000000;
        box-sizing: border-box;
    }

    .input-container{
        position:relative;
        margin-bottom:25px;
        width: 45%;
    }
    .input-container label{
        position:absolute;
        top:0px;
        left:0px;
        font-size:16px;
        color: #828282;
        pointer-event:none;
        transition: all 0.5s ease-in-out;
    }
    .input-container input{
        border:0;
        border-bottom:1px solid #555;
        background:transparent;
        width:100%;
        padding:8px 0 5px 0;
        font-size:16px;
        color:#fff;
    }
    .input-container input:focus{
        border:none;
        outline:none;
        border-bottom:1px solid #e74c3c;
    }

    .input-container input:focus ~ label,
    .input-container input:valid ~ label{
        top:-12px;
        font-size:12px;
    }

    .btn-light {
        background: inherit;
        border: 2px solid #000000;
        border-radius: 0;
    }

    .btn-light:hover, .btn-light:not(:disabled):not(.disabled):active,
    .btn-light:not(:disabled):not(.disabled).active, .show > .btn-light.dropdown-toggle,
    .btn-light:focus, .btn-light.focus {
        color: #212529;
         background-color: inherit;
         border-color: inherit;
    }
</style>