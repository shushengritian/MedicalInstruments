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
        <input type="text"  id="partyB" placeholder="乙方单位" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-inline">
        <input type="text" id="cName" placeholder="合同名称" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-inline">
        <input type="text" id="cType" placeholder="合同类型" autocomplete="off" class="layui-input">
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">签订时间</label>
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
        <button class="layui-btn" onclick="getTableDate(1)" id="searchBtn">
            <i class="layui-icon">&#xe615;</i></button>
        <button class="layui-btn" onclick="addBtn()"><i class="layui-icon"></i>添加</button>
    </div>
</div>
<table id="contract" class="layui-table" lay-filter="test" >
    <thead>
    <th>合同编号</th>
    <th>合同名称</th>
    <th>合同类型</th>
    <th>乙方单位</th>
    <th>乙方联系人</th>
    <th>联系电话</th>
    <th>签订日期</th>
    <th>截止日期</th>
    <th>合同内容</th>
    <th>操作</th>
    </thead>
    <tbody id="dataBody"></tbody>
</table>
<div id="pager"></div>
<form id="infoForm" style="display: none;">
    <div style="height: 30px"></div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">合同编号</label>
            <div class="layui-input-inline">
                <input type="text" id="cNoF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">合同名称</label>
            <div class="layui-input-inline">
                <input type="text" id="cNameF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">合同类型</label>
            <div class="layui-input-inline">
                <input type="text" id="cTypeF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">乙方单位</label>
            <div class="layui-input-inline">
                <input type="text" id="partyBF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">乙方联系人</label>
            <div class="layui-input-inline">
                <input type="text" id="bContactsF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">联系人电话</label>
            <div class="layui-input-inline">
                <input type="text" id="phoneF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">签订日期</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="signedDateF" placeholder="yyyy-MM-dd">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">截止日期</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="endDateF" placeholder="yyyy-MM-dd">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">合同内容</label>
            <div class="layui-input-inline">
                <input type="text" id="contentF" lay-verify="required" autocomplete="off" class="layui-input">
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
        $.post("/contract/selectContract",{
            partyB: $('#partyB').val(),
            cName: $('#cName').val(),
            cType: $('#cType').val(),
            startDate: $('#startDate').val(),
            endDate: $('#endDate').val(),
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
            row.append('<td>'+ v.cNo +'</td>');
            row.append('<td>'+ v.cName +'</td>');
            row.append('<td>'+ v.cType +'</td>');
            row.append('<td>'+ v.partyB +'</td>');
            row.append('<td>'+ v.bContacts +'</td>');
            row.append('<td>'+ v.phone +'</td>');
            row.append('<td>'+ v.signedDate +'</td>');
            row.append('<td>'+ v.endDate +'</td>');
            row.append('<td>'+ v.content +'</td>');
            row.append('<td><a class="layui-btn layui-btn-xs" onclick="edit('+v.id+')">编辑</a>' +
                '<a class="layui-btn layui-btn-danger layui-btn-xs" onclick="del('+v.id+')" >删除</a></td>');
            $("#contract").append(row);
        });
    }
    function addBtn() {
        var index = layer.open({
            title: "添加合同",
            type: 1, //page层
            area: ['340px', '400px'],
            shade: 0.6, //遮罩透明度
            closeBtn: 1,
            shift: 0, //0-6的动画形式，-1不开启
            content: $('#infoForm'),
            btn: ['确定', '取消'],
            yes: function () {
                $.post("/contract/add",{
                    cNo : $('#cNoF').val(),
                    cName : $('#cNameF').val(),
                    cType : $('#cTypeF').val(),
                    partyB : $('#partyBF').val(),
                    bContacts : $('#bContactsF').val(),
                    phone : $('#phoneF').val(),
                    signedDate : $('#signedDateF').val(),
                    endDate : $('#endDateF').val(),
                    content : $('#contentF').val()
                },function (result) {
                    var res = JSON.parse(result);
                    layer.msg(res.msg);
                    layer.close(index);
                });
            }
        });
    }
    function edit(id) {
        $(':input','#infoForm')
            .not(':button,:submit,:reset,:hidden')   //将myform表单中input元素type为button、submit、reset、hidden排除
            .val('')  //将input元素的value设为空值
            .removeAttr('checked')
            .removeAttr('checked') // 如果任何radio/checkbox/select inputs有checked or selected 属性，将其移除
        //通过id查询数据
        $.post("/contract/getContract",{
            id : id
        },function (result) {
            var res = JSON.parse(result);
            console.log(res);
            if (res.code == 1) {
                var data = res.data;
                id : id,
                $('#cNoF').val(data.cNo),
                $('#cNameF').val(data.cName),
                $('#cTypeF').val(data.cType),
                $('#partyBF').val(data.partyB),
                $('#bContactsF').val(data.bContacts),
                $('#phoneF').val(data.phone),
                $('#signedDateF').val(data.signedDate),
                $('#endDateF').val(data.endDate),
                $('#contentF').val(data.content)
            }
        });
        var index = layer.open({
            title: "编辑合同信息",
            type: 1, //page层
            area: ['340px', '400px'],
            shade: 0.6, //遮罩透明度
            closeBtn: 1,
            shift: 0, //0-6的动画形式，-1不开启
            content: $('#infoForm'),
            btn: ['确定', '取消'],
            yes: function () {
                $.post("/contract/edit",{
                    id : id,
                    cNo : $('#cNoF').val(),
                    cName : $('#cNameF').val(),
                    cType : $('#cTypeF').val(),
                    partyB : $('#partyBF').val(),
                    bContacts : $('#bContactsF').val(),
                    phone : $('#phoneF').val(),
                    signedDate : $('#signedDateF').val(),
                    endDate : $('#endDateF').val(),
                    content : $('#contentF').val()
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
            $.post("/contract/del",{
                id : id
            },function (result) {
                var res = JSON.parse(result);
                layer.msg(res.msg);
                getTableDate(1);
            });
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
        laydate.render({
            elem: '#signedDateF'
        });
        laydate.render({
            elem: '#endDateF'
        });

        //……

        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
        //form.render();
    });
</script>
</body>
</html>
