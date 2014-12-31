<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>后台管理页面</title>
<link type="text/css" rel="stylesheet" href="../css/admin/reset_pc.css" />
<link type="text/css" rel="stylesheet" href="../css/admin/admin.css" />
<link type="text/css" rel="stylesheet" href="../css/admin/font-awesome.min.css" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/html5.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
    /*左侧多级菜单*/
	$(".page-sidebar-menu>li>a").click(function(e) {
	  $(this).parent().children(".sub-menu").toggle();
	  $(this).children("span.arrow").toggleClass("open");
    });
	/*二级菜单点击样式*/
	$(".sub-menu>li").click(function(e) {
		//给二级菜单添加样式
        $(this).addClass("active").siblings().removeClass("active");
		//给一级菜单添加样式
		$(this).parent().parent().addClass("active").children("a").children("span").first().after("<span class='selected'></span>");
		//取消其他一级菜单以及二级菜单样式
		$(this).parent().parent().siblings().removeClass("active").children(".sub-menu").hide().children("li").removeClass("active").parent().parent().children("a").children("span.arrow").removeClass("open");
    });
	$(".nav>li").click(function(e) {
		$(this).addClass("active").siblings().removeClass("active");
	});
	$(".mix-filter>li").click(function(e) {
        $(this).addClass("active").siblings().removeClass("active");
    });
});
</script>
</head>
<style>
/*body{
background:#3d3d3d;
}*/
</style>
<body style="background:#3d3d3d">
<section class="section">
	<aside class="aside">
    	<ul class="page-sidebar-menu">
            <li><a href="#"><i class="fa fa-sitemap"></i><span>信息管理</span><span class="arrow"></span></a>
            	<ul class="sub-menu">
  					<li><a href="../admin/content" target="right">信息管理</a></li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-leaf"></i><span>论坛管理</span><span class="arrow"></span></a>
                <ul class="sub-menu">
                	<li><a href="../admin/content" target='right'>帖子管理</a></li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-folder-open"></i><span>活动管理</span><span class="arrow"></span></a>
            	<ul class="sub-menu">
                	<li><a href="../admin/content" target='right'>预约办卡</a></li>
                	<li><a href="../admin/content" target='right'>小区活动</a></li>
                	<li><a href="../admin/content" target='right'>调查问卷</a></li>
                	<li><a href="../admin/content" target='right'>客户服务</a></li>
                </ul>
            </li>
          	<li><a href="#"><i class="fa fa-table"></i><span>系统管理</span><span class="arrow"></span></a>
         		<ul class="sub-menu">
              		<li><a href="../admin/content" target='right'>用户管理</a></li>
             	</ul>
             	<ul class="sub-menu">
                	<li><a href="../admin/content" target='right'>角色管理</a></li>
               	</ul>
                <ul class="sub-menu">
                	<li><a href="../admin/content" target='right'>分行管理</a></li>
                </ul>
                <ul class="sub-menu">
               		<li><a href="../admin/content" target='right'>小区管理</a></li>
                </ul>
                <ul class="sub-menu">
               		<li><a href="../admin/content" target='right'>栏目管理</a></li>
                </ul>  
                <ul class="sub-menu">
               		<li><a href="../admin/content" target='right'>卡管理</a></li>
                </ul>
                <ul class="sub-menu">
               		<li><a href="../admin/content" target='right'>黑名单管理</a></li>
                </ul>
              </li>
              <li><a href="#"><i class="fa fa-table"></i><span>小区信息</span><span class="arrow"></span></a>
             	 <ul class="sub-menu">
                	<li><a href="../admin/content" target='right'>联系我们</a></li>
                </ul>
             </li>
        </ul>
    </aside>
    <article class="article">
    	<!--<ul class="top clearfix">
        	<li><a href="#">理财速递</a></li>
            <li><a href="#">小区活动</a></li>
            <li><a href="#">周边特惠</a></li>
        </ul>-->
    </article>
</section>
</body>
</html>
