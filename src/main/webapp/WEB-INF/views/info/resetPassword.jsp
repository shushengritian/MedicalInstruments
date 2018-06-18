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
        <div class="layui-form-item">
            <label class="layui-form-label">当前账号</label>
            <div class="layui-input-block">
                <input type="text" id="loginAccount" disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item  layui-hide">
            <label class="layui-form-label">登陆密码</label>
            <div class="layui-input-block">
                <input type="password" id="password" disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">旧密码</label>
            <div class="layui-input-block">
                <input type="password" id="oldPassword"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新密码</label>
            <div class="layui-input-block">
                <input type="password" id="newPassword"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" id="submit">修改密码</button>
            </div>
        </div>
    </div>
    <a id="newLogin" class="layui-hide" href="/login.jsp"></a>
</form>
<script src="<%=basePath%>/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery/pager/jquery.pager.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery/layer/layer.js"></script>
<script>
    $(function () {


        $('#oldPassword').blur(function(){
           if ($('#oldPassword').val() != $('#password').val()) {
               layer.msg('旧密码不正确，请重新输入',{icon:2,time:3000});
               $('#oldPassword').val('');
           }
        });
        $('#submit').click(function () {
            if ($('#oldPassword').val() == '') {
                layer.msg('请输入旧密码，才能修改密码',{icon:2,time:3000});
                return false;
            }
            $.post('/user/updatePassword',{
                loginAccount : $('#loginAccount').val(),
                oldPassword : $('#oldPassword').val(),
                newPassword : $('#newPassword').val()
            },function (result) {
                var res = JSON.parse(result);
                layer.msg(res.msg,{icon:1,time:3000});
                $.post('/user/newLogin',{

                },function (res) {

                })
            });



        });

        getUserInfo();
    });
    function getUserInfo() {
        $.post('/user/getUser',{
        },function (result) {
            var res = JSON.parse(result);
            if (res.code == '1') {
                $('#loginAccount').val(res.loginAccount);
                $('#password').val(res.password);
            } else {
                layer.msg(res.msg);
            }

        });
    }
</script>
</body>
</html>
