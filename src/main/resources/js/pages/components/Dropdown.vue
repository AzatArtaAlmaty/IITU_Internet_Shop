<template>
    <div class="btn-group1">
        <li @click="toggleMenu()" class="dropdown-toggle1" v-if="selectedOption.name !== undefined">
            {{ selectedOption.name }}
            <span class="caret1"></span>
        </li>

        <li @click="toggleMenu()" class="dropdown-toggle1" v-if="selectedOption.name === undefined">
            {{placeholderText}}
            <span class="caret1"></span>
        </li>

        <ul class="dropdown-menu1" v-if="showMenu">
            <li v-for="(option, idx) in options" :key="idx">
                <a href="javascript:void(0)" @click="updateOption(option)">
                    {{ option.name }}
                </a>
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: "Dropdown",
        data() {
            return {
                selectedOption: {
                    name: '',
                },
                showMenu: false,
                placeholderText: 'Please select an item',
            }
        },
        watch: {
            selected: function (val) {
                if (val !== undefined)
                    this.selectedOption = val;
            }
        },
        props: {
            options: {
                type: [Array, Object]
            },
            selected: {},
            placeholder: [String],
            closeOnOutsideClick: {
                type: [Boolean],
                default: true,
            },
        },
        mounted() {
            this.selectedOption = this.selected;
            if (this.placeholder)
            {
                this.placeholderText = this.placeholder;
            }
            if (this.closeOnOutsideClick) {
                document.addEventListener('click', this.clickHandler);
            }
        },
        beforeDestroy() {
            document.removeEventListener('click', this.clickHandler);
        },
        methods: {
            updateOption(option) {
                this.selectedOption = option;
                this.showMenu = false;
                this.$emit('updateOption', this.selectedOption);
            },
            toggleMenu() {
                this.showMenu = !this.showMenu;
            },
            clickHandler(event) {
                const { target } = event;
                const { $el } = this;
                if (!$el.contains(target)) {
                    this.showMenu = false;
                }
            },
        }
    }
</script>

<style scoped>
    .btn-group1 {
        min-width: 160px;
        height: 40px;
        position: relative;
        margin: 10px 1px;
        display: inline-block;
        vertical-align: middle;
    }
    .btn-group a:hover {
        text-decoration: none;
    }
    .dropdown-toggle1 {
        background: white;
        color: #636b6f;
        min-width: 160px;
        padding: 10px 20px 10px 10px;
        text-transform: none;
        font-weight: 300;
        margin-bottom: 7px;
        border: 0;
        transition: background 0s ease-out;
        float: none;
        box-shadow: none;
        border-radius: 0;
        white-space: nowrap;
        text-overflow: ellipsis;
        overflow: hidden;
    }
    .dropdown-toggle1:hover {
        background: white;
        cursor: pointer;
    }
    .dropdown-menu1 {
        position: absolute;
        z-index: 1000;
        float: left;
        padding: 5px 0;
        width: 94%;
        margin: 2px 0 0;
        list-style: none;
        font-size: 14px;
        text-align: left;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175);
        background-clip: padding-box;
    }
    .dropdown-menu1 > li > a {
        padding: 10px 30px;
        display: block;
        clear: both;
        font-weight: normal;
        line-height: 1.6;
        color: #333333;
        white-space: nowrap;
        text-decoration: none;
    }
    .dropdown-menu1 > li > a:hover {
        background: #efefef;
        color: #409FCB;
    }
    .dropdown-menu1 > li {
        overflow: hidden;
        width: 100%;
        position: relative;
        margin: 0;
    }
    .caret1 {
        width: 0;
        position: absolute;
        top: 19px;
        height: 0;
        margin-left: -24px;
        vertical-align: middle;
        border-top: 4px dashed;
        border-top: 4px solid \9;
        border-right: 4px solid transparent;
        border-left: 4px solid transparent;
        right: 10px;
    }
    li {
        list-style: none;
    }
    .col-1, .col-2, .col-3, .col-4, .col-5, .col-6, .col-7, .col-8, .col-9, .col-10, .col-11, .col-12, .col, .col-auto, .col-sm-1, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9, .col-sm-10, .col-sm-11, .col-sm-12, .col-sm, .col-sm-auto, .col-md-1, .col-md-2, .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-md-10, .col-md-11, .col-md-12, .col-md, .col-md-auto, .col-lg-1, .col-lg-2, .col-lg-3, .col-lg-4, .col-lg-5, .col-lg-6, .col-lg-7, .col-lg-8, .col-lg-9, .col-lg-10, .col-lg-11, .col-lg-12, .col-lg, .col-lg-auto, .col-xl-1, .col-xl-2, .col-xl-3, .col-xl-4, .col-xl-5, .col-xl-6, .col-xl-7, .col-xl-8, .col-xl-9, .col-xl-10, .col-xl-11, .col-xl-12, .col-xl, .col-xl-auto {
        padding-right: 0;
    }
</style>