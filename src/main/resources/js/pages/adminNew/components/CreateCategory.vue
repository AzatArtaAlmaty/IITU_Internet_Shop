<template>
    <div>
        <!--        <transition name="modal-fade">-->
        <div class="modal-backdropEQ">
            <div class="w-50 modalN" role="dialog" aria-labelledby="modalTitle" aria-describedby="modalDescription">
                <header class="modal-headerN" id="modalTitle">
                    <slot name="header">
                        This is the default tile!

                        <button type="button" class="btn-closeN" @click="close" aria-label="Close modal">x</button>
                    </slot>
                </header>
                <section class="modal-bodyN">
                    <slot name="body">
                        <div class="d-flex flex-row">
                            <div class="ml-5 d-inline-flex w-25">
                                <img :src="'http://localhost:9000/img/' + cat.filename" alt="">
                            </div>
                            <div class="d-inline-flex w-75 flex-column justify-content-center">
                                <input v-model="cat.name" type="text" class="form-control" placeholder="Название Категорий">
                            </div>
                        </div>
                        <div class="form-group">
                            <b-form-file class="w-50 mt-5" v-model="image" ></b-form-file>
                            <!--                            <input @change="changeCatImage" type="file" class="form-control text" placeholder="Enter name" style="background: #FFFFFF; border-radius: 10px; width: 120px; height: 20px;">-->
                        </div>
                    </slot>
                </section>
                <footer class="modal-footerN">
                    <slot name="footer">
                        <b-button class="mr-3" variant="outline-secondary" @click="close">Close</b-button>
                        <b-button @click="save" variant="outline-primary">Save</b-button>
                    </slot>
                </footer>
            </div>
        </div>
        <!--        </transition>-->
        <b-modal ref="my-modal" title="Admin panel">
            <p>{{message}}</p>
        </b-modal>
    </div>
</template>

<script>
    export default {
        name: "categoryList",
        props: ['token', 'changeCatArr'],
        data() {
            return { cat: {name: ''}, message: '', image: null }
        },
        methods: {
            close() {
                this.$emit('close');
            },
            async save() {
                let data = new FormData();
                data.append('body', JSON.stringify(this.cat));
                data.append('file', this.image);
                let response = await this.$http.post("http://localhost:9000/category/create", data, {'headers': {'Content-Type': 'multipart/form-data', Authorization: "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ5IiwiZXhwIjoxNTg5Mzk5MzUwLCJpYXQiOjE1ODkzODEzNTB9.MYMyLamXGNhPByObOiYSuCgwNxWMV6-TvTNBNJklbC25lKYp-X5BuNdeV0Ln6X0n8tI-lVWh8H2PV8zz5Rx7DQ"}})
                    if (response['status'] === 200) {
                        console.log(response)
                        let category = await this.$http.get("http://localhost:9000/category/get?id=");
                        this.message = 'Success'
                        this.$refs['my-modal'].show()
                        this.$emit('close');
                    } else
                        this.message = 'Error'
            },
        },
    }
</script>

<style scoped>

</style>