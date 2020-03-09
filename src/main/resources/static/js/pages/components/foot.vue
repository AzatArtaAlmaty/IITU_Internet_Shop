<template>
    <div>
        <footer class="footer">
            <div class="container-fluid bg-dark p-4 text-secondary">
                <a class="text-white text-decoration-none" href="#"><h5>outfit</h5></a>
                <p class="about" >OUTFIT - СЕТЬ КОНЦЕПТУАЛЬНЫХ МАГАЗИНОВ МУЖСКОЙ ОДЕЖДЫ С ШИРОКИМ АСОРТИМЕНТОМ НА ВСЕ СЛУЧАЙ ЖИЗНИ. ОСНОВАН В 2016 ГОДУ В ГОРОДЕ КАРАГАНДА</p>
                <div class="v-divider"></div>
            </div>
        </footer>
    </div>
</template>

<script>
    export default {
        name: "foot"
    }
</script>

<style scoped>
    .about{
        padding-bottom: 5%;
        margin-left: 10%;
        width: 30%;
        display: inline-block;
    }
    .v-divider{
        margin-left:5px;
        margin-right:5px;
        margin-bottom: 5px;
        width:1px;
        height:100px;
        border-left:1px solid white;
        display: inline-flex;
    }
</style>