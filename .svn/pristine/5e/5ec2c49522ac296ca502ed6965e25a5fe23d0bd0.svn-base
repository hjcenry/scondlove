<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>民生银行</title>
<link type="text/css" rel="stylesheet" href="../css/admin/reset_pc.css" />
<link type="text/css" rel="stylesheet" href="../css/admin/login.css" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
	function login(){
		if($("#loginname").val() == null || $("#loginname").val() == "" ){
			alert('用户名不能为空');
			return;
		}
		if($("#password").val() == null || $("#password").val() == "" ){
			alert('密码不能为空');
			return;
		}
		$("#loginForm").submit();
	}
	document.onkeydown=function(event){
	    var e = event || window.event || arguments.callee.caller.arguments[0];
	     if(e && e.keyCode==13){ // enter 键
	    	 login();
	    }
	}; 
	function init(){
		var msg = $("#msg").val();
		if(msg !== null && msg !== ""){
			alert(msg);
			$("#msg").val("");
		}
		try{
			parent.parentonlick();
		}catch(e){
			//alert(e)
		}
	}
</script>

</head>

<body onLoad="init()">
<div class="wrap">
  <div class="header">
    <div class="logo fl"><img src="../images/admin/logo.png" width="300" /></div>
  </div>
  
  <div class="con clearfix">
    <div class="login">
    	<form id="loginForm" action="login" method="post">
          <div class="login-con">
          		<div class="ipt1"><input id="loginname" name="loginname" type="text" class="ipt"/></div>
                <div class="ipt2"><input id="password" name="password" type="password" class="ipt"/></div>
                <a href="#" class="btn-login" onClick="login();"></a>
          </div>
          <div id="focus">
          	<img src="../images/admin/login-bg2.png" />
          </div>
       </form>
        </div>
    <input id="msg" name="msg" type="hidden" value="">
  </div>
  <div class="footer">版权所有:民生银行</div>
</div>
</body>
</html>