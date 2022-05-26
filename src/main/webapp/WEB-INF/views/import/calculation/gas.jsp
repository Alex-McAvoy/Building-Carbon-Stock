<%--
  Created by IntelliJ IDEA.
  User: Alex McAvoy
  Date: 2022/5/19
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.user.bean.User" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>天然气能耗与碳排放</title>

    <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
    <%
        User user = (User) session.getAttribute("user");
        int authority = user.getAuthority();
        pageContext.setAttribute("authority", authority);
    %>
    <script type="text/javascript">
        var APP_PATH = '<%=request.getContextPath()%>';
        var USER = eval("(" + "<%=session.getAttribute("user")%>" + ")");
    </script>

    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8/layui.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8/css/layui.css">

    <!-- 自定义js -->
    <!-- 管理员 -->
    <c:if test="${authority == 1}">
        <script type="text/javascript" src="${APP_PATH}/static/general/js/form-verification.js"></script>
        <script type="text/javascript" src="${APP_PATH}/static/import/calculation/gas/js/edit.js"></script>
        <script type="text/javascript" src="${APP_PATH}/static/import/calculation/gas/js/updateModal.js"></script>
        <script type="text/javascript" src="${APP_PATH}/static/import/calculation/gas/js/delete.js"></script>
    </c:if>
    <!-- 通用 -->
    <script type="text/javascript" src="${APP_PATH}/static/general/js/utils.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/import/calculation/gas/js/consumption-emission.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/import/calculation/gas/js/visualization.js"></script>

    <!-- 自定义css -->
    <link rel="stylesheet" href="${APP_PATH}/static/general/css/import-page.css">

</head>
<body>
<!-- 编辑模态框（管理员） -->
<c:if test="${authority == 1}">
    <div id="editModel" style="display: none;">
        <br>
        <form class="layui-form" action="" id="gasConsumptionForm">
            <input type="hidden" name="id"/>
            <input type="hidden" name="createdTime"/>

            <div class="layui-form-item">
                <label class="layui-form-label">天然气消耗量：</label>
                <div class="layui-input-inline">
                    <input type="text" name="q" required lay-verify="required|isPosFloat"
                           placeholder="请输入天然气消耗量"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">m3</div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block form-button">
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    <button class="layui-btn" lay-submit lay-filter="gasConsumptionForm">提交</button>
                </div>
            </div>
        </form>
    </div>
</c:if>

<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <!-- 标签页 -->
    <ul class="layui-tab-title">
        <!-- 管理员 -->
        <c:if test="${authority == 1}">
            <li id="edit" class="layui-this">数据编辑</li>
            <li id="consumption-emission">柴油能耗与碳排放</li>
            <li>可视化</li>
        </c:if>
        <!-- 普通用户 -->
        <c:if test="${authority == 0}">
            <li id="consumption-emission" class="layui-this">柴油能耗与碳排放</li>
            <li>可视化</li>
        </c:if>
    </ul>
    <!-- 标签页主体 -->
    <div class="layui-tab-content">
        <!-- 数据编辑（管理员） -->
        <c:if test="${authority == 1}">
            <div class="layui-tab-item layui-show">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <table id="editGasTable" class="layui-table">
                            <thead>
                            <tr>
                                <th>id</th>
                                <th>天然气消耗量</th>
                                <th>日期</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <!-- 动态生成表格 -->
                            <tbody id="editGasTableTbody">
                            </tbody>
                        </table>
                        <!-- 分页条 -->
                        <div class="tablePage">
                            <div id="editGasTablePage"></div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <!-- 能耗与碳排放 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <div class="layui-card-body">
                    <table id="displayGasTable" class="layui-table">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>天然气转换能耗</th>
                            <th>天然气转换碳排放</th>
                            <th>日期</th>
                        </tr>
                        </thead>
                        <!-- 动态生成表格 -->
                        <tbody id="displayGasTableTbody">
                        </tbody>
                    </table>
                    <!-- 分页条 -->
                    <div class="tablePage">
                        <div id="displayGasTablePage"></div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 可视化 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <div class="layui-card-header">可视化</div>
                <div class="layui-card-body">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
