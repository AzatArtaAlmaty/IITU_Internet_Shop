<template>
    <div>
        <navbar :selectedItems="selectedItems"/>
        <items @item="changeItem" :selectedItem="selectedItems"/>
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import items from 'pages/itemsByCategory/components/ItemLstByCategory.vue'
    export default {
        name: "CategoryInfo",
        data() {
            return {
                selectedItems: []
            }
        },
        components: {
            navbar,
            items,
        },
        methods: {
            changeItem (items) {
                this.selectedItems = items
                console.log(this.selectedItems)
            }
        }
    }
</script>

<style scoped>

</style>