<template>
    <div>
        <navbar />
        <div class="w-100" style=" height: 800px; background-image: url('http://localhost:9000/img/Rectangle_30.png'); background-repeat: no-repeat; background-size: cover">
            <div class="w-100 d-flex flex-column" style="">
                <div class="E404 mr-auto ml-auto mb-3" align="center" style="width: 20%;">404</div>
                <div class="nonF mr-auto ml-auto mb-4" align="center" style="width: 20%;">Страница не найдена</div>
                <button class="btn btn-dark mr-auto ml-auto mt-3" align="center" style="width: 20%;">НА ГЛАВНУЮ</button>
            </div>
        </div>
        <foot />
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import foot from 'pages/components/foot.vue'
    export default {
        name: "404",
        components: {
            navbar,
            foot
        }
    }
</script>

<style scoped>
    .E404 {
        margin-top: 15%;
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 144px;
        line-height: 169px;
        letter-spacing: 0.1em;
        color: #FEC901;
    }

    .nonF {
        font-family: Roboto;
        font-style: normal;
        font-weight: normal;
        font-size: 18px;
        line-height: 21px;
        /* identical to box height */

        letter-spacing: 0.1em;

        color: #000000;
    }

    .btn-dark{
        background: #000000;
        border: 2px solid #000000;
        box-sizing: border-box;
        border-radius: 0;
    }
</style>