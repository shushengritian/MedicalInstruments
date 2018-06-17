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
<form class="layui-form" action="#">
    <div class="layui-form-item">
        <div class="layui-inline">
            <input type="text" name="id" id="id" placeholder="ID" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <input type="text" name="number" id="number" placeholder="科室编号" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <input type="text" name="name" id="name" placeholder="科室名称" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <input type="text" name="landline" id="landline" placeholder="座机" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <select id="status">
                <option value="">请选择科室状态</option>
                <option value="1">启用</option>
                <option value="2">停用</option>
                <option value="3">废除</option>
            </select>
        </div>
        <div class="layui-inline">
            <button class="layui-btn" onclick="getTableDate(1)" id="searchBtn">
                <i class="layui-icon">&#xe615;</i></button>
            <button class="layui-btn" onclick="addBtn()"><i class="layui-icon"></i>添加</button>
        </div>
    </div>
</form>
<table id="department" class="layui-table" lay-filter="test" >
    <thead>
    <th>ID</th>
    <th>科室编号</th>
    <th>科室名称</th>
    <th>座机</th>
    <th>状态</th>
    <th>操作</th>
    </thead>
    <tbody id="dataBody"></tbody>
</table>
<div id="pager"></div>
<form id="infoForm" style="display: none;" action="#" class="layui-form">
    <div style="height: 30px"></div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">科室编号</label>
            <div class="layui-input-inline">
                <input type="text" id="numberF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">科室名称</label>
            <div class="layui-input-inline">
                <input type="text" id="nameF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">座机</label>
            <div class="layui-input-inline">
                <input type="text" id="landlineF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-inline">
                <select id="statusF">
                    <option value="">请选择科室状态</option>
                    <option value="1">启用</option>
                    <option value="2">停用</option>
                    <option value="3">废除</option>
                </select>
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
        $.post("/department/selectDepartment",{
            id: $('#id').val(),
            number: $('#number').val(),
            name: $('#name').val(),
            landline: $('#landline').val(),
            status: $('#status').val(),
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
            row.append('<td>'+ v.number +'</td>');
            row.append('<td>'+ v.name +'</td>');
            row.append('<td>'+ v.landline +'</td>');
            var status = v.status;
            if ('1' == status) {
                status = '启用';
            } else if ('2' == status) {
                status = '停用';
            } else if ('3' == status) {
                status = '废除';
            }
            row.append('<td>'+ status +'</td>');
            row.append('<td><a class="layui-btn layui-btn-xs" onclick="edit('+v.id+')">编辑</a>' +
                '<a class="layui-btn layui-btn-danger layui-btn-xs" onclick="del('+v.id+')" >删除</a></td>');
            $("#department").append(row);
        });
    }
    function addBtn() {
        var index = layer.open({
            title: "添加科室",
            type: 1, //page层
            area: ['340px', '400px'],
            shade: 0.6, //遮罩透明度
            closeBtn: 1,
            shift: 0, //0-6的动画形式，-1不开启
            content: $('#infoForm'),
            btn: ['确定', '取消'],
            yes: function () {
                $.post("/department/add",{
                    number : $('#numberF').val(),
                    name : $('#nameF').val(),
                    landline : $('#landlineF').val(),
                    status : $('#statusF').val()
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
        $.post("/department/getDepartment",{
            id : id
        },function (result) {
            var res = JSON.parse(result);
            console.log(res);
            if (res.code == 1) {
                var data = res.data;
                $('#numberF').val(data.number),
                    $('#nameF').val(data.name),
                    $('#landlineF').val(data.landline),
                    $('#statusF').val(data.status)
            }
        });
        var index = layer.open({
            title: "编辑科室信息",
            type: 1, //page层
            area: ['340px', '400px'],
            shade: 0.6, //遮罩透明度
            closeBtn: 1,
            shift: 0, //0-6的动画形式，-1不开启
            content: $('#infoForm'),
            btn: ['确定', '取消'],
            yes: function () {
                $.post("/department/edit",{
                    id : id,
                    number : $('#numberF').val(),
                    name : $('#nameF').val(),
                    landline : $('#landlineF').val(),
                    status : $('#statusF').val()
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
            $.post("/department/del",{
                id : id
            },function (result) {
                var res = JSON.parse(result);
                layer.msg(res.msg);
                getTableDate(1);
            });
        });
    }
    layui.use('form', function(){
        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

        //……

        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
        //form.render();
    });
</script>
</body>
</html>
