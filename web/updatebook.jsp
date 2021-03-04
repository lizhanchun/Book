<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>欢迎来到修改页面</title>
</head>
<body>
<div>
<form method="post" action="BookServlet?method=update">
	<table style="margin: 0 auto;">
		<tr>
			<th colspan="2">修改图书信息</th>
		</tr>
		<input type="hidden" name="id" value="${book.id}"/></td>
		<input type="hidden" name="flag" value="${book.flag}"/></td>
		<tr>
			<td>书名:</td>
			<td><input type="text" name="bookName" value="${book.bookName}"/></td>
			<td></td>
		</tr>
		<tr>
			<td>图书单价:</td>
			<td><input type="text" name="price" value="${book.price}"/></td>
			<td></td>
		</tr>
		<tr>
			<td>作者:</td>
			<td><input type="text" name="author" value="${book.author}"/></td>
			<td></td>
		</tr>

		<tr>
			<td>&nbsp;</td>
			<td>
				<input type="submit" value="提交" />
				<input type="reset" value="重置">
			</td>
			<td></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
