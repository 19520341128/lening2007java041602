var vm = new Vue({
    el:"#app",
    data:{
        traineelist:[],
        trainee:{},
        page:{},
        pageNum:1,
        pageSize:3,
        subjectList:[],
        subjectId:"",
        traineeTo:[],
        traineeId:"",
        subjectName:"",
        datestr:""
    },
    methods:{
        getTraineeList:function () {
            var _this = this;
            axios.post("/trainee/findAll.do?pageNum="+_this.pageNum+"&pageSize="+_this.pageSize,_this.trainee).then(function (response) {
                _this.page = response.data;
                _this.traineelist = response.data.list;
                _this.pageNum = response.data.currentPage;
                _this.pageSize = response.data.pageSize;
            })
        },
        paging:function (pageNum) {
            this.pageNum = pageNum;
            this.getTraineeList();
        },
        getSubjectList:function () {
            var _this = this;
            axios.get("/subject/getSubjectList.do").then(function (response) {
                _this.subjectList = response.data;
            })
        },
        toTrainee:function () {
            //获取要查看的科目的id
            var subjectId = this.subjectId;
            var _this = this;
            axios.post("/subject/getToTrainee.do?subjectId="+subjectId).then(function (response) {
                if (response.data.length==0){
                    alert("此科目没人学！")
                }else {
                    _this.traineeTo = response.data;
                    //显示
                    document.getElementById("toTrainee").style.display="block";
                }
            });
        },
        shang:function () {
            location.reload(true);
        },
        According:function () {
            var traineeId = this.traineeId;
            var list = this.traineelist;
            var a=null;
            for (var i = 0; i < list.length; i++) {
                if (list[i].tId==traineeId){
                    this.subjectName = list[i].subjectName;
                    a=1;
                }
            }
            if (a==null){
                alert("输入编号无效，请重新输入！")
            }else if (a==1){
                //打开隐藏域
                document.getElementById("div").style.display="block";
            }
        },
        add:function () {
            var time = document.getElementById("sel").value;
            var subjectName=this.subjectName;
            var _this = this;
            axios.post("/subject/addTime.do?time="+time+"&subjectName="+subjectName+"&datestr="+_this.datestr).then(function (response) {
                alert(response.data);

                //刷新页面
                location.reload(true);
            })
        }
    }
});
vm.getTraineeList();
vm.getSubjectList();