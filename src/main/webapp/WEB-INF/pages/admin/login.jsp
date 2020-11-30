<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/10/29
  Time: 16:18
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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>
    <link href="<%=basePath%>css/login.css" rel="stylesheet">
    <script>
        $(document).ready(function () {
            $("#code").click(function () {
                $("#code").prop("src","validateCode?"+new Date().getTime());
            })
        })
    </script>
</head>
<body>
<div class="container">
    <form:form action="admin/login" method="post" class="form-signin" modelAttribute="auser" >
        <label for="input_aname" class="sr-only">Email address</label>
        <form:input path="aname" type="text" id="input_aname" class="form-control" placeholder="username" />
        <div style="font-size: xx-small ;color: red" >${empty anameError ?'<br>':anameError}</div>
        <label for="inputPassword" class="sr-only">Password</label>
        <form:input type="password" path="apwd" name="apwd" id="inputPassword" class="form-control" placeholder="password" />
        <div style="font-size: xx-small ;color: red" >${empty passwordError ?'<br>':passworError}</div>
        <input type="text" name="code" style="width: 225px" id="codeInput" required/>
        <img id="code" src="validateCode"/>
        <div style="font-size: xx-small ;color: red" id="codeError">${empty codeError ?'<br>':codeError}</div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="loginBtn">Sign in</button>
    </form:form>

</div>
</body>
</html>
