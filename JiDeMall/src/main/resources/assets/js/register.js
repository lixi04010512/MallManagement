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
//鼠标放置邮箱框不验证
$("#email_number").focus(function(){
	$("#p_email").html("");
})

//鼠标移开验证码框开始验证
$("#email_code").blur(function () {
	var email_code = $("#email_code").val();
	if (number!=email_code) {
		$("#p_random").html("<font color=\"red\" size=\"2\">验证码输入错误！</font>");
	} else {
		$("#p_random").html("<font color=\"green\" size=\"2\">验证码输入正确！</font>");
	}
})

//鼠标放置验证码框不验证
$("#email_code").focus(function(){
	$("#p_random").html("");
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
$("#check").blur(function () {
	var check = $("#check").prop('checked');
	if (check) {
		$("#confirmCheck").html("<font color=\"green\" size=\"2\">已同意协议</font>");
	} else {
		$("#confirmCheck").html("<font color=\"red\" size=\"2\">未同意协议</font>");
	}
})

//鼠标放置同意协议框不验证
$("#check").focus(function(){
	$("#confirmCheck").html("");
})

//注册确认按钮	  
$("#register").click(function(){
	var username = $("#username").val();
	var Username = /^[a-zA-Z\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
	var email_number = $("#email_number").val();
	var Useremail = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
	var use_random = $("#use_random").val();
	var password = $("#password").val();
	var Password=/^(\w){6,20}$/;
	var password1 = $("#password").val();
	var password2 = $("#confirm_password").val();
	var check = $("#check").prop('checked');
	if(!Username.test(username)){
		alert("姓名输入格式错误！")
	}else if(!Useremail.test(email_number)){
		alert("邮箱输入格式错误!")
	}else if(number!=use_random){
		alert("验证码输入错误！")
	}else if(!Password.test(password)){
		alert("密码输入格式错误！")
	}else if(password1!=password2){
		alert("两次密码输入不一致！")
	}else if(!check){
		alert("未同意协议！")
	}else{
		$.ajax({
			type:"POST",
			url:"/registerPost",
			data:{"username":$("#username").val(),"email_number":$("#email_number").val(),"password":$("#password").val()},
			success:function(data){
				console.log(data)
				alert("用户注册成功!");
				window.location="/login";
			}
		})
	}
})
let number=null;
//邮箱发送按钮
function setTime(time) {
	if (!isNaN(time) && time > 0) {
		$('#send_email').html("倒计时" + time + "秒");
		$('#send_email').attr('disabled', true);
		var b = setInterval(function () {
			time--;
			if (time <= 0) {
				$('#send_email').html('重新发送');
				$('#send_email').attr('disabled', false);
				clearInterval(b);
			} else {
				$('#send_email').html("倒计时" + time + "秒");
			}
		}, 1000);
	} else {
		alert('时间有误')
	}
}

$("#send_email").click(function(){
	setTime(60);
	$.ajax({
		type:"POST",
		url:"/sendEmailPost",
		data:{"email_number":$("#email_number").val()},
		success:function (data) {
			number=data.data;
			console.log(number)
			alert("发送成功！");

		}
	})
})