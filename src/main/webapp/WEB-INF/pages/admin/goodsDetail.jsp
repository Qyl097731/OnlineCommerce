<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/11/8
  Time: 15:10
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
    <table border="1" style="border-collapse: collapse">
        <caption>
            <font size="4" face="华文新魏">商品详情</font>
        </caption>
        <tr>
            <td>名称</td>
            <td>
                ${goods.gname}
            </td>
        </tr>
        <tr>
            <td>原价</td>
            <td>${goods.goprice}</td>
        </tr>
        <tr>
            <td>折扣价价</td>
            <td>${goods.grprice}</td>
        </tr>
        <tr>
            <td>库存</td>
            <td>${goods.gstore}</td>
        </tr>
        <tr>
            <td>图片</td>
            <td><c:if test="${not empty goods.gpicture}">
                <img alt="" width="250" height="250" src="logos/${goods.gpicture}"/>
            </c:if></td>
        </tr>
        <tr>
            <td>类型</td>
            <td>${goods.typename}</td>
        </tr>
    </table>
</body>
</html>