// 验证用户名密码
function login() {
    var user = $("#user").val();
    var password = $("#password").val();
    var code = $("#code").val();
    if (!$("#user").val()) {
        $("#input-user").text("请输入用户名！");
    } else if (!$("#password").val()) {
        $("#input-user").text("");
        $("#input-password").text("请输入密码！");
    } else if (!$("#code").val()) {
        $("#input-user").text("");
        $("#input-password").text("");
        $("#input-code").text("请输入验证码！");
    } else if (!validateCode()) {
        $("#input-user").text("");
        $("#input-password").text("");
        $("#input-code").text("验证码错误！");
    } else {
        $("#input-user").text("");
        $("#input-password").text("");
        $("#input-code").text("");
        $.ajax({
            url: APP_PATH + "/login-verify",
            type: "GET",
            data: {
                "username": user,
                "password": password
            },
            dataType: "json",
            success: function (result) {
                if (result.code == 200) {
                    if (result.extend.message == "userNull")
                        $("#input-user").text("用户名不存在！");
                    else if (result.extend.message == "passwordWrong")
                        $("#input-password").text("密码错误！");
                } else {
                    window.location.href = APP_PATH + "/manage";
                }
                return false;
            },
            error: function () {
                alert("登录失败！");
            }
        });
    }
}

//忘记密码
$(function () {
    $("#mouse").mouseover(function () {
        $("#forget-password").html("<span>请联系网站管理员！</span>");
    });
    $("#mouse").mouseout(function () {
        $("#forget-password").text("");
    });
});