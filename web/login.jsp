<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/validate.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //用validate验证表单,提交表单时触发
            jQuery.validator.addMethod("isName",function(name){
                return name=="admin";
            });
            jQuery.validator.addMethod("isPwd",function(password){
                return password=="admin";
            });
            $("form").validate({
                rules:{
                    "name":{required:true,isName:true},
                    "password":{required:true,isPwd:true}
                },
                messages:{
                    "name":{required:"<span style='color:red;'>用户名不能为空</span>",isName:"<span style='color:red;'>用户名错误!</span>"},
                    "password":{required:"<span style='color:red;'>密码不能为空</span>",isPwd:"<span style='color:red;'>密码错误!</span>"}
                },
                //验证通过之后回调函数
                submitHandler: function(form) {
                    window.location.href="index.jsp";
                }
            });
        })
    </script>
</head>
<body>
    <form>
        <h1 align="center">用户登录</h1>
        <table width="360px" style="margin: 0 auto;">
            <tr>
                <td>用户名: </td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>密码: </td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>&emsp;</td>
                <td>
                    <input type="submit" value="提交">&emsp;
                    <input type="reset" name="重置">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
