<template>
    <div class="col-xl-5 col-lg-7 col-md-9 col-sm-10 col-12 mb-5" style="position: inherit">
        <h1>Create Item</h1>
        <hr>
        <div class="ml-4">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Enter Item name" name="name" v-model="name">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Enter Item count" name="count" v-model="count">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Enter Item price" name="price" v-model="price">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Enter Item Category Name" name="category" v-model="categoryName">
            </div>
            <div class="form-group">
                <textarea v-model="info" class="form-control" placeholder="info" name="info"/>
            </div>
            <div>
                <input @change="fileChange" type="file">
            </div>
            <div class="d-flex justify-content-end">
                <b-button class="mt-3 ml-3 w-25 d-inline-flex" variant="outline-success" block @click="CreateItem">Save</b-button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "CreateForm",
        props: ['items'],
        data() {
            return{
                name: '',
                count: '',
                price: '',
                categoryName: '',
                info: '',
                image: ''
            }
        },
        methods: {
            fileChange(event) {
                console.log(event.target.files[0])
                this.image = event.target.files[0]
            },
            CreateItem: async function() {
                let data = {
                    'name': this.name,
                    'count': this.count,
                    'price': this.price,
                    'category': {
                        'name': this.categoryName
                    },
                    'info': this.info
                }
                let response = await this.$http.post("http://localhost:9000/item/create", data)
                console.log(response)
                if (response['status'] === 200) {
                    data['id'] = response['data']
                    this.items.push(data)
                    this.name = ''
                    this.count = ''
                    this.price = ''
                    this.categoryName = ''
                    this.info = ''
                }
                console.log(response)
                data = new FormData();
                data.append('id', response['data']);
                data.append('image', this.image);
                this.$http.post("http://localhost:9000/item/itemImage", data, {'headers': {'Content-Type': 'multipart/form-data'}})
            }
        }
    }
</script>

<style scoped>

</style>