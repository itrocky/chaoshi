<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>远洋网络购物广场</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <frameset rows="20%,*">
     <frame name="topFrame" scrolling="no" noresize="noresize" width="20%" src="top.jsp"><!-- 设置顶部大小及内容 -->
     <frameset cols="20%,*">
         <frame name="leftFrame" scrolling="no" noresize="noresize" src="lefFrame.jsp"><!-- 左下部分 -->
         <frame name="mainFrame" scrolling="yes" src="pagination.jsp">
     </frameset>
  </frameset>
  <body>
    This is my JSP page. <br>
  </body>
</html>
