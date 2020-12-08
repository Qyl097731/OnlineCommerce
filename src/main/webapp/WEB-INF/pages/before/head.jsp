<%--
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
    <script>
        $('.dropdown-toggle').dropdown()
    </script>
</head>
<body>
<div style="display: flex;flex-wrap: wrap;align-items: center;width: 1400px;height:auto;margin: 0 auto;justify-content: space-between">
    <div class="navbar-wrapper" style="margin-top: 0px;">
        <div class="container" style="padding: 0;margin: 0 auto;width: 1400px">

            <nav class="navbar navbar-inverse navbar-static-top"
                 style="display: flex;flex-wrap: wrap;align-items: center;width: 1400px">
                <div class="container" style="width: 800px">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Ecommerce</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="before">主页</a></li>
                            <li><a href="#">个人中心</a></li>
                            <li><a href="myFocus">收藏夹</a></li>
                            <li><a href="cart/selectCart">购物车</a></li>
                            <li><a href="myOrder">我的订单</a></li>
                        </ul>
                    </div>
                </div>
                <div class="container">
                    <form class="navbar-form navbar-right" action="search">
                        <div class="input-group">
                            <div class="input-group-btn">
                                <input type="text" class="form-control" name="mykey" placeholder="Search"/>
                                <input type="submit" class="btn btn-default" style="border: none;border-top-left-radius: 2px;border-top-right-radius: 2px;height: 34px;border-left: 1px solid #ddd" value="搜索"/>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="navbar-header">
                    <c:if test="${sessionScope.buser != null}">
                        <a class="navbar-brand" href="before/exit" style="float: right">退出</a>
                        <a class="navbar-brand" href="#" style="float: right">${sessionScope.buser.bemail}</a>
                    </c:if>
                    <c:if test="${sessionScope.buser == null}">
                        <div class="btn-group">
                            <button style="float:left;cursor: pointer;background-color: #222;outline:none;border:none;padding-top: 9px;color: whitesmoke;padding-left: 5px " type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                登录 <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="before/toLogin">登录</a></li>
                                <li><a href="before/toPageBeforeRegister">注册</a></li>
                            </ul>
                        </div>
                    </c:if>
                </div>
            </nav>
        </div>
    </div>
</div>
</body>
</html>