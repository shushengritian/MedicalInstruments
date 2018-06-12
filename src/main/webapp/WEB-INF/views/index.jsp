<%
    //String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
            request.getServerPort()+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>器械管理后台</title>
    <link rel="stylesheet" href="<%=basePath%>/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/css/hp-layui.css" />
    <link rel="shortcut icon" href="favicon.ico" />
</head>

<body class="layui-layout-body hp-white-theme">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            我们的征途是星辰大海
        </div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item level-nav">
                <a href="#">主页</a>
            </li>
            <li class="layui-nav-item level-nav">
                <a href="#">厂商管理</a>
            </li>
            <li class="layui-nav-item level-nav">
                <a href="#">库存管理</a>
            </li>
            <li class="layui-nav-item level-nav">
                <a href="#">科室耗材管理</a>
            </li>
            <li class="layui-nav-item level-nav">
                <a href="#">基础设置</a>
            </li>
            <%--<li class="layui-nav-item level-nav">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="#">邮件管理</a>
                    </dd>
                    <dd>
                        <a href="#">消息管理</a>
                    </dd>
                    <dd>
                        <a href="#">授权管理</a>
                    </dd>
                </dl>
            </li>--%>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"><i class="layui-icon"></i>主题<span class="layui-nav-more"></span></a>
                <dl class="layui-nav-child layui-anim layui-anim-upbit">
                    <dd>
                        <a skin="hp-black-theme" class="hp-theme-skin-switch" href="javascript:;">低调黑</a>
                    </dd>
                    <dd>
                        <a skin="hp-blue-theme" class="hp-theme-skin-switch" href="javascript:;">炫酷蓝</a>
                    </dd>
                    <dd>
                        <a skin="hp-green-theme" class="hp-theme-skin-switch" href="javascript:;">原谅绿</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="/login.jsp">退出</a>
            </li>
        </ul>
    </div>

    <div class="layui-side hp-left-menu">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav hp-nav-none">
                <li class="layui-nav-item">
                    <a href="javascript:;" class="hp-user-name">
                        <img src="<%=basePath%>/images/panda.png" class="layui-circle-img"><span class="hp-kd">西游却东行</span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="">基本资料</a>
                        </dd>
                        <dd>
                            <a href="">安全设置</a>
                        </dd>
                    </dl>
                </li>
            </ul>

            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="/home/dataDictionary" href="javascript:;">数据字典</a>
                </li>
            </ul>
            <ul class="layui-nav layui-nav-tree" style="display: none" lay-filter="test">
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="/vendor/vendor" href="javascript:;">材料厂商维护</a>
                </li>
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="/contract/contract" href="javascript:;">合同管理</a>
                </li>
            </ul>
            <ul class="layui-nav layui-nav-tree" style="display: none" lay-filter="test">
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="/stock/storage" href="javascript:;">器材入库</a>
                </li>
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="/stock/outStock" href="javascript:;">器材出库</a>
                </li>
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="/stock/accessStock" href="javascript:;">器材出入库明细</a>
                </li>
            </ul>
            <ul class="layui-nav layui-nav-tree" style="display: none" lay-filter="test">
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="" href="javascript:;">科室领用</a>
                </li>
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="" href="javascript:;">科室退库</a>
                </li>
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="" href="javascript:;">科室库存管理</a>
                </li>
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="" href="javascript:;">领用记录</a>
                </li>
            </ul>
            <ul class="layui-nav layui-nav-tree" style="display: none" lay-filter="test">
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="/department/department" href="javascript:;">科室管理</a>
                </li>
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="/device/device" href="javascript:;">设备维护</a>
                </li>
                <li class="layui-nav-item">
                    <a class="hp-tab-add" hp-href="/supplies/supplies" href="javascript:;">耗材维护</a>
                </li>
            </ul>

        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-tab hp-tab " style="" lay-filter="hp-tab-filter" lay-allowclose="true">
            <ul class="layui-tab-title" style="">
                <li class="layui-this" lay-id="0">首页</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <div class="layui-carousel" id="test1">
                        <div carousel-item>
                            <div>
                                <img height="620px" width="100%" src="<%=basePath%>/images/home/500002394.jpg">
                            </div>
                            <div>
                                <img height="620px" width="100%" src="<%=basePath%>/images/home/500827659.jpg">
                            </div>
                            <div>
                                <img height="620px" width="100%" src="<%=basePath%>/images/home/500313310.jpg">
                            </div>
                            <div>
                                <img height="620px" width="100%" src="<%=basePath%>/images/home/500737554.jpg">
                            </div>
                            <div>
                                <img height="620px" width="100%" src="<%=basePath%>/images/home/500859132.jpg">
                            </div>
                        </div>
                    </div>
                    <!-- 源码地址 -->
                   <%-- <div style="margin-top: 10px;">
                        <blockquote class="layui-elem-quote">
                            源码地址：<br/><br/>
                            <a target="_blank" href="https://github.com/shushengritian"><button class="layui-btn layui-btn-danger  layui-btn-sm">github</button></a>
                        </blockquote>
                        <blockquote class="layui-elem-quote">
                            <h2>我们的征途是星辰大海</h2>
                            <br/>
                            <b>qq群: 783549656</b>
                        </blockquote>

                    </div>--%>

                </div>
            </div>

        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © Medical-Instruments-version-1.0
    </div>
</div>
<script src="<%=basePath%>/layui/layui.js"></script>
<script>
    // 配置
    layui.config({
        base: '<%=basePath%>/static/js/fhModules/' // 扩展模块目录
    }).extend({ // 模块别名
        fhTab: 'fhComponent/fhTab',
        fhRightMenu: 'fhComponent/fhRightMenu',
        fhFormAll: 'fhComponent/fhFormAll',
        fhLayedit: 'fhComponent/fhLayedit',
        fhTheme: 'fhComponent/fhTheme',
        //test: '{/}./other/test' // {/}的意思即代表采用自有路径，即不跟随 base 路径
    });

    //JavaScript代码区域
    layui.use(['element', 'carousel', 'fhTheme', 'fhTab', 'fhLayedit', 'fhRightMenu'], function() {

        var element = layui.element;
        var carousel = layui.carousel; //轮播
        var fhTab = layui.fhTab;
        var fhRightMenu = layui.fhRightMenu;
        var fhTheme = layui.fhTheme;
        $ = layui.jquery;
        /*var test=layui.test;
        console.log(test.version) */
        // 初始化主题
        fhTheme.init();
        //初始化轮播
        carousel.render({
            elem: '#test1',
            width: '100%', //设置容器宽度
            interval: 1500,
            height: '500px',
            arrow: 'none', //不显示箭头
            anim: 'fade', //切换动画方式
        });

        // 初始化 动态tab
        fhTab.init();
        // 右键tab菜单
        fhRightMenu.init();

        element.on('nav(alert111)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });

        $(".level-nav").click(function () {
            var index = $(".level-nav").index($(this));
            $(".layui-nav-tree").hide();
            $(".layui-nav-tree").eq(index).show();
        });



    });
</script>
</body>

</html>