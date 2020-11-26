<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/11/8
  Time: 19:50
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
    <c:forEach items="${searchlist}" var="mf">
        <tr>
            <td>${mf.id}</td>
            <td>${mf.name}</td>
            <td><img style="width: 50px; height: 50px" src="logos/${mf.gpicture}" border="0" title="${mf.gname}"/> </td>
            <td>${mf.grprice}</td>
            <td><a href="goodsDetail?id=${mf.id}">去看看</a></td>
            <td>${mf.id}</td>


        </tr>
    </c:forEach>
</body>
</html>