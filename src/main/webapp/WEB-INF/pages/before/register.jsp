<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/11/17
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort() + path + "/";
%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form:form action="before/register" method="post" class="form-signin" modelAttribute="buser">
            <div class="form-group">
                <label for="input_aname"> EMAIL ADDR</label>
                <form:input path="bemail" type="text" id="input_aname" cssClass="form-control" />
                <div style="font-size: xx-small ;color: red" ><form:errors path="bemail"/></div>
            </div>
            <div class="form-group">
                <label for="inputPassword">PASSWORD</label>
                <form:input type="password" path="bpwd"  id="inputPassword" cssClass="form-control" />
                <div style="font-size: xx-small ;color: red" ><form:errors path="bpwd"/></div>
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
            <button class="btn btn-lg btn-primary btn-block" type="submit" id="loginBtn">Register</button>
        </form:form>
        <div class="hr"></div>
        <div class="foot-lnk">
            <a href="before">Back Home</a>
        </div>
    </div>
</div>
</div>
</body>
</html>