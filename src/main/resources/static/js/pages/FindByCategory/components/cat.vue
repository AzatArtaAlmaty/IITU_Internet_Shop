<template>
    <div>
        <div class="row">
            <div class="search-block col-8 mb-5 mt-5">
                <div class="d-flex flex-row justify-content-center align-items-center">
                    <dropdown class="col-3" :options="categories"
                              :selected="selectedCategory"
                              v-on:updateOption="methodToRunOnSelect"
                              :placeholder="'Select an Item'"
                              :closeOnOutsideClick="true">
                    </dropdown>
                    <input v-model="ot" class="col-3 int ml-4" type="number" placeholder="Цена: от">
                    <input v-model="dO" class="col-3 ml-4 int" type="number" placeholder="Цена: до">
                    <button @click="search()" class="col-2 ml-4 int btn">Поиск</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import dropdown from 'pages/components/Dropdown.vue'
    export default {
        name: "cat",
        props: ["changeItems", "category"],
        components: {
            dropdown,
        },
        data() {
            return {
                categories: [],
                selectedCategory: this.category,
                ot: null,
                dO: null,
            }
        },
        methods: {
            methodToRunOnSelect(cat) {
                this.selectedCategory = cat;
            },
            async search() {
                let response = await this.$http.get('http://localhost:9000/item/search?cat=' + this.selectedCategory.id + '&before=' + this.ot + '&after=' + this.dO);
                this.changeItems(response.data)
            }
        },
        async created() {
            console.log(this.selectedCategory, this.category)
            let response = await this.$http.get('http://localhost:9000/category/all');
            this.categories.push({name: '-'});
            response.data.forEach(cat => {
                this.categories.push(cat)
            })
        },
        // watch: {
        //     category: async function (newCategory, oldCategory) {
        //         console.log(this.category)
        //         let response = await this.$http.get('http://localhost:9000/category/findItemByCategory?id=' + newCategory.id);
        //         this.changeItems(response.data)
        //     },
        // }
    }
</script>

<style scoped>
    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }

    /* Firefox */
    input[type=number] {
        -moz-appearance: textfield;
    }

    .search-block {
        background: #FEC901;
        box-shadow: -4px 4px 10px rgba(0, 0, 0, 0.25);
        margin: auto;
    }

    .int {
        height: 44px;
    }

    input {
        border-width: 0px;
    }

    .btn {
        border: 1px solid #000000;
        box-sizing: border-box;
    }
</style>