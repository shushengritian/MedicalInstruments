<%
    //String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
            request.getServerPort()+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<title>layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=basePath%>/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>/js/jquery/pager/pager.css" />
</head>
<body>
<div style="height: 30px"></div>
<form class="layui-form layui-row">
    <div class="layui-col-md6 layui-col-xs12">
        <div class="layui-form-item layui-hide">
            <label class="layui-form-label">id</label>
            <div class="layui-input-block">
                <input type="text" id="id"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" id="userName"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">登陆账号</label>
            <div class="layui-input-block">
                <input type="text" id="loginAccount" disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-block">
                <input type="tel" id="phone"   lay-verify="phone" class="layui-input userPhone">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input type="text" id="email"  lay-verify="email" class="layui-input userEmail">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">创建时间</label>
            <div class="layui-input-block">
                <input type="text" id="createTime" disabled  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">上次修改时间</label>
            <div class="layui-input-block">
                <input type="text" id="modifiedTime" disabled  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" id="updateBtn">立即提交</button>
            </div>
        </div>
    </div>
</form>
<script src="<%=basePath%>/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery/pager/jquery.pager.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery/layer/layer.js"></script>
<script>
    $(function () {
        getUserInfo();

        $('#updateBtn').click(function () {
            $.post('/user/updateUserInfo',{
                id : $('#id').val(),
                userName : $('#userName').val(),
                phone : $('#phone').val(),
                email : $('#email').val()
            },function (result) {
                var res = JSON.parse(result);
                layer.msg(res.msg);
            });
        });
    });
    function getUserInfo() {
        $.post('/user/getUserInfo',{

        },function (result) {
            var res = JSON.parse(result);
            var data = res.data;
            $('#userName').val(data.userName);
            $('#loginAccount').val(data.loginAccount);
            $('#phone').val(data.mobile);
            $('#email').val(data.email);
            $('#createTime').val(data.createTime);
            $('#modifiedTime').val(data.modifiedTime);
            $('#id').val(data.id);
        });
    }
</script>
</body>
</html>
