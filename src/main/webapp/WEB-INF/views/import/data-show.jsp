<%--
  Created by IntelliJ IDEA.
  User: Alex McAvoy
  Date: 2022/5/19
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>整体数据展示</title>

    <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
    <script type="text/javascript">
        var APP_PATH = '<%=request.getContextPath()%>';
    </script>

    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8/layui.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8/css/layui.css">
    <script type="text/javascript" src="${APP_PATH}/static/frame/echarts-5.3.2.min.js"></script>

    <!-- 自定义js -->
    <script type="text/javascript" src="${APP_PATH}/static/general/js/utils.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/import/data-show/proportion.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/import/data-show/consumption.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/import/data-show/emission.js"></script>

    <!-- 自定义css -->
    <link rel="stylesheet" href="${APP_PATH}/static/general/css/import-page.css">
</head>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li id="proportion" class="layui-this">建筑电力碳排放比例分布</li>
        <li id="consumption">各类能耗情况</li>
        <li id="emission">各类碳排放情况</li>
    </ul>
    <div class="layui-tab-content">
        <!-- 建筑电力碳排放比例分布 -->
        <div class="layui-tab-item layui-show">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="layui-colla-content layui-show">
                        <div id="display-chart1" class="visualization-chart"></div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 各类能耗情况 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="layui-colla-content">
                        <div id="display-chart2" class="visualization-chart"></div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 各类碳排放情况 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="layui-colla-content">
                        <div id="display-chart3" class="visualization-chart"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
