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
            <input type="text" name="deviceNo" id="deviceNo" placeholder="设备编号" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <input type="text" name="deviceName" id="deviceName" placeholder="设备名称" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <input type="text" name="deviceType" id="deviceType" placeholder="设备类型" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline">
            <select id="isMeasurement">
                <option value="">是否计量设备</option>
                <option value="1">是</option>
                <option value="2">否</option>
            </select>
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
<table id="device" class="layui-table" lay-filter="test" >
    <thead>
    <th>ID</th>
    <th>设备编号</th>
    <th>设备名称</th>
    <th>单位</th>
    <%--<th>设备类型</th>--%>
    <th>计量设备</th>
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
            <label class="layui-form-label">设备编号</label>
            <div class="layui-input-inline">
                <input type="text" id="deviceNoF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">设备名称</label>
            <div class="layui-input-inline">
                <input type="text" id="deviceNameF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">单位</label>
            <div class="layui-input-inline">
                <input type="text" id="unitF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">设备类型</label>
            <div class="layui-input-inline">
                <input type="text" id="deviceTypeF" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">计量设备</label>
            <div class="layui-input-inline">
                <select id="isMeasurementF">
                    <option value="">是否计量设备</option>
                    <option value="1">是</option>
                    <option value="2">否</option>
                </select>
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
        $.post("/device/selectDevice",{
            id: $('#id').val(),
            deviceNo: $('#deviceNo').val(),
            deviceName: $('#deviceName').val(),
            deviceType: $('#deviceType').val(),
            isMeasurement: $('#isMeasurement').val(),
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
            row.append('<td>'+ v.deviceNo +'</td>');
            row.append('<td>'+ v.deviceName +'</td>');
            var unit = getUnit(v.unit);
            row.append('<td>'+ unit +'</td>');
           /* row.append('<td>'+ v.deviceType +'</td>');*/
            var isMeasurement = v.isMeasurement;
            if ('1' == isMeasurement) {
                isMeasurement = '是';
            } else if ('2' == isMeasurement) {
                isMeasurement = '否';
            }
            row.append('<td>'+ isMeasurement +'</td>');
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
            $("#device").append(row);
        });
    }
    function getUnit(unitT) {
        if ('1' == unitT) {
            return '个';
        } else if ('2' == unitT) {
            return '包';
        }else if ('3' == unitT) {
            return '袋';
        }else if ('4' == unitT) {
            return '台';
        }else if ('5' == unitT) {
            return '箱';
        }else if ('6' == unitT) {
            return '条';
        }else if ('7' == unitT) {
            return '只';
        }else if ('8' == unitT) {
            return '瓶';
        }else if ('9' == unitT) {
            return '床';
        }
    }
    function addBtn() {
        var index = layer.open({
            title: "添加设备",
            type: 1, //page层
            area: ['340px', '400px'],
            shade: 0.6, //遮罩透明度
            closeBtn: 1,
            shift: 0, //0-6的动画形式，-1不开启
            content: $('#infoForm'),
            btn: ['确定', '取消'],
            yes: function () {
                $.post("/device/add",{
                    deviceNo : $('#deviceNoF').val(),
                    deviceName : $('#deviceNameF').val(),
                    unit : $('#unitF').val(),
                    deviceType : $('#deviceTypeF').val(),
                    isMeasurement : $('#isMeasurementF').val(),
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
        $.post("/device/getDevice",{
            id : id
        },function (result) {
            var res = JSON.parse(result);
            console.log(res);
            if (res.code == 1) {
                var data = res.data;
                $('#deviceNoF').val(data.deviceNo),
                $('#deviceNameF').val(data.deviceName),
                $('#unitF').val(data.unit),
                $('#deviceTypeF').val(data.deviceType),
                $('#isMeasurementF').val(data.isMeasurement),
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
                $.post("/device/edit",{
                    id : id,
                    deviceNo : $('#deviceNoF').val(),
                    deviceName : $('#deviceNameF').val(),
                    unit : $('#unitF').val(),
                    deviceType : $('#deviceTypeF').val(),
                    isMeasurement : $('#isMeasurementF').val(),
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
            $.post("/device/del",{
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
