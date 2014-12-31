<!DOCTYPE html>
<html class="ui-mobile portrait min-width-320px min-width-480px max-width-768px max-width-1024px">
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${request.contextPath}/css/jquery.mobile-1.3.2.min.css">
  <link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css">
  <script src="${request.contextPath}/js/jquery-1.9.1.min.js"></script>
  <script src="${request.contextPath}/js/global.js"></script>
  <script src="${request.contextPath}/js/jquery.mobile-1.3.2.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="${request.contextPath}/js/ajaxfileupload.js"></script>
  <title>二手市场</title>
</head>
<style>
	.ui-icon{
			position:absolute;
	}
	
	.tips {
		padding: 0 20px;
		height: 35px;
		background-color: #000;
		margin: 0 auto;
		filter: alpha(opacity=60);
		opacity: 0.6;
		line-height: 35px;
		font-size: 1.2rem;
		text-align: center;
		color: #fff;
		-moz-border-radius: 0.5rem;
		-webkit-border-radius: 0.5rem;
		border-radius: 0.5rem;
	}

</style>
<body>
<div data-role="page">
 <div data-role="header" data-theme="c">
  <h1>提示</h1>
  </div>
  <div data-role="content" style="margin-bottom: 36px;">
	<div data-role="fieldcontain">
  	  客官您好，由于您长时间没进行操作，导致登录失效，请退出应用重新来过！
	</div>
  </div>
</div>
</body>
</html>