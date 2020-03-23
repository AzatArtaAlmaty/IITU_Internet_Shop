<template xmlns="http://www.w3.org/1999/html">
        <div class="col-xl-5 col-lg-7 col-md-9 col-sm-10 col-12 d-flex flex-column">
            <h1 class="mb-3">All Items</h1>
            <ul class="list-group ml-5">
                <li class="list-group-item"><div class="w-25 d-inline-flex">Name</div> <div class="w-25 d-inline-flex">price</div> <div class="w-25 d-inline-flex">Category</div></li>
                <li class="list-group-item" v-for="i in items"> <div class="w-25 d-inline-flex">{{i.name}}</div> <div class="w-25 d-inline-flex">{{i.price}}</div> <div class="d-inline-flex w-25">{{i.category.name}}</div> <b-button class="mr-3" @click="showModal(i)">Edit</b-button> <b-button class="" @click="deleteItem(i)">X</b-button></li>
            </ul>
            <EditModal v-show="isModalVisible" @close="closeModal" :item="selectedItem"/>
        </div>

</template>

<script>
    import EditModal from 'pages/admin/components/EditModal.vue'
    export default {
        name: "ItemsList",
        props: ['items'],
        data() {
            return {
                selectedItem: {name: '', count: '', price: '', info: '', category: '', id: ''},
                isModalVisible: false,
            }
        },
        components: {
            EditModal,
        },
        methods: {
            showModal(item) {
                this.selectedItem = item
                this.isModalVisible = true;
            },
            closeModal() {
                this.selectedItem = {name: '', count: '', price: '', info: '', category: '', id: ''}
                this.isModalVisible = false;
            },
            deleteItem(item) {
                const params = new URLSearchParams();
                params.append('id', '' + item.id);
                this.$http.post("http://localhost:9000/item/delete", params).then(response => {
                    if (response['status'] === 200) {
                        console.log(response)
                        for (let i = 0; i < this.items.length; i++) {
                            let obj = this.items[i];

                            if (obj.id === item.id) {
                                this.items.splice(i, 1);
                                i--;
                            }
                        }
                    }
                })
            }
        },
    }
</script>

<style scoped>

</style>