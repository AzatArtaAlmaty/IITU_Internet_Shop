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
        name: "editCat",
        props: ['cat', 'token', 'type', 'ChangeCategories'],
        created() {
            console.log(this.cat)
        },
        data() {
            return { message: '', image: null}
        },
        methods: {
            close() {
                this.$emit('close');
            },
            async save() {
                let data = new FormData();
                data.append('body', JSON.stringify(this.cat));
                data.append('file', this.image);
                console.log(this.cat)
                if (this.type === 'edit'){
                    this.$http.post("http://localhost:9000/category/update", data, {'headers': {'Content-Type': 'multipart/form-data', Authorization: "Bearer " + this.token}}).then(async response => {
                        if (response['status'] === 200) {
                            this.message = 'Success';
                            this.$refs['my-modal'].show();
                            this.image = '';
                            this.$emit('close');
                            let data = await this.$http.get("http://localhost:9000/category/get?id=" + response.data);
                            this.ChangeCategories(data.data);
                        } else
                            this.message = 'Error'
                    })
                }
                if (this.type === 'new') {
                    try {
                        let response = await this.$http.post("http://localhost:9000/category/create", data, {'headers': {'Content-Type': 'multipart/form-data', Authorization: "Bearer " + this.token}})
                        if (response.status === 200) {
                            console.log(response);
                            this.image = '';
                            this.message = 'Success';
                            this.$refs['my-modal'].show();
                            this.$emit('close');
                            let data = await this.$http.get("http://localhost:9000/category/get?id=" + response.data);
                            this.ChangeCategories(data.data);
                        } else {
                            this.message = 'Error'
                            this.$refs['my-modal'].show();
                        }
                    }catch (e) {
                        this.message = 'Error'
                        this.$refs['my-modal'].show();
                    }
                }
            },
        },
    }
</script>

<style scoped>
    .modal-backdropEQ {
        position: fixed;
        z-index: 1;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        background-color: rgba(0, 0, 0, 0.3);
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .modalN {
        background: #FFFFFF;
        box-shadow: 2px 2px 20px 1px;
        overflow-x: auto;
        display: flex;
        flex-direction: column;
    }
    .modal-headerN,
    .modal-footerN {
        padding: 15px;
        display: flex;
    }
    .modal-headerN {
        border-bottom: 1px solid #eeeeee;
        color: #4AAE9B;
        justify-content: space-between;
    }
    .modal-footerN {
        border-top: 1px solid #eeeeee;
        justify-content: flex-end;
    }
    .modal-bodyN {
        position: relative;
        padding: 20px 10px;
    }
    .btn-closeN {
        border: none;
        font-size: 20px;
        padding: 20px;
        cursor: pointer;
        font-weight: bold;
        color: #4AAE9B;
        background: transparent;
    }
    .btn-greenN {
        color: white;
        background: #4AAE9B;
        border: 1px solid #4AAE9B;
        border-radius: 2px;
    }

    .text {
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 9px;
        line-height: 11px;
    }

    label {
        border-color: black;
    }
</style>