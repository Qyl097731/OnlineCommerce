<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/11/3
  Time: 20:44
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
          href="/css/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script src="/jquery/jquery-3.5.1.min.js"></script>
    <script src="/jquery/jquery-3.5.1.js"></script>
    <script src="/css/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="/css/before/main.css" rel="stylesheet"/>
    <link href="/css/before/carousel.css" rel="stylesheet"/>
    <script>
        $('#myCarousel').carousel({
            interval: 2000
        })
        $(document).ready(function () {
        })
    </script>
</head>
<body>
<div style="display: flex;flex-wrap: wrap;align-items: center;width: 1400px;height:auto;margin: 0 auto;justify-content: space-between">
    <jsp:include page="head.jsp"/>
    <div class="container" id="sidebar"
         style="width: 260px;height:500px;padding: 0;margin-top: 22px;">
        <div class="list-group" style="width: 260px;height:500px;">
            <c:forEach items="${sessionScope.goodsType}" var="type">
                <a href="selectGoodsByTypeId?id=${type.id}" class="list-group-item" style="height: 50px">${type.typename}</a>
            </c:forEach>
        </div>
    </div>

    <div id="myCarousel" class="carousel slide" data-ride="carousel"
         style="width: 1140px;margin: 50px auto">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox" style="width: 1140px;">
            <div class="item active" style="width: 1140px;text-align: center">
                <img class="first-slide"
                     src="/logos/${noticelist[0].npicture}"
                     alt="First slide" style="cursor: pointer">
                <div class="container" style="text-align: center">
                    <div class="carousel-caption">
                    </div>
                </div>
            </div>
            <div class="item">
                <img class="second-slide" src="/logos/${noticelist[1].npicture}"
                     alt="Second slide" style="cursor: pointer">
                <div class="container">
                    <div class="carousel-caption">
                        <!--          <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>-->
                    </div>
                </div>
            </div>
            <div class="item">
                <img class="third-slide"
                     src="/logos/${noticelist[2].npicture}"
                     alt="Third slide" style="cursor: pointer">
                <div class="container">
                    <div class="carousel-caption">
                        <!--          <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>-->
                    </div>
                </div>
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div><!-- /.carousel -->
</div>

<div class="container marketing" style="width: 1400px;">

    <div class="row" style="display: flex;flex-wrap: wrap;flex: 1">
        <div style="width: 1300px;border-bottom: 1px solid #767676; margin-bottom: 20px">
            <h1>新品推荐</h1>
        </div>
        <c:if test="${lastedlist.size() > 0}">
            <c:forEach items="${lastedlist}" var="goods">
                <div class="col-lg-4">
                    <img class="img-thumbnail" src="logos/${goods.gpicture}"
                         alt="goods image" width="180" height="180" style="cursor: pointer"
                         onclick="window.location='goodsDetail?id=${goods.id}'">
                    <h4>${goods.gname}</h4>
                    <p>${goods.description}</p>
                    <p><a class="btn btn-default" href="goodsDetail?id=${goods.id}" role="button">View details
                        &raquo;</a></p>
                </div>
                <!-- /.col-lg-4 -->
            </c:forEach>
        </c:if>
        <c:if test="${lastedlist.size() == 0}">
            <div class="col-lg-12">
                暂时没上新。
            </div>
        </c:if>
    </div>

    <div class="row" style="display: flex;flex-wrap: wrap;flex: 1">
        <div style="width: 1300px;border-bottom: 1px solid #767676; margin-bottom: 20px">
            <h1>热门推荐</h1>
        </div>
        <c:if test="${salelist.size() == 0}">
            <div class="col-lg-12">
                暂时没有热销产品。
            </div>

        </c:if>
        <c:if test="${salelist.size() > 0}">
            <c:forEach items="${salelist}" var="goods">
                <div class="col-lg-3" style="text-align: center">
                    <img class="img-thumbnail" src="/logos/${goods.gpicture}"
                         alt="goods image" width="180" height="180" style="cursor: pointer"
                         onclick="window.location='goodsDetail?id=${goods.id}'">
                    <h4>${goods.gname}</h4>
                    <p>${goods.description}</p>
                    <p><a class="btn btn-default" href="goodsDetail?id=${goods.id}" role="button">View details
                        &raquo;</a>
                    </p>
                </div>
            </c:forEach>
        </c:if>
    </div>

    <div class="row" style="display: flex;flex-wrap: wrap;flex: 1">
        <div style="width: 1300px;border-bottom: 1px solid #767676; margin-bottom: 20px">
            <h1>猜你喜欢</h1>
        </div>

        <c:if test="${focuslist.size() == 0}">
            <div class="col-lg-12">
              暂时没有推荐。
            </div>
        </c:if>
        <c:if test="${focuslist.size() > 0}">
            <c:forEach items="${focuslist}" var="goods">
                <div class="col-lg-4" style="text-align: center">
                    <img class="img-thumbnail" src="/logos/${goods.gpicture}"
                         alt="goods image" width="180" height="180" style="cursor: pointer"
                         onclick="window.location='goodsDetail?id=${goods.id}'">
                    <h4>${goods.gname}</h4>
                    <p>${goods.description}</p>
                    <p><a class="btn btn-default" href="goodsDetail?id=${goods.id}" role="button">View details
                        &raquo;</a></p>
                </div>
            </c:forEach>
        </c:if>
    </div>

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->


    <!-- FOOTER -->
    <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>
</div>

</body>
</html>
