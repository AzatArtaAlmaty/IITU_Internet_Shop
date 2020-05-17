<template>
    <div>
        <navbar />
        <div class="container-fluid">
            <div class="w-100 d-inline-flex justify-content-start align-content-center mt-5">
                <div class="w-50 d-inline-flex ml-5 flex-wrap" style="height: 500px;">
                    <div class="w-100 d-inline-flex">
                        <div v-bind:class="{ nomer: !turn, nomer2: turn }" class="mr-3" align="center">1</div>
                        <div style="align-self: center;">ДОСТАВКА</div>
                        <div v-bind:class="{ nomer: turn, nomer2: !turn }"class="mr-3 ml-5" align="center">2</div>
                        <div style="align-self: center;">ОПЛАТА</div>
                    </div>
                    <div v-if="!turn" class="d-inline-flex flex-wrap">
                        <div class="input-container mt-4 mr-5">
                            <input v-model="cart.lastName" type="text" required=""/>
                            <label>Фамилия</label>
                        </div>
                        <div class="input-container mt-4">
                            <input v-model="cart.firstName" type="text" required=""/>
                            <label>Имя</label>
                        </div>
                        <div class="input-container mr-5" style="margin-top: 12px;">
                            <dropdown style="background: inherit; padding-left: 0px; margin-bottom: 0px;" class="w-100" :options="[{'name': 'Almaty'}, {'name': 'Astana'}]"
                                      :selected="{'name': 'Almaty'}"
                                      v-on:updateOption="methodToRunOnSelect"
                                      :placeholder="'Select an Item'"
                                      :closeOnOutsideClick="true">
                            </dropdown>
                            <hr style="margin-top: 0px;border-top: 1px solid #555;"></hr>
                        </div>
                        <div class="input-container mt-4">
                            <input v-model="cart.region" type="text" required=""/>
                            <label>Регион</label>
                        </div>
                        <div class="input-container mt-4" style="width: 97%;">
                            <input v-model="cart.address" type="text" required=""/>
                            <label>Адрес</label>
                        </div>
                        <div class="input-container mt-4 mr-5">
                            <input v-model="cart.postIndex" type="text" required=""/>
                            <label>Почтовый индекс</label>
                        </div>
                        <div class="input-container mt-4">
                            <input v-model="cart.phone" type="text" required=""/>
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
                    <div class="w-100 d-flex justify-content-center align-content-center m-5" style="height: 50px;">
                        <button @click="click" class="btn btn-light">{{btnText}}</button>
                    </div>
                </div>
                <div class="w-50">
                    <div class="d-flex flex-column justify-content-start align-content-start m-3" v-for="item in items" style="width: 80%; height: auto">
                        <div class="d-flex justify-content-start align-content-start">
                            <div class="d-inline-flex mr-5"><img :src="'https://seadev.kz/img/' + item.filename" alt="Card image" style="width: 150px;"></div>
                            <div class="d-flex justify-content-start align-content-start flex-wrap" style="color: black;">
                                <div class="mr-4">{{item.name}}</div>
                                <div>{{item.price}}</div>
                                <div class="w-100 mt-3">Количество: <span @click="counterMinus(item)">-</span> {{ item.counter }} <span @click="item.counter += 1">+</span></div>
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
    import shoppingList from "pages/cart/components/shoppingList.vue"
    import dropdown from 'pages/components/Dropdown.vue'
    export default {
        name: "checkout",
        data() {
            return {
                items: this.$route.params.items,
                turn: false,
                counter: 0,
                btnText: "ПЕРЕЙТИ К ОПЛАТЕ",
                cart: {
                    cost: 0,
                    firstName: "",
                    lastName: "",
                    address: "",
                    phone: "",
                    city: "",
                    region: "",
                    postIndex: "",
                    items: []
                }
            }
        },
        components: {
            navbar,
            foot,
            shoppingList,
            dropdown
        },
        methods: {
            methodToRunOnSelect(cat) {
                this.cart.city = cat.name;
            },
            counterMinus(item) {
                if (item.counter >= 2) item.counter -= 1;
                else this.items.splice(this.items.findIndex(x => x === item), 1);
            },
            async click() {
                console.log(this.items)
                this.turn = true
                if (this.btnText === "ОПЛАТИТЬ") {
                    let cost = 0;
                    this.items.forEach(item => {
                        cost += (item.price * item.counter)
                        this.cart.items.push({"item": item.id, count: item.counter})
                    });
                    this.cart.cost = cost;
                    console.log(this.cart)
                    let res = await this.$http.post("http://localhost:9000/cart/create", this.cart)
                    if (res.status === 200) {
                        this.cart = {cost: 0, firstName: "", lastName: "", address: "", phone: "", city: "", region: "", postIndex: "", items: []}
                        this.items = []
                        this.turn = fal
                    }
                }
                this.btnText = "ОПЛАТИТЬ"
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

    .dropdown-toggle1{
        background: inherit;
    }
</style>