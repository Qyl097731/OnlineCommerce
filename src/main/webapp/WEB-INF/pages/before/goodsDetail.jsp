<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/12/2
  Time: 16:59
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
    <script src="/css/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="/css/before/main.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="head.jsp"/>

</body>
</html>