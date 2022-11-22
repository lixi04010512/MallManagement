//鼠标移开姓名框开始验证
$("#username").blur(function(){
    var username = $("#username").val();
    var Username = /^[a-zA-Z\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
    if (!Username.test(username)) {
        $("#p_name").html("<font color=\"red\" size=\"2\">姓名格式填写错误！</font>");
    } else {
        $("#p_name").html("<font color=\"green\" size=\"2\">姓名格式正确！</font>");
    }
})
//鼠标放置姓名框不验证
$("#username").focus(function(){
    $("#p_name").html("");
})

//鼠标移开邮箱框开始验证
$("#email_number").blur(function(){
    var email_number = $("#email_number").val();
    var Useremail = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    if (!Useremail.test(email_number)) {
        $("#p_email").html("<font color=\"red\" size=\"2\">邮箱格式填写错误！</font>");
    } else {
        $("#p_email").html("<font color=\"green\" size=\"2\">邮箱格式正确！</font>");
    }
})

//鼠标移开密码框开始验证
$("#password").blur(function () {
    var password = $("#password").val();
    var Password=/^(\w){6,20}$/;
    if (!Password.test(password)) {
        $("#p_password").html("<font color=\"red\" size=\"2\">密码格式填写错误！</font>");
    } else {
        $("#p_password").html("<font color=\"green\" size=\"2\">密码格式正确！</font>");
    }
})

//鼠标放置密码框不验证
$("#password").focus(function(){
    $("#p_password").html("");
})

//鼠标移开确认密码框开始验证
$("#confirm_password").blur(function () {
    var password1 = $("#password").val();
    var password2 = $("#confirm_password").val();
    if (password1==password2) {
        $("#p_password1").html("<font color=\"green\" size=\"2\">两次密码一致！</font>");
    } else {
        $("#p_password1").html("<font color=\"red\" size=\"2\">输入了不同的密码！</font>");
    }
})

//鼠标放置确认密码框不验证
$("#confirm_password").focus(function(){
    $("#p_password1").html("");
})

//鼠标移开同意协议框开始验证
$("#save-default").blur(function () {
    var check = $("#save-default").prop('checked');
    if (check) {
        $("#confirmCheck").html("<font color=\"green\" size=\"2\">已同意协议</font>");
    } else {
        $("#confirmCheck").html("<font color=\"red\" size=\"2\">未同意协议</font>");
    }
})

//鼠标放置同意协议框不验证
$("#save-default").focus(function(){
    $("#confirmCheck").html("");
})

//注册确认按钮
$("#register").click(function(){
    var username = $("#username").val();
    var Username = /^[a-zA-Z\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
    var email_number = $("#email_number").val();
    var Useremail = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    var password = $("#password").val();
    var Password=/^(\w){6,20}$/;
    var password1 = $("#password").val();
    var password2 = $("#confirm_password").val();
    var check = $("#save-default").prop('checked');
    if(!Username.test(username)){
        alert("姓名输入格式错误！")
    }else if(!Useremail.test(email_number)){
        alert("邮箱输入格式错误!")
    }else if(!Password.test(password)){
        alert("密码输入格式错误！")
    }else if(password1!=password2){
        alert("两次密码输入不一致！")
    }else if(!check){
        alert("未同意协议！")
    }else{
        $.ajax({
            type: "POST",
            url: "/users/test_email_code",
            data: {"email_code": $("#email_code").val()},
            success: function () {

            }
        })

        $.ajax({
            type: "POST",
            url: "/users/regist",
            data: {
                "username": $("#username").val(),
                "password": $("#password").val(),
                "email": $("#email_number").val()
            },
            success: function () {
                window.location = "/users/login_html";
            }
        })
    }
})