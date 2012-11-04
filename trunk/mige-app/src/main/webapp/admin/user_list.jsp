<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>stuttgart8</title>
<script type="text/javascript" src="../js/jquery-1.8.1.js"></script>
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div>用户列表</div>
	<table width="100%" border="1" cellspacing="0" cellpadding="0">
		<tr class="list_tr_1">
			<td align="center">ID</td>
			<td align="center">登录名</td>
			<td align="center">姓名</td>
			<td align="center">性别</td>
			<td align="center">国家</td>
			<td align="center">城市</td>
			<td align="center">邮编</td>
			<td align="center">地址</td>
			<td align="center">电话</td>
			<td align="center">生日</td>
			<td align="center">邮箱</td>
			<td align="center">出行方式</td>
			<td align="center">品牌</td>
			<td align="center">注册时间</td>
			<td align="center">是否完整</td>
		</tr>
		<s:iterator value="userList" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.loginName}</td>
			<td>${user.name}</td>
			<td>${user.sex.name}</td>
			<td>${user.country}</td>
			<td>${user.city}</td>
			<td>${user.postCode}</td>
			<td>${user.address}</td>
			<td>${user.telephone}</td>
			<td><s:date name="#user.birthday" format="yyyy-MM-dd"/></td>
			<td>${user.email}</td>
			<td>${user.transportation}</td>
			<td>${user.favorite}</td>
			<td><s:date name="#user.createTime" format="yyyy-MM-dd HH:mm"/></td>
			<td>${user.isComplete}</td>
		</tr>
		</s:iterator>
	</table>
</body>
</html>
