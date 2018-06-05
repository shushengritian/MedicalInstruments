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
            <input type="text" name="id" id="id" placeholder="ID" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <input type="text" name="columnName" id="columnName" placeholder="列名" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <input type="text" name="insideValue" id="insideValue" placeholder="参数值" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <input type="text" name="exteriorValue" id="exteriorValue" placeholder="参数名称" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <button class="layui-btn" onclick="getTableDate(1)" id="searchBtn">
                <i class="layui-icon">&#xe615;</i></button>
            <button class="layui-btn" onclick="addBtn()"><i class="layui-icon"></i>添加</button>
        </div>
    </div>
<table id="dataDictionary" class="layui-table" lay-filter="test" >
    <thead>
        <th>ID</th>
        <th>列名</th>
        <th>参数值</th>
        <th>参数名称</th>
        <th>操作</th>
    </thead>
    <tbody id="dataBody"></tbody>
</table>
<div id="pager"></div>
<form id="infoForm" style="display: none;">
    <div style="height: 30px"></div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">列名</label>
            <div class="layui-input-inline">
                <input type="text" id="columnNameF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">参数值</label>
            <div class="layui-input-inline">
                <input type="text" id="insideValueF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">参数名称</label>
            <div class="layui-input-inline">
                <input type="text" id="exteriorValueF" lay-verify="required" autocomplete="off" class="layui-input">
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
        getTableDate(1);
    });

    function getTableDate(pageNo) {
        if (!pageNo)
            pageNo = 1;
        var pageSize = 10;
        $.post("/home/selectDateDictionary",{
            id: $('#id').val(),
            columnName: $('#columnName').val(),
            insideValue: $('#insideValue').val(),
            exteriorValue: $('#exteriorValue').val(),
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
            row.append('<td>'+ v.id +'</td>');
            row.append('<td>'+ v.columnName +'</td>');
            row.append('<td>'+ v.insideValue +'</td>');
            row.append('<td>'+ v.exteriorValue +'</td>');
            row.append('<td><a class="layui-btn layui-btn-xs" onclick="edit('+v.id+')">编辑</a>' +
                '<a class="layui-btn layui-btn-danger layui-btn-xs" onclick="del('+v.id+')" >删除</a></td>');
            $("#dataDictionary").append(row);
        });
    }
    function addBtn() {
        var index = layer.open({
            title: "添加静态参数",
            type: 1, //page层
            area: ['340px', '360px'],
            shade: 0.6, //遮罩透明度
            closeBtn: 1,
            shift: 0, //0-6的动画形式，-1不开启
            content: $('#infoForm'),
            btn: ['确定', '取消'],
            yes: function () {
                $.post("/home/add",{
                    columnName : $('#columnNameF').val(),
                    insideValue : $('#insideValueF').val(),
                    exteriorValue : $('#exteriorValueF').val()
                },function (result) {
                    var res = JSON.parse(result);
                    layer.msg(res.msg);
                    layer.close(index);
                });
            }
        });
    }
    function edit(id) {
        //通过id查询数据
        $.post("/home/getData",{
            id : id
        },function (result) {
            var res = JSON.parse(result);
            console.log(res);
            if (res.code == 1) {
                var data = res.data;
              $('#columnNameF').val(data.columnName),
              $('#insideValueF').val(data.insideValue),
              $('#exteriorValueF').val(data.exteriorValue)
            }
        });
        var index = layer.open({
            title: "编辑静态参数",
            type: 1, //page层
            area: ['340px', '360px'],
            shade: 0.6, //遮罩透明度
            closeBtn: 1,
            shift: 0, //0-6的动画形式，-1不开启
            content: $('#infoForm'),
            btn: ['确定', '取消'],
            yes: function () {
                $.post("/home/edit",{
                    id : id,
                    columnName : $('#columnNameF').val(),
                    insideValue : $('#insideValueF').val(),
                    exteriorValue : $('#exteriorValueF').val()
                },function (result) {
                    var res = JSON.parse(result);
                    layer.msg(res.msg);
                    layer.close(index);
                });
            },
            end: function () {
                setTimeout(function () {
                    getTableDate(1);
                },2000);
            }
        });
    }
    function del(id) {
        //通过id删除数据
        layer.confirm('是否确认删除此条记录？', {
            title : '确认删除',
            btn : [ '确定', '取消' ]
            //按钮
        }, function(index) {
            layer.close(index);
            $.post("/home/del",{
                id : id
            },function (result) {
                var res = JSON.parse(result);
                layer.msg(res.msg);
                getTableDate(1);
            });
        });
    }
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>
