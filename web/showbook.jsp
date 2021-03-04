<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书信息展示页面</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("table tr:odd td").css("color","red");  //改变奇数行背景色
            $("table tr:even td").css("color","green");  //改变偶数行背景色
            $("table tr td").css("background-color","#F5F6F7");  //改变奇数行背景色
            if(${!empty message}){
                $('#mes').html("${message}");
                setTimeout(function () {
                    $('#mes').html("");
                },2000)
            }
        })
    </script>
</head>
<body>
<div style="font-size: 20px;margin: 0 auto;text-align:center;width: 900px;height: 800px;">
    <h1 style="font-size: 25px">图书信息展示<span style="margin-left: 30px;"><a href="addbook.jsp">新增+</a></span></h1>
    <span id="mes" style="color: green"></span>
    <table style="margin: 0 auto;" border="1" cellpadding="5px" cellspacing="0">
        <tr>
			<th>图书编号</th>
			<th>书名</th>
			<th>图书单价</th>
			<th>作者</th>
			<th>操作</th>
        </tr>
        <c:forEach items="${list.list }" var="book">
            <tr>
				<td>${book.id}</td>
				<td>${book.bookName}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
                <td>
                    <a href="BookServlet?method=findById&id=${book.id}">修改</a>
                    <a href="BookServlet?method=deleteById&id=${book.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
		<tr>
            <td>
                <a href="BookServlet?method=pageList&curr=${list.currPage}&num=5">5</a>
                <a href="BookServlet?method=pageList&curr=${list.currPage}&num=10">10</a>
                <a href="BookServlet?method=pageList&curr=${list.currPage}&num=20">20</a>
                <a href="BookServlet?method=pageList&curr=${list.currPage}&num=50">50</a>
                <a href="BookServlet?method=pageList&curr=${list.currPage}&num=100">100</a>
            </td>
            <td style="text-align: right;" colspan="8">
                <span style="float: left;">总记录数<span style="color: red;">${list.totalCount}</span>条/共<span style="color: red;">${list.totalPage}</span>页</span>
                <a href="BookServlet?method=pageList&curr=1&num=${list.numPage}">首页</a>
                <c:if test="${list.currPage>1}">
                    <a href="BookServlet?method=pageList&curr=${list.currPage-1}&num=${list.numPage}">上一页</a>
                </c:if>
                <c:forEach var="i" begin="1" end="${list.totalPage}">
                    <a href="BookServlet?method=pageList&curr=${i}&num=${list.numPage}">${i}</a>
                </c:forEach>
                <c:if test="${list.currPage<list.totalPage}">
                    <a href="BookServlet?method=pageList&curr=${list.currPage+1}&num=${list.numPage}">下一页</a>
                </c:if>
                <a href="BookServlet?method=pageList&curr=${list.totalPage}&num=${list.numPage}">尾页</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
