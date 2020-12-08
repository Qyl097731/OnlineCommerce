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
          href="/css/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script src="/jquery/jquery-3.5.1.min.js"></script>
    <script src="/jquery/jquery-3.5.1.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>
    <link rel="stylesheet" type="text/css" href="/css/admin/dashboard.css">
    <link rel="stylesheet" type="text/css" href="/css/admin/main.css">
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h2 class="sub-header">订单详情</h2>
    <div class="table-responsive">
            <table class="table" style="width: 1400px">
                <thead>
                <tr>
                    <th width="100px">商品ID</th>
                    <th width="100px">商品名</th>
                    <th width="50px"></th>
                    <th width="200px">图片</th>
                    <th width="100px">数量</th>
                    <th width="100px">操作</th>
                </tr>
                </thead>
                <tbody id="showItem" class="showItem">
                    <tr>
                        <td style="padding-top: 50px">${myOrderDetail.gid}</td>
                        <td style="padding-top: 50px">${myOrderDetail.gname}</td>
                        <td></td>
                        <td><img src="logos/${myOrderDetail.gpicture}" width="100px" height="100px" alt="公告图片"/></td>
                        <td style="padding-top: 50px">${myOrderDetail.shoppingnum}</td>
                        <c:if test="${myOrderDetail.status == 0}">
                        <td style="padding-top: 50px"><a href="updateOrderStatue?orderSn=${myOrderDetail.orderbasetable_id}" class="btn btn-success">立即付款</a></td>
                        </c:if>
                        <c:if test="${myOrderDetail.status == 1}">
                            <td style="padding-top: 50px"><a href="myOrder" class="btn btn-success">返回</a></td>
                        </c:if>
                    </tr>
                </tbody>
            </table>
    </div>
</div>
</body>
</html>