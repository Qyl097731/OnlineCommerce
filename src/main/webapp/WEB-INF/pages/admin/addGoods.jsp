<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/11/8
  Time: 14:23
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
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form action="adminGoods/addGoods" method="post" modelAttribute="goods" enctype="multipart/form-data">
    <table border=1 style="border-collapse: collapse">
        <caption>
            <font size="4" face="华文新魏">添加商品</font>
        </caption>
        <tr>
            <td>名称<font color="red">*</font></td>
            <td><form:input path="gname"/></td>
        </tr>
        <tr>
            <td>原价<font color="red">*</font></td>
            <td><form:input path="goprice"/></td>
        </tr>
        <tr>
            <td>折扣价</td>
            <td><form:input path="grprice"/></td>
        </tr>
        <tr>
            <td>库存</td>
            <td><form:input path="gstore"/></td>
        </tr>
        <tr>
            <td>图片</td>
            <td><input type="file" name="logoImage"></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><form:select path="gtypeId">
                <form:options items="${goodsType}" itemValue="id" itemLabel="typename"/>
            </form:select></td>
        </tr>
        <tr>
            <td align="center">
                <input type="submit" value="提交"/>
            </td>
            <td align="left">
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>