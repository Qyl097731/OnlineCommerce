<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/11/8
  Time: 15:10
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
          href="css/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>
    <link rel="stylesheet" type="text/css" href="css/admin/dashboard.css">
    <style>
        input{outline: none}
        label{outline: none}
    </style>
</head>
<script>
    $(document).ready(function () {
        $(".btn-default:eq(1)").click(function () {
            $(".form-horizontal").attr("action","adminGoods/deleteAGoods?id=${goods.id}")
            return true;
        })
        $(".btn-default:eq(0)").click(function () {
            $(".form-horizontal").attr("action","adminGoods/addGoods?updateAct=update")
            return true;
        })
    })
</script>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <%--            实现个人信息页面跳转--%>
            <a class="navbar-brand" href="admin/toUpdateInfo">${sessionScope.auser.aname}</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="admin/toPageMain">Dashboard</a></li>
                <li><a href="admin/toUpdateInfo">Profile</a></li>
                <li><a href="#">Help</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="adminGoods/selectGoods">商品管理</a></li>
                <li><a href="adminType/toManagerType">类型管理</a></li>
                <li><a href="adminUser/userInfo">用户管理</a></li>
                <li><a href="adminOrder/orderInfo">订单管理</a></li>
                <li><a href="adminNotice/noticeInfo">公告管理</a></li>
                <li><a href="admin/exit">安全退出</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">修改商品</h2>
            <form:form class="form-horizontal" style="margin:0 auto;width: 550px" action=""
                       method="post" modelAttribute="auser" enctype="multipart/form-data">
                <form:input path="aname" value="${auser.aname}" />
                <div class="form-group">
                    <label class="col-sm-2 control-label">名称<font color="red">*</font></label>
                    <div class="col-sm-10">
                        <form:input path="apwd" value="${auser.apwd}" class="form-control-static"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"><input type="submit" class="btn btn-default">修改</input> </label>
                    <div class="col-sm-10">
                        <p class="form-control-static"><input type="reset" class="btn btn-default">重置</p>
                    </div>
                </div>
            </form:form>

        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
</body>
</html>
