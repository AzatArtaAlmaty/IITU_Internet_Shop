<template>
    <div>
        <navbar :SelectedItems="SelectedItems"/>
        <div  class="d-flex justify-content-center align-content-center" style="height: 500px; ">
            <div class="m-auto d-flex justify-content-center align-content-center flex-wrap mb-5">
                <div class=" d-inline-flex flex-row" style="width: 70%; margin-right: 15%;">
                    <img :src="'http://localhost:9000/img/' + item.filename" alt="Card image" class="p-2 ml-4">
                    <div class="ml-4 d-inline-flex flex-column justify-content-start align-content-center mt-3" style="color: black;">
                        <div style="font-family: Roboto; font-style: normal; font-weight: normal; font-size: 36px; line-height: 42px; letter-spacing: 0.1em; margin-bottom: 30px;">{{item.name}}</div>
                        <div style="font-family: Roboto; font-style: normal; font-weight: normal; font-size: 24px; line-height: 28px; letter-spacing: 0.05em; color: #000000;">{{item.info}}</div>
                        <div class="mt-3">Цена: {{item.price}}</div>
                        <input @click="click(item)" type="button" class="mt-3 w-25" value="В Корзину" style="background: #FEC901; border: 2px solid #000000; box-sizing: border-box;"/>
                    </div>
                </div>
            </div>
        </div>
        <foot/>
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import foot from "pages/components/foot.vue";
    export default {
        name: "Description",
        props: ["item", "buttonClick", "SelectedItems"],
        components: {
            foot,
            navbar,
        },
        created() {
            console.log(this.item)
            if (this.item === undefined)
                this.$router.push({ name: 'app'})
        },
        methods: {
            click(i) {
                this.buttonClick(i);
            }
        }
    }
</script>

<style scoped>

</style>