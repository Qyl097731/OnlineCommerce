<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/11/8
  Time: 15:08
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
    <script>


        $(document).ready(function () {
            function changeColor(param) {
                $(param).prop("color", "pink");
            }

            function changeColor1(param) {
                $(param).prop("color", "white")
            }
        })
    </script>
</head>
<body>
<c:if test="${allGoods.size() == 0}">
    您还没有商品。
</c:if>
<c:if test="${allGoods.size() != 0}">
    <table border="1" bordercolor="PaleGreen">
        <tr>
            <th width="100px">ID</th>
            <th width="200px">名称</th>
            <th width="200px">价格</th>
            <th width="100px">库存</th>
            <th width="200px">详情</th>
        </tr>
        <c:forEach items="${allGoods}" var="goods">
            <tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
                <td>${goods.id}</td>
                <td>${goods.gname}</td>
                <td>${goods.grprice}</td>
                <td>${goods.gstore}</td>
                <td><a href="adminGoods/selectAGoods?id=${goods.id}" target="_blank"
                       style="text-decoration: none">详情</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5" align="center">
                共${totol}条记录&nbsp;&nbsp;
                共${info.pages}页&nbsp;&nbsp;
                <a href="adminGoods/selectGoods?pageCur=${info.prePage}" contenteditable="${info.pageNum == 1}"
                   style="outline: none"></a>
                <c:forEach items="${nums}" var="num">
                    <a href="adminGoods/selectGoods?pageCur=${num}"
                       style="text-decoration:${num==info.pageNum?'none':'underline'}"
                       contenteditable="${num==info.pageNum}" style="outline: none">${num}</a>
                </c:forEach>
                <a href="adminGoods/selectGoods?pageCur=${info.nextPage}" contenteditable="${info.pageNum == info.pages}"
                   style="outline: none"></a>

            </td>
        </tr>
    </table>
</c:if>
</body>
</html>