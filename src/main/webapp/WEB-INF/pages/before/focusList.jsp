<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/12/7
  Time: 22:16
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
    <link rel="stylesheet" type="text/css"
          href="css/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="jquery/jquery-3.5.1.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>
    <link rel="stylesheet" type="text/css" href="css/admin/dashboard.css">
    <link rel="stylesheet" type="text/css" href="css/admin/main.css">
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h2 class="sub-header">收藏夹列表</h2>
    <div class="table-responsive">
        <c:if test="${myFocus.size() == 0}">
            收藏夹为空。
        </c:if>
        <c:if test="${myFocus.size() != 0}">
            <table class="table" style="width: 1400px">
                <thead>
                <tr>
                    <th width="100px">ID</th>
                    <th width="200px">商品名</th>
                    <th width="50px"></th>
                    <th width="200px">图片</th>
                    <th width="100px">删除</th>
                    <th width="100px">详情</th>
                </tr>
                </thead>
                <tbody id="showItem" class="showItem">
                <c:forEach items="${myFocus}" var="focus">
                    <tr>
                        <td style="padding-top: 50px">${focus.id}</td>
                        <td style="padding-top: 50px">${focus.gname}</td>
                        <td></td>
                        <td><img src="logos/${focus.gpicture}" width="100px" height="100px" alt="商品图片"/></td>
                        <td style="padding-top: 50px"><a href="deleteAFocus?id=${focus.gid}">删除</a></td>
                        <td style="padding-top: 50px"><a href="goodsDetail?id=${focus.gid}">详情</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <div style="text-align: center;width: 1400px"><a href="before" class="btn btn-success">看看其他</a></div>
    </div>
</div>
</body>
</html>