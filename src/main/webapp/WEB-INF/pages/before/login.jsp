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
    <link rel="stylesheet" type="text/css"
          href="css/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
    <script src="css/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link href="css/login.css" rel="stylesheet">
    <script>
        $(document).ready(function () {
            $("#code").click(function () {
                $("#code").prop("src", "validateCode?" + new Date().getTime());
            })
        })
    </script>
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <form:form action="before/login" method="post" cssClass="form-signin" modelAttribute="buser">
            <div class="form-group">
                <label for="input_aname">EMAIL ADDR</label>
                <form:input path="bemail" type="text" id="input_aname" class="form-control"/>
                <div style="font-size: xx-small ;color: red">${empty bemailError ?'<br>':bemailError}</div>
            </div>
            <div class="form-group">
                <label for="inputPassword">PASSWORD</label>
                <form:input type="password" path="bpwd" name="bpwd" id="inputPassword" class="form-control"/>
                <div style="font-size: xx-small ;color: red">${empty passwordError ?'<br>':passwordError}</div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <input type="text" name="code" style="width: 225px" id="codeInput" required class="form-control"/>
                    <img id="code" src="validateCode"/>
                </div>
                <div style="font-size: xx-small ;color: red" id="codeError">${empty codeError ?'<br>':codeError}</div>
            </div>
            <div class="input-group">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me" /> Remember me
                    </label>
                </div>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit" id="loginBtn">Sign in</button>
        </form:form>
        <div class="hr"></div>
        <div class="foot-lnk">
            <p>Forgot Password?</p>
        </div>
        <div class="foot-lnk">
            <a href="before">Back Home</a>
        </div>
    </div>
</div>
</body>
</html>