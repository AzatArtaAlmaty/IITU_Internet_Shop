<template>
    <div class="col-xl-5 col-lg-7 col-md-9 col-sm-10 col-12 mb-5" style="position: inherit">
        <h1>Create Item</h1>
        <hr>
        <div class="ml-4">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Enter Item name" name="name" v-model="name">
            </div>
            <div>
                <input  @change="fileChange" type="file"><!-- @change="fileChange" @click="CreateItem"-->
            </div>
            <div class="d-flex justify-content-end">
                <b-button @click="CreateCategory" class="mt-3 ml-3 w-25 d-inline-flex" variant="outline-success" block>Save</b-button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "createCategory",
        data() {
            return {
                name: "",
                img: [],
                categories: []
            }
        },
        async created() {
            let data = await this.$http.get("http://localhost:9000/category/all")
            console.log(data.data)
            data.data.forEach(item => {
                this.categories.push(item)
            })
        },
        methods: {
            fileChange(event) {
                console.log(event.target.files[0])
                this.image = event.target.files[0]
                // event.target.files[0] = ''
            },
            CreateCategory: async function () {
                let data = {
                    "name": this.name
                }
                let response = await this.$http.post("http://localhost:9000/category/create", data)
                console.log(response['data'])
                data.id = response['data']
                this.categories.push(data)
                this.name = ''
                console.log(response)
                data = new FormData();
                data.append('id', response['data']);
                data.append('image', this.image);
                this.$http.post("http://localhost:9000/category/categoryImage", data, {'headers': {'Content-Type': 'multipart/form-data'}})
            },
        }
    }
</script>

<style scoped>

</style>