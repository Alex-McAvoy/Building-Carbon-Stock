//修改数据模态框
function editGasoline(id) {
    //开启模态框
    layui.use(["layer", "jquery"], function () {
        var layer = layui.layer;
        var $ = layui.jquery;

        //向模态框中赋值
        $("[name='id']").val(id);
        $("[name='yGasoline']").val($("#yGasoline-" + id).text());
        $("[name='createdTime']").val($("#createdTime-" + id).text());

        layer.open({
            type: 1, //类型
            area: ["600px", "200px"],//定义宽高
            title: "编辑（id：" + id + "）",
            shadeClose: false,//点击遮罩层关闭
            content: $('#editModel')//打开的内容
        });
    });

    //模态框表单提交
    layui.use(["form", "layer", "jquery"], function () {
        var form = layui.form;
        var layer = layui.layer;
        var $ = layui.jquery;

        form.on("submit(gasolineConsumptionForm)", function (data) {
            $.ajax({
                type: "PUT",
                url: APP_PATH + "/gasoline-consumption/updateGasolineConsumption",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify(data.field),
                success: function (result) {
                    layer.close(layer.index);
                    layer.alert(result.extend.message);
                    var pageNum = $("#editGasolineTablePage .layui-laypage-curr em").text(); //当前页页码
                    getEditGasolineConsumption(pageNum);
                }, error: function () {
                    layer.alert("提交失败，请重试");
                }
            });
            return false;
        });
    });
}
