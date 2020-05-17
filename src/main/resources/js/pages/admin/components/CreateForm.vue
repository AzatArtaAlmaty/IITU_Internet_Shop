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
                <dropdown :options="category"
                          :selected="selectedCategory"
                          v-on:updateOption="methodToRunOnSelect"
                          :placeholder="'Select an Item'"
                          :closeOnOutsideClick="true">
                </dropdown>
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
    import dropdown from 'pages/components/Dropdown.vue'
    export default {
        name: "CreateForm",
        props: ['items', 'token'],
        components: {
            dropdown
        },
        data() {
            return{
                name: '',
                count: '',
                price: '',
                category: '',
                info: '',
                image: '',
                selectedCategory: '',
            }
        },
        async created() {
            let resp = await this.$http.get('http://localhost:9000/category/all');
            this.category = resp.data;
        },
        methods: {
            fileChange(event) {
                console.log(event.target.files[0])
                this.image = event.target.files[0]
            },
            CreateItem: async function() {
                let catId = await this.$http.get('http://localhost:9000/category/findCatByName?name' + this.categoryName)
                let json = {
                    'name': this.name,
                    'count': this.count,
                    'price': this.price,
                    'category': this.selectedCategory.id,
                    'info': this.info
                }
                let data = new FormData();
                data.append('body', json);
                data.append('image', this.image);
                this.$http.post("http://localhost:9000/item/create", data, {'headers': {'Content-Type': 'multipart/form-data', Authorization: "Bearer " + this.token}})
            },
            methodToRunOnSelect(cat) {
                this.selectedCategory = cat;
            },
        }
    }
</script>

<style scoped>

</style>