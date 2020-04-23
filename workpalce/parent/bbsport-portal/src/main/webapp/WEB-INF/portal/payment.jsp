<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>订单支付页 -新巴巴商城</title>
    <!--结算页面样式-->
    <link rel="stylesheet" type="text/css" href="/css/base.css" media="all" />
    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
    <script type="text/javascript" src="/js/base.js"></script>
    <link type="text/css" rel="stylesheet" href="/css/a_002.css"
          source="widget">
    <link type="text/css" rel="stylesheet" href="/css/a.css">
</head>
<body>
<jsp:include page="commons/shortcut.jsp" />
<div class="w w1 header clearfix">
    <div id="logo">
        <a href="/"><img src="/images/XBB2.png" alt="新巴巴商城"></a> <a
            href="javascript:;" class="link2"><b></b>"结算页"</a>
    </div>
    <div class="stepflex" id="#sflex03">
        <dl class="first done">
            <dt class="s-num">1</dt>
            <dd class="s-text">
                1.我的购物车<s></s><b></b>
            </dd>
        </dl>
        <dl class="normal doing">
            <dt class="s-num">2</dt>
            <dd class="s-text">
                2.支付<s></s><b></b>
            </dd>
        </dl>
        <dl class="normal last">
            <dt class="s-num">3</dt>
            <dd class="s-text">
                3.成功提交订单<s></s><b></b>
            </dd>
        </dl>
    </div>
</div>
<form action="/payment.pay" method="post">

</form>
</body>
</html>
