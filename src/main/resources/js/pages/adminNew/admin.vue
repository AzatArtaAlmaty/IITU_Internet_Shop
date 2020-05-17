<template>
    <div>
        <navbar />
        <div class="container">
            <div class="row">
                <div class="mt-5 d-flex flex-row w-100 justify-content-center align-content-center">
                    <input @click="showModalCat({name: '', filename: 'Group 27.png'}, 'new')" class="text" type="button" value="Создать категорию" style="background: #FEC901; border: 1px solid #000000; box-sizing: border-box; width: 250px; height: 60px;"/>
                    <input @click="showModalItem({filename: 'Group 27.png'}, 'new')" class="ml-3 text" type="button" value="Создать товар" style="background: white; border: 1px solid #000000; box-sizing: border-box; width: 250px; height: 60px;"/>
                </div>

                <h2 class="mt-5 mb-4 text">Список категории</h2>

                <div class="d-flex flex-row w-100 justify-content-center align-content-center mb-5 ">
                    <div style="background: #DDE3E9; border: 1px solid #000000; box-sizing: border-box; width: 920px;">
                        <div class="d-flex flex-row w-100 justify-content-start align-content-center" style="height: 80px;">
                            <button class="ml-3 textInTable" style="margin-bottom: auto; margin-top: auto; background: #F2F2F2; border: 1px solid #000000; box-sizing: border-box; width: 146.25px; height: 25px;"><img class="mr-2" src="http://localhost:9000/img/ant-design_plus-circle-outlined.svg">Добавить категорию</button>
                        </div>
                        <hr>
                        <div v-for="(i, idx) in category">
                            <div class="d-flex flex-row w-100 justify-content-start align-content-center" style="height: 80px;">
                                <div class="d-flex flex-row w-50 justify-content-start align-content-center">
                                    <img class="ml-5 mr-5 mt-3 mb-3" :src="'http://localhost:9000/img/' + i.filename" style="width: 100px;">
                                    <p class="mt-auto mb-auto">{{i.name}}</p>
                                </div>
                                <div class="d-flex flex-row w-50 justify-content-end align-content-center">
                                    <button @click="showModalCat(i, 'edit')" class="mr-3 textInTable" style="margin-bottom: auto; margin-top: auto; background: #F2F2F2; border: 1px solid #000000; box-sizing: border-box; width: 112.5px; height: 25px;">Изменить</button>
                                    <button @click="deleteCat(i)" class="mr-5 textInTable" style="margin-bottom: auto; margin-top: auto; background: #F2F2F2; border: 1px solid #000000; box-sizing: border-box; width: 112.5px; height: 25px;">Удалить</button>
                                </div>
                            </div>
                            <hr v-if="(Object.keys(category).length - idx ) > 1">
                        </div>
                    </div>
                </div>
            </div>
            <h2 class="mt-5 mb-4 text">Список категории</h2>

            <div class="d-flex flex-row w-100 justify-content-center align-content-center mb-5 ">
                <div style="background: #DDE3E9; border: 1px solid #000000; box-sizing: border-box; width: 920px;">
                    <div class="d-flex flex-row w-100 justify-content-start align-content-center" style="height: 80px;">
                        <button class="ml-3 textInTable" style="margin-bottom: auto; margin-top: auto; background: #F2F2F2; border: 1px solid #000000; box-sizing: border-box; width: 146.25px; height: 25px;"><img class="mr-2" src="http://localhost:9000/img/ant-design_plus-circle-outlined.svg">Добавить категорию</button>
                    </div>
                    <hr>
                    <div v-for="(i, idx) in items">
                        <div class="d-flex flex-row w-100 justify-content-start align-content-center" style="height: 80px;">
                            <div class="d-flex flex-row w-50 justify-content-start align-content-center">
                                <img class="ml-5 mr-5 mt-3 mb-3" :src="'http://localhost:9000/img/' + i.filename" style="width: 56px; height: 56px;">
                                <p class="mt-auto mb-auto mr-3">{{i.name}}</p>
                            </div>
                            <div class="d-flex flex-row w-50 justify-content-end align-content-center">
                                <button @click="showModalItem(i, 'show')" class="mr-3 textInTable" style="margin-bottom: auto; margin-top: auto; background: #F2F2F2; border: 1px solid #000000; box-sizing: border-box; width: 112.5px; height: 25px;">Подробнее</button>
                                <button @click="showModalItem(i, 'edit')" class="mr-3 textInTable" style="margin-bottom: auto; margin-top: auto; background: #F2F2F2; border: 1px solid #000000; box-sizing: border-box; width: 112.5px; height: 25px;">Изменить</button>
                                <button @click="deleteItem(i)" class="mr-5 textInTable" style="margin-bottom: auto; margin-top: auto; background: #F2F2F2; border: 1px solid #000000; box-sizing: border-box; width: 112.5px; height: 25px;">Удалить</button>
                            </div>
                        </div>
                        <hr v-if="(Object.keys(category).length - idx ) > 1">
                    </div>
                </div>
            </div>
            <edit-cat :token="token" v-show="isModalVisible" @close="closeModalCat" :cat="selectedCat" :type="type" :ChangeCategories="ChangeCategories"/>
            <edititem :token="token" v-show="isModalVisibleItem" @close="closeModalItem" :type="type" :ChangeItems="ChangeItem" :item="selectedItem" :categories="category"/>
        </div>
        <foot />
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import foot from 'pages/components/foot.vue'
    import edititem from 'pages/adminNew/components/edititem.vue'
    import editCat from 'pages/adminNew/components/editCat.vue'
    import CreateCategory from 'pages/adminNew/components/CreateCategory.vue'
    export default {
        name: "admin",
        props: ["token"],
        data() {
            return{
                type: '',
                items: [],
                category: [],
                isModalVisible: false,
                isModalVisibleItem: false,
                selectedItem: {name: '', count: '', price: '', category: { name: '' }, info: '', filename: 'Group 27.png'},
                selectedCat: {name: '', filename: 'Group 27.png'},
            }
        },
        components: {
            edititem,
            navbar,
            foot,
            editCat,
            CreateCategory
        },
        async created() {
            if (this.token === undefined)
                this.$router.push({ name: 'auth'})
            let { data: items } = await this.$http.get('http://localhost:9000/item/getList')
            let { data: category } = await this.$http.get('http://localhost:9000/category/all')
            for (let item of items) {
                let cat = await this.$http.get("http://localhost:9000/category/get?id=" + item.category)
                item.category = cat.data;
            }
            this.items = items;
            this.category = category;
        },
        methods: {
            ChangeCategories(cat) {
                let index = this.category.findIndex(n => n.id === cat.id);
                if (index != -1)
                    this.category[index] = cat;
                else
                    this.category.push(cat);
            },
            ChangeItem(item) {
                console.log(item)
                let index = this.items.findIndex(n => n.id === item.id);
                console.log(index);
                if (index != -1)
                    this.items[index] = item;
                else
                    this.items.push(item);
            },
            closeModalItem() {
                this.selectedItem = {name: '', count: '', price: '', info: '', category: '', id: ''};
                this.isModalVisibleItem = false;
            },
            showModalItem(item, type) {
                this.type = type
                this.selectedItem = item;
                this.isModalVisibleItem = true;
            },
            closeModalCat() {
                this.selectedCat = {name: ''}
                this.isModalVisible = false;
            },
            showModalCat(cat, type) {
                this.type = type
                this.selectedCat = cat
                this.isModalVisible = true;
            },
            async deleteCat(cat) {
                let response = await this.$http.get("http://localhost:9000/category/delete?id=" + cat.id, {'headers': {'Content-Type': 'multipart/form-data', Authorization: "Bearer " + this.token}});
                this.category = this.category.filter(n => n.id !== cat.id)

            },
            async  deleteItem(item) {
                let response = await this.$http.get("http://localhost:9000/item/delete?id=" + item.id, {'headers': {'Content-Type': 'multipart/form-data', Authorization: "Bearer " + this.token}});
                this.item = this.item.filter(n => n.id !== item.id)
            }
        }
    }
</script>

<style scoped>
    hr {
        background: #000000;
        margin: 0;
    }
    .text {
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;
        line-height: 28px;

        color: #000000;
    }

    .textInTable {
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 9px;
        line-height: 11px;
    }
</style>