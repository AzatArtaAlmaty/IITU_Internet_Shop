<template>
    <div style="background-image: url('http://localhost:9000/img/Union.jpg')">
        <navbar />
        <div class="bg">
            <div class="top-content">
                <div class="inner-bg">
                    <div class="hello">
                        <div class="img-hello">
                        </div>
                    </div>
                    <div class="container bg-warning" style="width:65%; box-shadow: 5px 5px 1px rgba(0, 0, 0, 0.04), 0px 0px 2px rgba(0, 0, 0, 0.06), 5px 4px 8px rgba(0, 0, 0, 0.04);">
                        <div class="col-5 p-5 ml-4">
                            <h2>Войти как Админ</h2>
                            <form>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Username</label>
                                    <input v-model="login" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input v-model="password" type="password" class="form-control" id="exampleInputPassword1">
                                </div>
                                <div class="form-group form-check">
                                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">Запомнить</label>
                                </div>
                                <router-link class="text-decoration-none " :to="{name: 'login'}">
                                    <div class="w-100 d-inline-flex justify-content-center align-content-center mt-3 mb-3" style="color: black;">
                                        <input @click="click" type="button" class="btn btn-warning btnP" value="ВОЙТИ">
                                    </div>
                                </router-link>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <foot />
    </div>
</template>

<script>
    import navbar from 'pages/components/navbar.vue'
    import foot from 'pages/components/foot.vue'
    export default {
        name: "auth.vue",
        components: {
            navbar,
            foot,
        },
        data() {
            return {
                login: "",
                password: "",
                local: {
                    token: ""
                }
            }
        },
        methods: {
            async click() {
                let data = {
                    "username": this.login,
                    "password": this.password
                };
                console.log(data)
                try {
                    data = await this.$http.post("http://localhost:9000/user/auth", data);
                    this.token = data.data;
                    console.log(data);
                    if (data.status === 200) this.$router.push({ name: 'admin', params: { token: this.token }})
                } catch (e) {
                    alert("login failed")
                    this.$router.push({ name: 'auth'})
                }
            }
        }
    }
</script>

<style scoped>
    input[type="text"],
    input[type="password"],
    textarea,
    textarea.form-control {
        height: 50px;
        margin: 0;
        padding: 0 20px;
        vertical-align: middle;
        background: #f8f8f8;
        border: 3px solid #ddd;
        font-family: 'Roboto', sans-serif;
        font-size: 16px;
        font-weight: 300;
        line-height: 50px;
        color: #888;
        -moz-border-radius: 4px; -webkit-border-radius: 4px; border-radius: 4px;
        -moz-box-shadow: none; -webkit-box-shadow: none; box-shadow: none;
        -o-transition: all .3s; -moz-transition: all .3s; -webkit-transition: all .3s; -ms-transition: all .3s; transition: all .3s;
    }

    textarea,
    textarea.form-control {
        padding-top: 10px;
        padding-bottom: 10px;
        line-height: 30px;
    }

    input[type="text"]:focus,
    input[type="password"]:focus,
    textarea:focus,
    textarea.form-control:focus {
        outline: 0;
        background: #fff;
        border: 3px solid #ccc;
        -moz-box-shadow: none; -webkit-box-shadow: none; box-shadow: none;
    }

    input[type="text"]:-moz-placeholder, input[type="password"]:-moz-placeholder,
    textarea:-moz-placeholder, textarea.form-control:-moz-placeholder { color: #888; }

    input[type="text"]:-ms-input-placeholder, input[type="password"]:-ms-input-placeholder,
    textarea:-ms-input-placeholder, textarea.form-control:-ms-input-placeholder { color: #888; }

    input[type="text"]::-webkit-input-placeholder, input[type="password"]::-webkit-input-placeholder,
    textarea::-webkit-input-placeholder, textarea.form-control::-webkit-input-placeholder { color: #888; }



    button.btn {
        height: 50px;
        margin: 0;
        padding: 0 20px;
        vertical-align: middle;
        background: #19b9e7;
        border: 0;
        font-family: 'Roboto', sans-serif;
        font-size: 16px;
        font-weight: 300;
        line-height: 50px;
        color: #fff;
        -moz-border-radius: 4px; -webkit-border-radius: 4px; border-radius: 4px;
        text-shadow: none;
        -moz-box-shadow: none; -webkit-box-shadow: none; box-shadow: none;
        -o-transition: all .3s; -moz-transition: all .3s; -webkit-transition: all .3s; -ms-transition: all .3s; transition: all .3s;
    }

    button.btn:hover { opacity: 0.6; color: #fff; }

    button.btn:active { outline: 0; opacity: 0.6; color: #fff; -moz-box-shadow: none; -webkit-box-shadow: none; box-shadow: none; }

    button.btn:focus { outline: 0; opacity: 0.6; background: #19b9e7; color: #fff; }

    button.btn:active:focus, button.btn.active:focus { outline: 0; opacity: 0.6; background: #19b9e7; color: #fff; }

    body {
        font-size: 16px;
        font-weight: 300;
        color: #888;
        line-height: 30px;
        text-align: center;
    }

    strong { font-weight: 500; }

    a, a:hover, a:focus {
        color: #19b9e7;
        text-decoration: none;
        -o-transition: all .3s; -moz-transition: all .3s; -webkit-transition: all .3s; -ms-transition: all .3s; transition: all .3s;
    }

    h1, h2 {
        margin-top: 10px;
        font-size: 38px;
        font-weight: 100;
        color: #555;
        line-height: 50px;
    }

    h3 {
        font-size: 22px;
        font-weight: 300;
        color: #555;
        line-height: 30px;
    }

    img { max-width: 100%; }

    ::-moz-selection { background: #19b9e7; color: #fff; text-shadow: none; }
    ::selection { background: #19b9e7; color: #fff; text-shadow: none; }


    .btn-link-1 {
        display: inline-block;
        height: 50px;
        margin: 5px;
        padding: 16px 20px 0 20px;
        background: #19b9e7;
        font-size: 16px;
        font-weight: 300;
        line-height: 16px;
        color: #fff;
        -moz-border-radius: 4px; -webkit-border-radius: 4px; border-radius: 4px;
    }
    .btn-link-1:hover, .btn-link-1:focus, .btn-link-1:active { outline: 0; opacity: 0.6; color: #fff; }

    .btn-link-1.btn-link-1-facebook { background: #4862a3; }
    .btn-link-1.btn-link-1-twitter { background: #55acee; }
    .btn-link-1.btn-link-1-google-plus { background: #dd4b39; }

    .btn-link-1 i {
        padding-right: 5px;
        vertical-align: middle;
        font-size: 20px;
        line-height: 20px;
    }

    .btn-link-2 {
        display: inline-block;
        height: 50px;
        margin: 5px;
        padding: 15px 20px 0 20px;
        background: rgba(0, 0, 0, 0.3);
        border: 1px solid #fff;
        font-size: 16px;
        font-weight: 300;
        line-height: 16px;
        color: #fff;
        -moz-border-radius: 4px; -webkit-border-radius: 4px; border-radius: 4px;
    }
    .btn-link-2:hover, .btn-link-2:focus,
    .btn-link-2:active, .btn-link-2:active:focus { outline: 0; opacity: 0.6; background: rgba(0, 0, 0, 0.3); color: #fff; }


    /** Top content **/

    .inner-bg {
        padding: 60px 0 80px 0;
    }

    .top-content .description {
        margin: 20px 0 10px 0;
    }

    .top-content .description a:hover,
    .top-content .description a:focus { border-bottom: 1px dotted #19b9e7; }

    .form-box {
        margin-top: 70px;
    }

    .form-top {
        overflow: hidden;
        padding: 0 25px 15px 25px;
        background: #f3f3f3;
        -moz-border-radius: 4px 4px 0 0; -webkit-border-radius: 4px 4px 0 0; border-radius: 4px 4px 0 0;
        text-align: left;
    }

    .form-top-left {
        float: left;
        width: 75%;
        padding-top: 25px;
    }

    .form-top-left h3 { margin-top: 0; }

    .form-top-right {
        float: left;
        width: 25%;
        padding-top: 5px;
        font-size: 66px;
        color: #ddd;
        line-height: 100px;
        text-align: right;
    }

    .form-bottom {
        padding: 25px 25px 30px 25px;
        background: #eee;
        -moz-border-radius: 0 0 4px 4px; -webkit-border-radius: 0 0 4px 4px; border-radius: 0 0 4px 4px;
        text-align: left;
    }

    .form-bottom form textarea {
        height: 100px;
    }

    .form-bottom form button.btn {
        width: 100%;
    }

    .form-bottom form .input-error {
        border-color: #19b9e7;
    }

    .social-login {
        margin-top: 35px;
    }

    .social-login-buttons {
        margin-top: 25px;
    }

    .middle-border {
        min-height: 300px;
        margin-top: 170px;
        border-right: 1px solid #ddd;
    }


    /** Footer **/

    footer {
        padding-bottom: 70px;
    }

    footer .footer-border {
        width: 200px;
        margin: 0 auto;
        padding-bottom: 30px;
        border-top: 1px solid #ddd;
    }

    footer a:hover, footer a:focus { border-bottom: 1px dotted #19b9e7; }


    /** Media queries **/

    @media (min-width: 992px) and (max-width: 1199px) {}

    @media (min-width: 768px) and (max-width: 991px) {}

    @media (max-width: 767px) {

        .middle-border { min-height: auto; margin: 65px 30px 0 30px; border-right: 0; border-top: 1px solid #ddd; }

    }

    @media (max-width: 415px) {

        h1, h2 { font-size: 32px; }

    }

    .bg {
        background-image: url('http://localhost:9000/img/Union.jpg');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: 100% 120%;
    }

    .hello {
        position: absolute;
        width: 25%;
        height: 65%;
        margin-top:-1%;
        margin-left: 53%;

        background-image: url('http://localhost:9000/img/Group.jpg');
        background-size: 100% 100%;
        border: 1px solid #000000;
        box-sizing: border-box;
        box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.04), 0px 2px 6px rgba(0, 0, 0, 0.04), -10px 16px 24px rgba(0, 0, 0, 0.06);
    }


</style>