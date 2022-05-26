//修改数据模态框
function editElectricity(id, areaId) {
    //开启模态框
    layui.use(["layer", "jquery"], function () {
        var layer = layui.layer;
        var $ = layui.jquery;

        //向模态框中赋值
        $("[name='id']").val(id);
        $("[name='dN']").val($("#dN-" + id).text());
        $("[name='dR']").val($("#dR-" + id).text());
        $("[name='dW']").val($("#dW-" + id).text());
        $("[name='dE']").val($("#dE-" + id).text());
        $("[name='e']").val($("#e-" + id).text());
        selectArea(areaId);
        $("[name='createdTime']").val($("#createdTime-" + id).text());

        layer.open({
            type: 1, //类型
            area: ["600px", "500px"],//定义宽高
            title: "编辑（id：" + id + "）",
            shadeClose: false,//点击遮罩层关闭
            content: $('#editModel')//打开的内容
        });
    });

    //获取电力能耗表单页的区域 select 的内容，并在模态框中赋值
    function selectArea(areaId) {
        $("#areaId").empty();
        //模态框打开时异步加载数据,查询区域
        $.ajax({
            type: "GET",
            url: APP_PATH + "/grid-factor/getGridEmissionFactor",
            success: function (result) {
                var gridEmissionFactor = result.extend.gridEmissionFactor;
                $.each(gridEmissionFactor, function (key, value) {
                    $("#areaId").append(new Option(value.gridName, value.areaId));
                });
                $.each(gridEmissionFactor, function (key, value) {
                    if (areaId == value.areaId)
                        $("#areaId").find("option[value=" + areaId + "]").attr("selected", true);
                });
                layui.form.render("select");
            }, error: function () {
                layer.alert("获取区域失败，请检查数据库");
            }
        });
    }

    //模态框表单提交
    layui.use(["form", "layer", "jquery"], function () {
        var form = layui.form;
        var layer = layui.layer;
        var $ = layui.jquery;

        form.on("submit(electricityConsumptionForm)", function (data) {
            $.ajax({
                type: "PUT",
                url: APP_PATH + "/electricity-consumption/updateElectricityConsumption",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify(data.field),
                success: function (result) {
                    layer.close(layer.index);
                    layer.alert(result.extend.message);
                    var pageNum = $("#editElectricityTablePage .layui-laypage-curr em").text(); //当前页页码
                    getEditElectricityConsumption(pageNum);
                }, error: function () {
                    layer.alert("提交失败，请重试");
                }
            });
            return false;
        });
    });
}
