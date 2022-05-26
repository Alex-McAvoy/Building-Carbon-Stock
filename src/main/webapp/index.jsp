<%--
  Created by IntelliJ IDEA.
  User: Alex McAvoy
  Date: 2022/5/13
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>

    <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
    <script type="text/javascript">
        var APP_PATH='<%=request.getContextPath()%>';
    </script>

    <script type="text/javascript" src="${APP_PATH}/static/frame/jquery-3.4.1.min.js"></script>

    <!-- 自定义js -->
    <script type="text/javascript" src="${APP_PATH}/static/login/js/init.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/login/js/verification-code.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/login/js/login-verification.js"></script>

    <!-- 自定义css -->
    <link rel="stylesheet" href="${APP_PATH}/static/login/css/restyle.css"/>
    <link rel="stylesheet" href="${APP_PATH}/static/login/css/main.css"/>
    <link rel="stylesheet" href="${APP_PATH}/static/login/css/form.css"/>
    <link rel="stylesheet" href="${APP_PATH}/static/login/css/button.css"/>
    <link rel="stylesheet" href="${APP_PATH}/static/login/css/code.css"/>

</head>
<body>
<div class="login-container">
    <div class="login-picture">
    </div>
    <div class="from-container">
        <from>
            <div class="form-title"><span>智慧楼宇碳监测系统</span></div>
            <div class="input-container">
                <input type="text" id="user" placeholder="用户名">
                <span class="input-span" id="input-user"></span>
                <input type="password" id="password" placeholder="密码">
                <span class="input-span" id="input-password"></span>
                <input type="text" id="code" placeholder="验证码">
                <span class="input-span" id="input-code"></span>

                <div class="code-box">
                    <div id="checkCode" class="code"  onclick="createCode(4)" ></div>
                    <span class="code-span" onclick="createCode(4)">看不清?换一张</span>
                </div>
            </div>
            <div class="btn-container">
                <button class="btn" onclick="login()">提交
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </button>
            </div>

            <div class="message-container" id="mouse">
                <span>忘记密码？</span><br/>
                <span id="forget-password"></span>
            </div>

        </from>
    </div>
</div>
</body>
</html>
