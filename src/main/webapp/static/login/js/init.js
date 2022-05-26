$(function () {
    // 用户名文本框失去焦点触发验证事件
    $("#user").blur(function () {
        if (!$(this).val())
            $("#input-user").text("请输入用户名！");
        else
            $("#input-user").text("");
    });

    //用户密码框失去焦点触发验证事件
    $("#password").blur(function () {
        if (!$(this).val())
            $("#input-password").text("请输入密码！");
        else
            $("#input-password").text("");
    });

    //验证码框失去焦点触发验证事件
    $("#code").blur(function () {
        if (!$(this).val())
            $("#input-code").text("请输入验证码！");
        else
            $("#input-code").text("");
    });
    createCode(4); //生成验证码
});