<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>米格网</title>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js?appkey=2504309974" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div id="wb_connect_btn"></div>
<script type="text/javascript">
WB2.anyWhere(function(W){
	W.widget.connectButton({
		id: "wb_connect_btn",
		type:'3,2',
		callback : {
			login:function(o){	//登录后的回调函数
				alert("login: "+o.screen_name);
			},
			logout:function(){	//退出后的回调函数
				alert('logout');
			}
		}
	});
});
</script>
<a href="https://api.weibo.com/oauth2/authorize?client_id=2504309974&response_type=code&redirect_uri=http://ghh.co.nf:8087/mige/weibo_auth.jsp">微博登录</a>
</body>
</html>
