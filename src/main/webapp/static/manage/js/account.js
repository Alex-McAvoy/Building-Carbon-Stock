//用户验证
$(function () {
    if (USER == null)
        window.location.href = APP_PATH + "/index.jsp";
    $("#username").text(USER.username);
});

//用户登出
function exit() {
    layui.use(["layer", "jquery"], function () {
        layer.confirm("确认登出账户？", function () {
            $.ajax({
                type: "GET",
                url: APP_PATH + "/exit",
                success: function (result) {
                    window.location.href = APP_PATH + "/index.jsp";
                }
            });
        })
    });
}
