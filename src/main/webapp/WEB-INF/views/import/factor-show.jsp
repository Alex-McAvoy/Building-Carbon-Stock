<%--
  Created by IntelliJ IDEA.
  User: Alex McAvoy
  Date: 2022/5/23
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>因子库</title>

    <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
    <script type="text/javascript">
        var APP_PATH = '<%=request.getContextPath()%>';
    </script>

    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8/layui.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/echarts-5.3.2.min.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8/css/layui.css">

    <!-- 自定义css -->
    <link rel="stylesheet" href="${APP_PATH}/static/general/css/import-page.css">

    <!-- 自定义js -->
    <script type="text/javascript" src="${APP_PATH}/static/import/factor/grid.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/import/factor/energy.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/import/factor/carbon.js"></script>

</head>
<body>

<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">

    <ul class="layui-tab-title">
        <li id="energy" class="layui-this">各种能源折标准煤参考系数</li>
        <li id="carbon">各种能源折碳排放因子</li>
        <li id="grid">中国区域电网基准线排放因子</li>
    </ul>
    <div class="layui-tab-content">
        <!-- 各种能源折标准煤参考系数 -->
        <div class="layui-tab-item layui-show">
            <div class="layui-card">
                <%--                <div class="layui-card-header">能耗与碳排放</div>--%>
                <div class="layui-card-body">
                    <table id="energyTable" class="layui-table">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>能源</th>
                            <th>平均低位发热量</th>
                            <th>折标准煤系数</th>
                        </tr>
                        </thead>
                        <!-- 动态生成表格 -->
                        <tbody id="energyTableTbody">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- 各种能源折碳排放因子 -->
        <div class="layui-tab-item ">
            <div class="layui-card">
                <%--                <div class="layui-card-header">数据编辑</div>--%>
                <div class="layui-card-body">
                    <table id="carbonTable" class="layui-table">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>能源</th>
                            <th>单位热值碳含量（吨碳/TJ）</th>
                            <th>碳氧化率</th>
                            <th>CO<sub>2</sub> 排放系数（kgCO<sub>2</sub>/kg）</th>
                        </tr>
                        </thead>
                        <!-- 动态生成表格 -->
                        <tbody id="carbonTableTbody">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- 中国区域电网基准线排放因子 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <%--                <div class="layui-card-header">数据编辑</div>--%>
                <div class="layui-card-body">
                    <table id="gridTable" class="layui-table">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>区域</th>
                            <th>OM（tCO<sub>2</sub>/MWh）</th>
                            <th>BM（tCO<sub>2</sub>/MWh）</th>
                        </tr>
                        </thead>
                        <!-- 动态生成表格 -->
                        <tbody id="gridTableTbody">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
