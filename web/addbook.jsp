<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>欢迎来到新增图书页面</title>
	<script src="js/jquery.min.js"></script>
	<script src="js/validate.min.js"></script>
	<script type="text/javascript">
		$(function () {
			//用validate验证表单,提交表单时触发
			$("form").validate({
				rules:{
					"bookName":{required:true},
					"price":{required:true},
					"author":{required:true}
				},
				messages:{
					"bookName":{required:"<span style='color:red;'>书名不能为空!</span>"},
					"price":{required:"<span style='color:red;'>价格不能为空!</span>"},
					"author":{required:"<span style='color:red;'>作者不能为空!</span>"}
				}
			});
		})
	</script>
</head>
<body>
<div>
<form method="post" action="BookServlet?method=add">
	<table style="margin: 0 auto;">
		<tr>
			<th colspan="2">新增图书</th>
		</tr>
		<input type="hidden" name="flag" value="true"/>
		<tr>
			<td>书名:</td>
			<td><input type="text" name="bookName" /></td>
			<td></td>
		</tr>
		<tr>
			<td>图书单价:</td>
			<td><input type="text" name="price" /></td>
			<td></td>
		</tr>
		<tr>
			<td>作者:</td>
			<td><input type="text" name="author" /></td>
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
