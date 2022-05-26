//获取电力能耗表单页的区域 select 的内容
layui.use("jquery", function () {
    var $ = layui.jquery;

    //页面打开时异步加载数据,查询区域
    $(function () {
        $.ajax({
            type: "GET",
            url: APP_PATH + "/grid-factor/getGridEmissionFactor",
            success: function (result) {
                var gridEmissionFactor = result.extend.gridEmissionFactor;
                $.each(gridEmissionFactor, function (key, value) {
                    $("#areaId").append(new Option(value.gridName, value.areaId));
                });
                layui.form.render("select");
            }, error: function () {
                layer.alert("获取区域失败，请检查数据库");
            }
        })
    });
});