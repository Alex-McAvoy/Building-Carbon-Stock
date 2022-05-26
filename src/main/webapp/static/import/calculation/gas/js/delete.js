//删除数据
function delGas(id) {
    layui.use(["layer", "jquery"], function () {
        layer.confirm("确认删除 id 为 " + id + " 的数据吗？", {btn: ["确认", "取消"]}, function () {
            $.ajax({
                type: "DELETE",
                url: APP_PATH + "/gas-consumption/deleteGasConsumption/" + id,
                success: function (result) {
                    layer.alert(result.extend.message);
                    var pageNum = $("#editGasTablePage .layui-laypage-curr em").text(); //当前页页码
                    getEditGasConsumption(pageNum);
                }, error: function () {
                    layer.alert("删除失败，请重试");
                }
            });
        }, function () {
            layer.msg('已取消..');
            return false;
        });
    });
}