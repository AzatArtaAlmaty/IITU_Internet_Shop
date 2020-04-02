<template>
    <div>
        <nav class="navbar navbar-expand-lg navbar-dark bg">
            <a class="navbar-brand" href="#">outfit</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <router-link :to="{ name: 'cart', params: {items: this.SelectedItems } }"><a class="navbar-brand" href="#"><img src="C:/Users/Sulpak/Documents/If you delete need files/Design/Projects/Outfit/img/Cart.svg" alt=""></a></router-link>
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