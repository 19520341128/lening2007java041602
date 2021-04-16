var vm = new Vue({
    el:"#app",
    data:{
        userName:"",
        password:""
    },
    methods:{
        sub:function () {
            var username = this.userName;
            var password = this.password;

            location.href="myhtml/index.html"
        }
    }
})