<%--
  Created by IntelliJ IDEA.
  User: Alex McAvoy
  Date: 2022/5/19
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据导入</title>

    <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
    <script type="text/javascript">
        var APP_PATH = '<%=request.getContextPath()%>';
    </script>

    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/frame/layui-2.6.8/layui.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/frame/layui-2.6.8/css/layui.css">

    <!-- 自定义js -->
    <script type="text/javascript" src="${APP_PATH}/static/import/data-input/js/form.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/import/data-input/js/get-grid.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/general/js/form-verification.js"></script>
    <!-- 自定义css -->
    <link rel="stylesheet" href="${APP_PATH}/static/import/data-input/css/data-input.css">

</head>
<body>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
    <ul class="layui-tab-title">
        <li class="layui-this">电力能耗</li>
        <li>天然气能耗</li>
        <li>汽油能耗</li>
        <li>柴油能耗</li>
        <li>蒸汽能耗</li>
        <li>供热供冷能耗</li>
    </ul>
    <div class="layui-tab-content">
        <!-- 电力能耗 -->
        <div class="layui-tab-item layui-show">
            <div class="layui-card">
                <div class="layui-card-header">用电量与发电量</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="" id="electricityConsumptionForm">
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
                            <label class="layui-form-label">日期：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="createdTime" required
                                       lay-verify="required" placeholder="请输入日期"
                                       class="layui-input createdTimeBox">
                            </div>
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
            </div>
        </div>

        <!-- 天然气能耗 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <div class="layui-card-header">天然气消耗量</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="" id="gasConsumptionForm">
                        <div class="layui-form-item">
                            <label class="layui-form-label">天然气消耗量：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="q" required lay-verify="required|isPosFloat"
                                       placeholder="请输入天然气消耗量"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">m<sup>3</sup></div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">日期：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="createdTime" required
                                       lay-verify="required" placeholder="请输入日期"
                                       class="layui-input createdTimeBox">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block form-button">
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                <button class="layui-btn" lay-submit lay-filter="gasConsumptionForm">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- 汽油能耗 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <div class="layui-card-header">汽油消耗量</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="" id="gasolineConsumptionForm">
                        <div class="layui-form-item">
                            <label class="layui-form-label">汽油消耗量：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="yGasoline" required lay-verify="required|isPosFloat"
                                       placeholder="请输入汽油消耗量"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">kg</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">日期：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="createdTime" required
                                       lay-verify="required" placeholder="请输入日期"
                                       class="layui-input createdTimeBox">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block form-button">
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                <button class="layui-btn" lay-submit lay-filter="gasolineConsumptionForm">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- 柴油能耗 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <div class="layui-card-header">柴油消耗量</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="" id="dieselFuelConsumptionForm">
                        <div class="layui-form-item">
                            <label class="layui-form-label">柴油消耗量：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="yDiesel" required lay-verify="required|isPosFloat"
                                       placeholder="请输入柴油消耗量"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">kg</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">日期：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="createdTime" required
                                       lay-verify="required" placeholder="请输入日期"
                                       class="layui-input createdTimeBox">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block form-button">
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                <button class="layui-btn" lay-submit lay-filter="dieselFuelConsumptionForm">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- 蒸汽能耗 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <div class="layui-card-header">蒸汽消耗量</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="" id="steamConsumptionForm">
                        <div class="layui-form-item">
                            <label class="layui-form-label">蒸汽消耗量：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="z" required lay-verify="required|isPosFloat"
                                       placeholder="请输入蒸汽消耗量"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">MJ</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">日期：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="createdTime" required
                                       lay-verify="required" placeholder="请输入日期"
                                       class="layui-input createdTimeBox">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block form-button">
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                <button class="layui-btn" lay-submit lay-filter="steamConsumptionForm">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- 供热供冷能耗 -->
        <div class="layui-tab-item">
            <div class="layui-card">
                <div class="layui-card-header">热量/冷量</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="" id="heatConsumptionForm">
                        <div class="layui-form-item">
                            <label class="layui-form-label">热量/冷量消耗量：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="r" required lay-verify="required|isPosFloat"
                                       placeholder="请输入热量/冷量消耗量"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">MJ</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">日期：</label>
                            <div class="layui-input-inline">
                                <input type="text" name="createdTime" required
                                       lay-verify="required" placeholder="请输入日期"
                                       class="layui-input createdTimeBox">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block form-button">
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                <button class="layui-btn" lay-submit lay-filter="heatConsumptionForm">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
