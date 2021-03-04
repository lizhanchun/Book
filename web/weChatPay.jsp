<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="get" action="http://ceshi.qfjava.cn/payment/weixinpay">
        订单价格:<input type="text" name="price" value="1">
        订单介绍:<input type="text" name="body" value="订单支付">
        订单号:<input type="text" name="orderId" value="666666">
        回调地址:<input type="text" name="url" value="http://localhost:8080/Book/showbook.jsp">
        确认订单:<input type="submit" value="确认支付">
    </form>
</body>
</html>
