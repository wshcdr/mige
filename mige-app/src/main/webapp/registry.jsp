<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>米格网</title>
<script type="text/javascript">
	function registUser() {
		var lname = document.getElementById("login_name").value;
		if (!lname) {
			alert("用戶名不能为空");
			return;
		}
		document.forms.register.submit();
	}
</script>
</head>
<body>
	<form name="register" action="register_user.do" method="post">
		<table>
			<tr>
				<td>用戶名:</td>
				<td><input type="text" name="loginName" id="login_name"><span>(不要输入中文)</span></td>
			</tr>
			<tr>
				<td colspan="21">
					<input type="button" value="提交" onclick="registUser()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
