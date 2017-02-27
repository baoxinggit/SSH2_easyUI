<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>JEasyUI</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 导入JQuery -->
	<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
	<!-- 导入easyUi.js -->
	<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
	<!-- 导入语言包 -->
	<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.js"></script>
	<!-- 导入自定义校验js文件 -->
	<script type="text/javascript" src="jslib/validateUtil.js"></script>
	
	<!-- 必须先导入主题样式，后导入图标样式，否则根据就近原则会产生样式冲突  -->
	<!-- 导入主题样式 -->
	<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/metro/easyui.css"></link>
	<!-- 导入图标样式 -->
	<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/icon.css"></link>	
  </head>
  
  <body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'east',title:'East',split:true" style="width:200px;"></div>
    <div data-options="region:'west',title:'功能导航',split:true" style="width:200px;">
    	<jsp:include page="layout/west.jsp"></jsp:include>
    </div>
    <div data-options="region:'center',title:'欢迎使用SSH2'" style="padding:5px;background:#eee;">
    	<jsp:include page="layout/center.jsp"></jsp:include>
    </div>
    <jsp:include page="user/reg.jsp"></jsp:include>
    <jsp:include page="user/login.jsp"></jsp:include>
</body>
</html>
