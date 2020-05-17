<template>
    <div>
        <nav class="navbar navbar-expand-lg navbar-dark bg">
            <router-link class="navbar-brand" :to="{ name: 'app' }">outfit</router-link>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <router-link :to="{ name: 'cart', params: {items: this.SelectedItems } }"><img class="navbar-brand" src="http://localhost:9000/img/loop.svg" alt=""></router-link>
                    </li>
                    <li class="nav-item active">
                        <router-link :to="{ name: 'cart', params: {items: this.SelectedItems } }"><img class="navbar-brand" src="http://localhost:9000/img/Cart.svg" alt=""></router-link>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</template>

<script>
    export default {
        name: "navbar",
        props: ["SelectedItems"]
    }
</script>

<style scoped>
    a:hover {
        color: white;
        text-decoration: none;
    }

    a {
        color: white;
        text-decoration: none;
        background-color: transparent;
    }
    .bg{
        background-color: #000000;
    }
    .navbar-brand{
        color: #FFFFFF;
    }
</style>