<template>
    <div>
        <div class="row">
            <div class="search-block col-10 mb-5 mt-5">
                <div class="d-flex flex-row justify-content-center align-content-center">
                    <dropdown class="col-2" :options="categories"
                              :selected="category"
                              v-on:updateOption="methodToRunOnSelect"
                              :placeholder="'Select an Item'"
                              :closeOnOutsideClick="true">
                    </dropdown>
                    <dropdown class="col-2" :options="categories"
                              :selected="category"
                              v-on:updateOption="methodToRunOnSelect"
                              :placeholder="'Select an Item'"
                              :closeOnOutsideClick="true">
                    </dropdown>
                    <dropdown class="col-2" :options="categories"
                              :selected="category"
                              v-on:updateOption="methodToRunOnSelect"
                              :placeholder="'Select an Item'"
                              :closeOnOutsideClick="true">
                    </dropdown>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import dropdown from 'pages/components/Dropdown.vue'
    export default {
        name: "cat",
        components: {
            dropdown,
        },
        data() {
            return{
                categories: [{
                    name: "test"
                }, {
                    name: "test1"
                }, {
                    name: "test2"
                }, {
                    name: "test3"
                }, {
                    name: "test4"
                }],
                category: {
                    name: "test4"
                },

            }
        },
        methods: {
            methodToRunOnSelect(cat) {
                this.category = cat;
            }
        }
    }
</script>

<style scoped>
    .search-block {
        background: #FEC901;
        box-shadow: -4px 4px 10px rgba(0, 0, 0, 0.25);
        margin: auto;
    }
</style>