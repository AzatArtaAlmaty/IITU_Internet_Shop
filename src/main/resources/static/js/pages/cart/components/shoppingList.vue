<template>
    <div style="margin-bottom: 5%;">
        <div>
            <div class="m-auto mt-5 d-flex justify-content-center align-content-center flex-wrap mb-5" style="width: 100%;">
                <div class="d-flex justify-content-start align-content-start m-5" v-for="i in items" style="width: 80%; height: auto">
                    <div class="d-inline-flex mr-5"><img :src="'http://localhost:9000/img/' + i.filename" alt="Card image"></div>
                    <div class="d-flex justify-content-start align-content-start flex-wrap" style="color: black;">
                        <div style="width: 100%;">{{i.name}}</div>
                        <div style="width: 100%;">{{i.price}}</div>
                        <div style="width: 100%;">{{i.info}}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "shoppingList",
        props: ['items'],
    }
</script>

<style scoped>

</style>