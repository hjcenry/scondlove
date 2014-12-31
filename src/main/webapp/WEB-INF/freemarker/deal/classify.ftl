<!doctype html>
<html>
<head>
	<title>摩卡情缘</title>
	<link rel="stylesheet" type="text/css" href="${request.contextPath}/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="${request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${request.contextPath}/js/jquery-1.9.1.min.js"></script>
	
</head>
<body>
	<div class="main">
	<div  class="nav">
  		<img src="${request.contextPath}/images/back.gif" class="lnavimg" onclick="history.go(-1)" />
		<span class="navtext">摩卡情缘</span>
  	</div>
	<main>	
		<article>
			<h2 class="biaoti">分类</h2>
			<div style="width:100%;">
				<#if allClassify??>
					<ul class="ticket">
						<li><a href="#">全部
								<div>
									<input type="radio" id="0" value="0" checked="checked" name="cc"/>
									<label for="0"><span></span></label>
								</div>
						</a></li>
						<#list allClassify as all>
							<li><a href="#">${all.classifyName!''}
								<div>
									<input type="radio" id="${all.classifyId}" value="${all.classifyId}" name="cc"/>
									<label for="${all.classifyId}"><span></span></label>
								</div>
							</a></li>
							<#if all_index%4 == 3>
			    				</ul><ul class="ticket">
			    			</#if>
						</#list>
					</ul>
				</#if>
			</div>
		</article>
		
		<footer>
			<button class="confirm" onclick="slert()">确定</button>
		</footer>
	</main>
	</div>
	
</body>

<script type="text/javascript">
		function slert(){
			var changes=$("input[name='wuwu']:checked").val()==1?1:0;
			var classify= $("input[name='cc']:checked").val();
			classify=(classify==""||classify==undefined)?0:classify;
			if(${dealtype}==1){
				location.href="${request.contextPath}/deal/assignment?classify="+classify+"&changes="+changes;
			}else{
				location.href="${request.contextPath}/deal/purchase?classify="+classify+"&changes="+changes;
			}
			
		}
		
</script>
</html>
