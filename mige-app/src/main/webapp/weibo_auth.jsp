<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%
	String url = "https://api.weibo.com/oauth2/access_token?client_id=2504309974&client_secret=7d2f3f310699643ffb1e54be1bf463d5&grant_type=authorization_code&redirect_uri=http://ghh.co.nf&code=";
	url += request.getParameter("code");
	System.out.println(url);
	response.sendRedirect(url);
%>
