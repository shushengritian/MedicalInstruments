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
<div class="layui-form-item">

    <div class="layui-inline">
        <label class="layui-form-label">日期</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" id="startDate" placeholder="yyyy-MM-dd">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">至</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" id="endDate" placeholder="yyyy-MM-dd">
        </div>
    </div>
    <div class="layui-inline">
        <input type="text"  id="hcName" placeholder="耗材名称" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-inline">
        <input type="text" id="sType" placeholder="出入库类型" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-inline">
        <button class="layui-btn" onclick="getTableDate(1)" id="searchBtn">
            <i class="layui-icon">&#xe615;</i></button>
    </div>
</div>
<table id="accessStock" class="layui-table" lay-filter="test" >
    <thead>
    <th>日期</th>
    <th>单号</th>
    <th>类型</th>
    <th>耗材编号</th>
    <th>耗材名称</th>
    <th>单位</th>
    <th>单价</th>
    <th>数量</th>
    <th>金额</th>
    </thead>
    <tbody id="dataBody"></tbody>
</table>
<div id="pager"></div>
<script src="<%=basePath%>/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery/pager/jquery.pager.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery/layer/layer.js"></script>
<script>
    $(function () {
        getTableDate(1);
    });

    function getTableDate(pageNo) {
        if (!pageNo)
            pageNo = 1;
        var pageSize = 10;
        $.post("/stock/access",{
            startDate: $('#startDate').val(),
            endDate: $('#endDate').val(),
            hcName: $('#hcName').val(),
            sType: $('#sType').val(),
            pageNo : pageNo,
            pageSize : pageSize
        },function(result){
            $("#dataBody").empty();
            var res = JSON.parse(result);
            if (res.code == 1) {
                layer.msg(res.msg);
                createRow(res.data);
            } else {
                layer.msg(res.msg);
            }
            $("#pager").pager({
                currentPageNo : pageNo,
                totalRecordCount : res.count,
                pageSize : pageSize,
                showPageNoCount : 5,
                isShowRecordCount : true,
                isShowGoto : true,
                pageFunction : getTableDate
            });
        });
    }
    function createRow(data) {
        $.each(data,function (k,v) {
            var row = $('<tr></tr>');
            row.append('<td>'+ v.createTime +'</td>');
            row.append('<td>'+ v.singleNo +'</td>');
            row.append('<td>'+ v.sType +'</td>');
            row.append('<td>'+ v.hcNo +'</td>');
            row.append('<td>'+ v.hcName +'</td>');
            row.append('<td>'+ v.unit +'</td>');
            row.append('<td>'+ v.price +'</td>');
            row.append('<td>'+ v.number +'</td>');
            row.append('<td>'+ v.amount +'</td>');
            $("#accessStock").append(row);
        });
    }
    layui.use(['form','laydate'], function(){
        var form = layui.form
            ,laydate = layui.laydate;
        //常规用法
        laydate.render({
            elem: '#startDate'
        });
        laydate.render({
            elem: '#endDate'
        });

        //……

        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
        //form.render();
    });
</script>
</body>
</html>
