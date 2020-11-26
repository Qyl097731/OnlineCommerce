<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/11/8
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/10/29
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort() + path + "/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%=basePath%>">

    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>css/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>

    <title>Title</title>
</head>
<body>
    <c:if test="${bruser!=null}">欢迎${bruser.bemail}</c:if>
    <c:if test="${bruser==null}"><a href="toLogin" >登录</a></c:if>
    <a href="toRegister">注册</a>
    |<a href="userCenter">用户中心</a>|
    <c:if test="${bruser!=null}">
        <a href="user/exit">退出</a>
    </c:if>
<form action="search" name="myForm" method="post">
    <input type="text" name="mykey" class="txt" value="请输入您要查询的内容" onfocus="clearValue()"/>
    <input type="submit" value="搜索"/>
</form>
<ul>
    <li><a href="before?id=0">首页</a> </li>
    <c:forEach items="${goodsType}" var="type">
        <li><a href="before?id=${type.id}">${type.typename}</a> </li>
    </c:forEach>
    <li><a href="cart/selectCart">购物车</a> </li>
</ul>
</body>
</html>