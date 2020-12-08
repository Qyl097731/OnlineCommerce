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
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <script>
        $(document).ready(function () {
            if (${not empty msg}) {
                alert(${msg})
            }
            $('#btn-add').click(function () {
                let num = parseInt($("#num").val());
                $("#num").prop("value", num + 1);
                $("#btn-minus").attr("disabled", false)
                $("#btn-add").attr("disabled", false)
                if (num + 1 == ${goods.gstore}) {
                    $("#btn-add").attr("disabled", true)
                }
                if (num + 1 > 1) {
                    $("#btn-minus").attr("disabled", false)
                }
            })
            $('#btn-minus').click(function () {
                let num = parseInt($("#num").val());
                $("#num").prop("value", num - 1);
                $("#btn-minus").attr("disabled", false)
                $("#btn-add").attr("disabled", false)
                if (num - 1 <= 1) {
                    $("#btn-minus").attr("disabled", true)
                }
                if (num - 1 < ${goods.gstore}) {
                    $("#btn-add").attr("disabled", false)
                }
            })
            $('.dropdown-toggle').dropdown()
        })

        function toPage() {
            window.location = "cart/putCart?shoppingNum=" + $("#num").val() + "&id=${goods.id}";
        }

    </script>
</head>
<body>
<jsp:include page="head.jsp"/>
<div style="margin: 50px auto;height:50px;width: 1400px;">
    <ul class="nav nav-tabs" style="border: 1px solid #ddd;width: 1400px;display: flex;justify-content: space-between">
        <c:forEach items="${sessionScope.goodsType}" var="type">
            <li role="presentation"><a href="">${type.typename}</a></li>
        </c:forEach>
    </ul>
</div>
<div style="display: flex;flex-wrap: wrap;justify-content: space-between;width: 1400px;height:600px;border: 1px solid #ddd;margin: 0 auto">
    <div class="left"
         style="width: 475px;height:600px;display: flex;flex-wrap: wrap;justify-content: space-between">
        <img src="logos/${goods.gpicture}" style="height: 475px;width: 475px;padding: 15px">
        <div class="col-lg-12" style="height: 80px">
            <img class="img-thumbnail" src="logos/${goods.gpicture}"
                 alt="goods image" width="75" height="75">
            <img class="img-thumbnail" src="logos/noimage.png"
                 alt="goods image" width="75" height="75">
            <img class="img-thumbnail" src="logos/noimage.png"
                 alt="goods image" width="75" height="75">
            <img class="img-thumbnail" src="logos/noimage.png"
                 alt="goods image" width="75" height="75">
            <img class="img-thumbnail" src="logos/noimage.png"
                 alt="goods image" width="75" height="75">
        </div>
        <div style="padding-left: 20px;padding-top: 5px">
            <img src="logos/focus.png" alt="focus image" width="20" height="20">
            <a href="cart/focus?id=${goods.id}"
               style="font: 12px/1.5 tahoma,arial,'Hiragino Sans GB','\5b8b\4f53',sans-serif;">收藏宝贝(人气${focusNum})</a>
        </div>
    </div>

    <div style="display: flex;flex-wrap: wrap;width: 525px;height: 500px">
        <div style="width: 495px; border-bottom: 1px solid #ddd;">
            <h3 class="main-title">${goods.gname}</h3>
            <p3>${goods.description}</p3>
        </div>
        <div style="width: 525px;height:70px;background-color: #FFF2E8;padding: 15px;margin-top: 20px">
            <span style="display: inline;line-height: 40px;float: left;width: 60px; color: #6c6c6c;">价格</span>
            <span style="font-size: 35px;font-weight: 400;color: #f40;margin-right: 4px;line-height: 35px">￥</span>
            <span style="font-size: 35px;font-weight: 700;color: #f40;margin-right: 4px;line-height: 35px">${goods.grprice}</span>
            <span style="float: right;text-align: center"><strong>${saleNum}</strong><br><strong>交易成功</strong></span>
        </div>
        <div style="width: 525px;height:70px;padding: 15px;margin-top: 15px">
            <span style="line-height: 40px;float: left;width: 60px; color: #6c6c6c;">配送</span>
            <span style="line-height: 40px;float: left;color: #3c3c3c;">南京晓庄&nbsp;至</span>
            <div class="btn-group">
                <button type="button" class="btn btn-default dropdown-toggle"
                        style="float:left;cursor: pointer;border: 1px solid #fff;background-color: #fff;padding-top: 9px;color: #3c3c3c;padding-left: 5px"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    苏州吴江
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">苏州吴江</a></li>
                    <li><a href="#">徐州</a></li>
                    <li><a href="#">扬州</a></li>
                    <li><a href="#">其他</a></li>
                </ul>
            </div>
            <div style="display: inline;line-height: 40px;color: #3c3c3c;">快递费10元</div>
            <span style="float: right;text-align: center;line-height: 40px; color: #6c6c6c;"><strong>付款后30天内送达</strong></span>
        </div>
        <div style="width: 525px;height:70px;padding: 15px">
            <span style="line-height: 40px;float: left;width: 40px; color: #6c6c6c;">数量</span>
            <span>
                <button type="button" class="btn btn-sm btn-default" id="btn-minus" disabled>-</button>
                <input type="text" id="num" value="1"
                       style="width:65px; height:32px;border: 1px solid #ddd;text-align: center"/>
                <button type="button" class="btn btn-sm btn-default" id="btn-add">+</button>
                件（库存${goods.gstore}件）
            </span>
        </div>

        <div style="width: 525px;height:50px;">
            <a class="btn"
               style="line-height: 28px;width: 136px;height:40px;color: #E5511D;border-color: #F0CAB6;background: #FFE4D0;cursor: pointer;"
               href="javascript:toPage();">立即购买</a>
            <a class="btn"
               style="line-height: 28px;width: 182px;height:40px;color: #FFF;border-color: #F40;background: #F40;cursor: pointer;"
               href="javascript:toPage();">加入购物车</a>
        </div>
    </div>
    <div style="width: 375px;border: 1px solid gold;padding: 10px;color: black;font-size: 15px">
        <img width="350" src="//gtms01.alicdn.com/tps/i1/TB1NYpMFVXXXXXsXFXXFHLvIVXX-198-45.png">
        <div class="tb-shop-info-wrap" style="padding: 25px">
            <div class="tb-shop-info-hd">
                <div class="tb-shop-name" >
                    <dl>
                        <dd>
                            <strong>
                                <a href="#" title="章鱼欧巴限定店" target="_blank" style="color: black;">
                                    南京晓庄学院
                                </a>
                            </strong>
                        </dd>
                    </dl>
                </div>
            </div>
            <div class="tb-shop-rank tb-rank-blue" style="display: flex;flex-wrap: wrap;width: 300px">
                <dl>
                    <dt style="width: 50px;display: inline">信誉：</dt>
                    <dd style="width: 150px;display: inline">
                        <a href="#" target="_blank">
                            <i><img src="/logos/diamond.png" width="20px" height="20px"/></i>
                            <i><img src="/logos/diamond.png" width="20px" height="20px"/></i>
                            <i><img src="/logos/diamond.png" width="20px" height="20px"/></i>
                            <i><img src="/logos/diamond.png" width="20px" height="20px"/></i>
                            <i><img src="/logos/diamond.png" width="20px" height="20px"/></i>

                        </a>
                    </dd>
                </dl>
            </div>
            <div class="tb-shop-seller" style="width: 300px;display: flex;flex-wrap: wrap">
                <dl>
                    <dt style="width: 50px;display: inline">掌柜：</dt>
                    <dd style="width: 150px;display: inline">
                        <a class="tb-seller-name" href="//shop555941102.taobao.com" target="_blank" title="掌柜:你好，谢谢666">
                            你好，谢谢666
                        </a>
                    </dd>
                </dl>
            </div>
            <div class="tb-shop-ww" style="width: 300px;display: flex;flex-wrap: wrap">
                <dl>
                    <dt style="width: 50px;display: inline">联系：</dt>
                    <dd style="width: 150px;display: inline">
                        <span class="ww-light ww-large" data-nick="你好，谢谢666" data-tnick="%E4%BD%A0%E5%A5%BD%EF%BC%8C%E8%B0%A2%E8%B0%A2666" data-encode="true"><a href="https://amos.alicdn.com/getcid.aw?v=3&amp;groupid=0&amp;s=1&amp;charset=utf-8&amp;uid=%E4%BD%A0%E5%A5%BD%EF%BC%8C%E8%B0%A2%E8%B0%A2666&amp;site=cntaobao&amp;fromid=cntaobaot_1484890332079_0523" target="_blank" class="ww-inline ww-online" title="点此可以直接和卖家交流选好的宝贝，或相互交流网购体验，还支持语音视频噢。"><span>旺旺在线</span></a></span>
                    </dd>
                </dl>
            </div>
            <div class="tb-shop-icon" style="width: 300px;display: flex;flex-wrap: wrap; border-bottom: 1px solid #eee">
                <dl>
                    <dt style="width: 50px;display: inline">资质：</dt>
                    <dd style="width: 150px;display: inline">

                        <a class="glyphicon glyphicon-user" href="#" target="_blank" title="支付宝个人认证2016-12-06" data-spm="d12"></a>

                        <span class="tb-seller-bail" href="" target="_blank" title="已缴纳5038元保证金">
                            &nbsp;开店九年
                        </span>

                    </dd>
                </dl>
            </div>
            <div class="tb-shop-info-bd" style="width: 300px;display: flex;flex-wrap: wrap;padding-top: 20px">

                <div class="tb-shop-rate" style="width: 300px;display: flex;flex-wrap: wrap;justify-content: space-between">
                    <dl style="display: inline;border-right: 1px solid #eee">
                        <dt style="width: 90px;">描述</dt>

                        <dd class="tb-rate-higher" style="width: 90px;display: inline">
                            <a href="//rate.taobao.com/user-rate-ff3e1224cefb2c974c8cac855cc3d82d.htm" target="_blank" title="计算规则:(同行业平均分-店铺得分)/(同行业平均分-同行业店铺最低得分)">
                                4.9<img src="/logos/up.png" width="20px" height="20px">
                            </a>
                        </dd>
                    </dl>
                    <dl style="display:inline;border-right: 1px solid #eee">
                        <dt style="width: 90px;">服务</dt>

                        <dd class="tb-rate-higher" style="width: 90px;display: inline">
                            <a href="//rate.taobao.com/user-rate-ff3e1224cefb2c974c8cac855cc3d82d.htm" target="_blank" title="计算规则:(同行业平均分-店铺得分)/(同行业平均分-同行业店铺最低得分)">
                                4.9<img src="/logos/up.png" width="20px" height="20px">
                            </a>
                        </dd>
                    </dl>
                    <dl>
                        <dt style="width: 40px;border-right: 1px solid #eee">物流</dt>

                        <dd class="tb-rate-higher" style="width: 40px;display: inline">
                            <a href="//rate.taobao.com/user-rate-ff3e1224cefb2c974c8cac855cc3d82d.htm" target="_blank" title="计算规则:(同行业平均分-店铺得分)/(同行业平均分-同行业店铺最低得分)">
                                4.9<img src="/logos/up.png" width="20px" height="20px">
                            </a>
                        </dd>
                    </dl>
                </div>
            </div>
            <div style="margin-top: 20px;width: 300px;height:50px;display: flex;flex-wrap: w;justify-content: space-between">
                <a class="btn"
                   style="line-height: 28px;width: 120px;height:40px;color: black;background: #FAFAFA;cursor: pointer;"
                   href="javascript:toPage();">立即购买</a>
                <a class="btn"
                   style="line-height: 28px;width: 120px;height:40px;color: black;background: #FAFAFA;cursor: pointer;"
                   href="javascript:toPage();">加入购物车</a>
            </div>
        </div>
    </div>
</body>
</html>