<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>米格网</title>
<script type="text/javascript">
	function registUser() {
		document.forms.perfectInfoForm.submit();
	}
</script>
</head>
<body>
	<form name="perfectInfoForm" action="perfect_inf.do" method="post">
		<input type="hidden" name="userId" value="${param.userId}">
		<table>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>
					<select name="sex">
						<option value="0">男</option>
						<option value="1">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>国家:</td>
				<td><input type="text" name="country"></td>
			</tr>
			<tr>
				<td>城市:</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>邮编:</td>
				<td><input type="text" name="postCode"></td>
			</tr>
			<tr>
				<td>地址:</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>电话:</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td>生日:</td>
				<td>
					<input type="text" name="birthday">
					<span>(yyyy-MM-dd)</span>
				</td>
			</tr>
			<tr>
				<td>邮箱:</td>
				<td><input type="text" name="mail"></td>
			</tr>
			<tr>
				<td>出行方式:</td>
				<td><input type="text" name="transportation"></td>
			</tr>
			<tr>
				<td>品牌:</td>
				<td><input type="text" name="favority"></td>
			</tr>
			<tr>
				<td>验证码:</td>
				<td><input type="text" name="verification"></td>
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
