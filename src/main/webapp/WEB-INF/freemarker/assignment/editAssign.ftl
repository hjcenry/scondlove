<!DOCTYPE html>
<html class="ui-mobile portrait min-width-320px min-width-480px max-width-768px max-width-1024px">
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${request.contextPath}/css/jquery.mobile-1.3.2.min.css">
  <link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css">
  <link type="text/css" rel="stylesheet" href="${request.contextPath}/css/style.css" />
  <script src="${request.contextPath}/js/jquery-1.9.1.min.js"></script>
  <script src="${request.contextPath}/js/global.js"></script>
  <script src="${request.contextPath}/js/jquery.mobile-1.3.2.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="${request.contextPath}/js/ajaxfileupload.js"></script>
<title>摩卡情缘</title>
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
<input type="hidden" id="dealId" value="${dealMessage.dealId}"/>
<input type="hidden" id="dealType" name="dealType" value="1"/>
<div>
 <div  class="nav">
  	<img src="${request.contextPath}/images/back.gif" class="lnavimg" onclick="history.go(-1)" />
	<span class="navtext">编辑邀请</span>
   </div>
  <div data-role="content" style="margin-bottom: 36px;">
    <form name="personForm" id="personForm" action="#" method="post" data-ajax="false">
	<div data-role="fieldcontain">
  	  动态标题:
  	  <input type="text" name="titlename" id="titlename" class="validate[required,length[0,20]" value="${dealMessage.dealTitle}"  />
	</div>	
	<div data-role="fieldcontain">
    <label for="context">我的动态:</label>
      <textarea cols="40" rows="160" id="account" name="account" style="height: 120px;" class="validate[required,length[0,80]">${dealMessage.dealDesc}</textarea>
	</div>
	<div data-role="fieldcontain" >
    <label for="context">我的形象:</label>
      	<img src="${request.contextPath}${dealMessage.dealImage}" class="tdcover" id="imgs" name="imgs" onclick="fileimage.click()" width="70px;" height="70px;">
		<div style="display:none">
		<input type="file" name="fileimage" id="fileimage" onchange="upimage();">
		</div>
	</div>
	<div data-role="fieldcontain">
  	 我希望他/她:
  	 <input type="text" name="desc" id="desc" class="validate[required,length[0,40]" value="${dealMessage.dealHope!''}"  />
	</div>
	<div data-role="fieldcontain" >
    	<label >选择动态分类:</label>
    	<div >
	    	<select name="classify" id="classify" data-native-menu="false">
	    		<#if allClassify??>
	    			<#list allClassify as all>
	    				<#if dealMessage.classifyId==all.classifyId >
	    					<option value="${all.classifyId}" selected="selected">${all.classifyName!'' }</option>
	    				<#else>
	    					<option value="${all.classifyId}">${all.classifyName!''}</option>
	    				</#if>
	    			</#list>
	    		</#if>
	      	</select>
      	</div>
	</div>		
	
	<button type="button" onclick="tijiao()" id="add" name="add">提交</button>
   </form> 
  </div>
</div>
<script type="text/javascript">

function kai(){
	$('#yess').show();
	$('#noss').hide();
	$('#dealBarter').val('1');
}
function guan(){
	$('#noss').show();
	$('#yess').hide();
	$('#dealBarter').val('0');
}

function tijiao(){
	var dealTitle ='',dealDesc='',dealImage='',classifyId='',dealType='';
	dealTitle = $('#titlename').val();
	if(dealTitle==''){
		$.DIC.dialog({content:'请输入宝贝标题！', autoClose:true});
		return false;
	}else if(dealTitle.length>40){
		$.DIC.dialog({content:'宝贝标题不能超过40个字！', autoClose:true});
		return false;
	}
	dealDesc = $('#account').val();
	if(dealDesc==''){
		$.DIC.dialog({content:'宝贝描述不能为空！', autoClose:true});
		return false;
	}
	dealImage = $('#imgs').attr('src');
	if(dealImage.substring(dealImage.lastIndexOf('/')+1)=='tupian.png'){
		$.DIC.dialog({content:'请上传宝贝图片！', autoClose:true});
		return false;
	}
	
	
	classifyId = $('#classify').find('option:selected').val();
	dealType = $('#dealType').val();
	$('#add').attr("disabled",true);
	var datas={
		'dealId':$("#dealId").val(),
		'dealTitle':dealTitle,
		'dealDesc':dealDesc,
		'dealImage':dealImage,
		dealHope:$("#desc").val(),
		'classifyId':classifyId,
		'dealType':dealType
	}
	$.ajax({
		type: 'POST',
		url: '../assignment/editAssignmentDeal',
		data: datas,
		success: function(data){
			if(data.type=="success"){
				window.location.href ="../deal/assignment";
	    	}else{
	    		$.DIC.dialog({content:'提交失败，请稍后重试！', autoClose:true});
	    	}
	    	$('#add').attr("disabled",false);
	    }
	});

	
}

//上传图片
function upimage(){
	var file = $("#fileimage").val();
	$.ajaxFileUpload({  
		url:'../assignment/upImg?&fileimage='+file,
        secureuri : false,//一般设置为false    
        fileElementId : 'fileimage',//文件上传空间的id属性  
        dataType: 'text',
        success :function(data) //服务器成功响应处理函数    
        {	
        	$("#imgs").attr("src","${request.contextPath}"+data);
        },  
        error : function(data, status, e)//服务器响应失败处理函数    
        {  
        	$.DIC.dialog({content:"error"+data, autoClose:true});
        } 
    });  
}
</script>
</body>
</html>