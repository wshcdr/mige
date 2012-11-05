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
<script type="text/javascript">
	function search() {
		//TODO check input
		document.form_search.submit();
	}
</script>
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="587"
		style="margin: 2px 0 0 0;">
		<tr>
			<td valign="top">
				<div class="right_home_title_1">
					<div class="right_title">内容</div>
					<div>
						<div class="right_title_1">会员管理</div>
						<div class="right_title_1_icon"></div>
						<div class="right_title_1_nav">列表查看</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="right_home_title_4">
					<form name='form_search' action="content_member.do" method="post">
						<div style="float: left; margin: 3px 16px 0 0;">会员搜索</div>
						<div class="form_box_9">
							<input type="text" name="membername" class="form_input_8" />
						</div>
						<div style="float: left; margin: 3px 16px 0 0;">
							<a href="javascript:form_search.submit()" class="buttom_13"
								onmouseover="this.style.background='url(images/btn_14_2.png) no-repeat;'"
								onmouseout="this.style.background='url(images/btn_14_1.png) no-repeat;'"></a>
						</div>
						<div class="clear"></div>
					</form>
				</div>
				<div class="list_operate">
					<div class="list_operate_rcontent">
						<font class="font_14_1"><a href="#">跳转</a></font>
					</div>
					<div class="list_operate_rcontent">
						<div class="form_box_6">
							<input name="" type="text" class="form_input_6"
								onfocus="this.style.color='#085c25'" onblur="this.style.color='#aaaaaa'" />
						</div>
					</div>
					<div class="list_operate_rcontent">
						<font class="font_14_2">共 5 页</font>
					</div>
					<div class="list_operate_rcontent">
						<font class="font_14_1"><a href="#">下一页</a></font>
					</div>
					<div class="list_operate_rcontent">
						<font class="font_14_1"><a href="#">上一页</a></font>
					</div>
					<div class="clear"></div>
				</div>

				<div class="right_content_1">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
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
							<tr class="list_tr_2">
								<td height="39">${user.id}</td>
								<td>${user.loginName}</td>
								<td>${user.name}</td>
								<td>${user.sex.name}</td>
								<td>${user.country}</td>
								<td>${user.city}</td>
								<td>${user.postCode}</td>
								<td>${user.address}</td>
								<td>${user.telephone}</td>
								<td><s:date name="#user.birthday" format="yyyy-MM-dd" /></td>
								<td>${user.email}</td>
								<td>${user.transportation}</td>
								<td>${user.favorite}</td>
								<td><s:date name="#user.createTime" format="yyyy-MM-dd HH:mm" /></td>
								<td>${user.isComplete}</td>
							</tr>
						</s:iterator>
					</table>
					<div class="list_operate_1">
						<div class="list_operate_rcontent">
							<font class="font_14_1"><a href="#">跳转</a></font>
						</div>
						<div class="list_operate_rcontent">
							<div class="form_box_6">
								<input name="" type="text" class="form_input_6"
									onfocus="this.style.color='#085c25'"
									onblur="this.style.color='#aaaaaa'" />
							</div>
						</div>
						<div class="list_operate_rcontent">
							<font class="font_14_2">共 5 页</font>
						</div>
						<div class="list_operate_rcontent">
							<font class="font_14_1"><a href="#">上一页</a></font>
						</div>
						<div class="list_operate_rcontent">
							<font class="font_14_1"><a href="#">下一页</a></font>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
