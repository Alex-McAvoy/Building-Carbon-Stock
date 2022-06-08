<%--
  Created by IntelliJ IDEA.
  User: Alex McAvoy
  Date: 2022/5/18
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.user.bean.User" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>智慧楼宇碳检测系统</title>

    <%pageContext.setAttribute("APP_PATH", request.getContextPath());%>
    <%
        User user = (User) session.getAttribute("user");
        int authority = user.getAuthority();
        pageContext.setAttribute("authority", authority);
    %>
    <script type="text/javascript">
        var APP_PATH = "<%=request.getContextPath()%>";
        var USER = eval("(" + "<%=session.getAttribute("user")%>" + ")");
    </script>

    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8/layui.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8/css/layui.css">

    <!-- 自定义js -->
    <script type="text/javascript" src="${APP_PATH}/static/manage/js/account.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/manage/js/importPage.js"></script>

    <!-- 自定义css -->
    <link rel="stylesheet" href="${APP_PATH}/static/manage/css/main.css">
</head>
<body>


<div class="layui-layout layui-layout-admin">


    <!-- 头部 -->
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs">
            <span>智慧楼宇碳监测系统</span>
        </div>

        <!-- 登录 -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
                         class="layui-nav-img">
                    <span id="username"></span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:exit();">登出</a></dd>
                </dl>
            </li>
        </ul>
    </div>


    <!-- 左侧导航栏 -->
    <div class="layui-side">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <!-- 数据导入，仅管理员可用 -->
                <c:if test="${authority == 1}">
                    <li class="layui-nav-item">
                        <a href="javascript: importDataInput();">
                            <span>数据导入</span>
                        </a>
                    </li>
                </c:if>

                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <span>数据分析</span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:importElectricity();">
                            <span>电力能耗与碳排放计算</span>
                        </a></dd>
                        <dd><a href="javascript:importGas();">
                            <span>天然气能耗与碳排放计算</span>
                        </a></dd>
                        <dd><a href="javascript:importGasoline();">
                            <span>汽油能耗与碳排放计算</span>
                        </a></dd>
                        <dd><a href="javascript:importDieselFuel();">
                            <span>柴油能耗与碳排放计算</span>
                        </a></dd>
                        <dd><a href="javascript:importSteam();">
                            <span>蒸汽能耗与碳排放计算</span>
                        </a></dd>
                        <dd><a href="javascript:importHeatingCooling();">
                            <span>供热供冷能耗与碳排放计算</span>
                        </a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:importFactorShow();">
                    <span>排放因子库</span>
                </a></li>
            </ul>
        </div>
    </div>

    <!-- 内容主体区域 -->
    <div class="layui-body" id="content">
        <div>
            <h1>欢迎使用智慧楼宇碳检测系统</h1>
        </div>
    </div>

    <!-- 底部固定区域 -->
    <div class="layui-footer">
        <span>智慧楼宇碳检测系统 v1.0 @Author: Alex_McAvoy </span>
    </div>

</div>
<script>
    layui.use(['element', 'layer', 'util'], function () {
        var element = layui.element
            , layer = layui.layer
            , util = layui.util
            , $ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function (othis) {
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
        });
    });
</script>
</body>
</html>
