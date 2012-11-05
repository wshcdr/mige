<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>米格网</title>
<script type="text/javascript">
	function login() {
		var name = document.getElementById("lname").value;
		if (!name) {
			alert("输入用户名");
			return;
		}
		document.login_form.submit();
	}
	
	function completeUserInfo() {
		var userId = document.getElementById("userId").value;
		if (!userId) {
			alert("填写用户ID");
			return;
		}
		if(!/\d+/g.test(userId)) {
			alert("ID必须是数字");
			return;
		}
		window.open("perfect_inf.jsp?userId=" + userId);
	}
</script>
</head>
<body>
<form name="login_form" action="login.do" method="post">
	<table>
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="user" id="lname"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="登录" onclick="login()">
			</td>
		</tr>
	</table>
</form>
<br/><br/><br/>

<a href="registry.jsp" target="blank">注册用户</a><br/><br/><br/>

<input id="userId" type="text" size="2">
<input type="button" value="完善信息" onclick="completeUserInfo()">
<span>(在左边的输入框中填写用户ID)</span><br/><br/><br/>

<a href="admin/user_list.do">用户列表</a>
</body>
</html>
