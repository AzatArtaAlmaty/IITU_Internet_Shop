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
                            <div class="form-group">
                                <label >Item Name</label>
                                <input v-model="item.name" type="text" class="form-control" placeholder="Enter name">
                            </div>
                            <div class="form-group">
                                <label >Item Count</label>
                                <input v-model="item.count" type="text" class="form-control" placeholder="Enter count">
                            </div>
                            <div class="form-group">
                                <label >Item Price</label>
                                <input v-model="item.price" type="text" class="form-control" placeholder="Enter price">
                            </div>
                            <div class="form-group">
                                <label >Item Category</label>
                                <input v-model="item.category.name" type="text" class="form-control" placeholder="Enter Category">
                            </div>
                            <div class="form-group">
                                <label >About Item</label>
                                <textarea v-model="item.info" class="form-control" placeholder="Enter info" />
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
        name: 'modal',
        props: ['item'],
        data() {
            return { message: ''}
        },
        methods: {
            close() {
                this.$emit('close');
            },
            save() {
                console.log(this.item)
                this.$http.post("http://localhost:9000/item/update", this.item).then(response => {
                    if (response['status'] === 200) {
                        this.message = 'Success'
                        this.$refs['my-modal'].show()
                        this.$emit('close');
                    } else
                        this.message = 'Error'
                })
            },
        },
    };
</script>

<style scoped>
    .modal-backdropEQ {
        position: fixed;
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
</style>