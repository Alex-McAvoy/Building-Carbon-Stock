<%--
  Created by IntelliJ IDEA.
  User: Alex McAvoy
  Date: 2022/5/19
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.user.bean.User" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>电力能耗与碳排放计算</title>

    <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
    <%
        User user = (User) session.getAttribute("user");
        Integer authority = user.getAuthority();
        pageContext.setAttribute("authority", authority);
    %>
    <script type="text/javascript">
        var APP_PATH = '<%=request.getContextPath()%>';
        var USER = eval("(" + "<%=session.getAttribute("user")%>" + ")");
    </script>

    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8/layui.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/echarts-5.3.2.min.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8/css/layui.css">

    <!-- 自定义js -->
    <!-- 管理员 -->
    <c:if test="${authority == 1}">
        <script type="text/javascript" src="${APP_PATH}/static/general/js/form-verification.js"></script>
        <script type="text/javascript" src="${APP_PATH}/static/import/calculation/electricity/edit.js"></script>
        <script type="text/javascript"
                src="${APP_PATH}/static/import/calculation/electricity/updateModal.js"></script>
        <script type="text/javascript" src="${APP_PATH}/static/import/calculation/electricity/delete.js"></script>
    </c:if>
    <!-- 通用 -->
    <script type="text/javascript" src="${APP_PATH}/static/general/js/utils.js"></script>
    <script type="text/javascript"
            src="${APP_PATH}/static/import/calculation/electricity/consumption-emission.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/import/calculation/electricity/visualization.js"></script>

    <!-- 自定义css -->
    <link rel="stylesheet" href="${APP_PATH}/static/general/css/import-page.css">

</head>
<body>

<!-- 编辑模态框 -->
<!-- 管理员 -->
<c:if test="${authority == 1}">
    <div id="editModel" style="display: none;">
        <br>
        <form class="layui-form" action="" id="electricityConsumptionForm">
            <input type="hidden" name="id"/>
            <input type="hidden" name="createdTime"/>
            <div class="layui-form-item">
                <label class="layui-form-label">暖通空调系统的用电量：</label>
                <div class="layui-input-inline">
                    <input type="text" name="dN" required lay-verify="required|isPosFloat"
                           placeholder="请输入暖通空调系统的用电量"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">kWh</div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">生活热水系统的用电量：</label>
                <div class="layui-input-inline">
                    <input type="text" name="dR" required lay-verify="required|isPosFloat"
                           placeholder="请输入生活热水系统的用电量"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">kWh</div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">照明系统用电量：</label>
                <div class="layui-input-inline">
                    <input type="text" name="dW" required lay-verify="required|isPosFloat"
                           placeholder="请输入照明系统用电量"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">kWh</div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">其他用能设备用电量：</label>
                <div class="layui-input-inline">
                    <input type="text" name="dE" required lay-verify="required|isPosFloat"
                           placeholder="请输入其他用能设备用电量"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">kWh</div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">光伏发电量：</label>
                <div class="layui-input-inline">
                    <input type="text" name="e" required lay-verify="required|isPosFloat"
                           placeholder="请输入光伏发电量"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">kWh</div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">区域：</label>
                <div class="layui-input-inline">
                    <select name="areaId" id="areaId" lay-verify="required">
                        <option value=""></option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block form-button">
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    <button class="layui-btn" lay-submit lay-filter="electricityConsumptionForm">提交</button>
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
            <li id="edit" class="layui-this"> 数据编辑</li>
            <li id="consumption-emission">电力能耗与碳排放</li>
            <li id="visualization">可视化</li>
        </c:if>
        <!-- 普通用户 -->
        <c:if test="${authority == 0}">
            <li id="consumption-emission" class="layui-this">电力能耗与碳排放</li>
            <li id="visualization">可视化</li>
        </c:if>
    </ul>
    <!-- 标签页主体 -->
    <div class="layui-tab-content">
        <!-- 数据编辑（管理员） -->
        <c:if test="${authority == 1}">
            <div class="layui-tab-item layui-show">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <table id="editElectricityTable" class="layui-table">
                            <thead>
                            <tr>
                                <th> id</th>
                                <th> 暖通空调系统用电量</th>
                                <th> 生活热水系统用电量</th>
                                <th> 照明系统用电量</th>
                                <th> 其他设备用电量</th>
                                <th> 光伏发电量</th>
                                <th> 区域</th>
                                <th> 日期</th>
                                <th> 操作</th>
                            </tr>
                            </thead>
                            <!--动态生成表格-->
                            <tbody id="editElectricityTableTbody">
                            </tbody>
                        </table>
                        <!--分页条-->
                        <div class="tablePage">
                            <div id="editElectricityTablePage"></div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

        <!-- 能耗与碳排放 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <%--                <div class="layui-card-header">能耗与碳排放</div>--%>
                <div class="layui-card-body">
                    <table id="displayElectricityTable" class="layui-table">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>暖通空调能耗</th>
                            <th>生活热水能耗</th>
                            <th>照明系统能耗</th>
                            <th>其他设备能耗</th>
                            <th>总用电量</th>
                            <th>电力转换能耗</th>
                            <th>区域</th>
                            <th>区域电力转换碳排放</th>
                            <th>日期</th>
                        </tr>
                        </thead>
                        <!-- 动态生成表格 -->
                        <tbody id="displayElectricityTableTbody">
                        </tbody>
                    </table>
                    <!-- 分页条 -->
                    <div class="tablePage">
                        <div id="displayElectricityTablePage"></div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 可视化 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <div class="layui-collapse" lay-accordion>
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">各种设备能耗</h2>
                        <div class="layui-colla-content layui-show">
                            <div id="display-chart1" class="visualization-chart"></div>
                        </div>
                    </div>
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">总用电量</h2>
                        <div class="layui-colla-content">
                            <div id="display-chart2" class="visualization-chart"></div>
                        </div>
                    </div>
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">电力转换能耗</h2>
                        <div class="layui-colla-content">
                            <div id="display-chart3" class="visualization-chart"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
