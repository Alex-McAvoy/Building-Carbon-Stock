//表单验证

//表单正浮点数校验
layui.use("form", function () {
    var form = layui.form;

    form.verify({
        isPosFloat: [
            /^\d+(\.\d+)?$/,
            "输入必须为非负浮点数"
        ]
    });
});

//日期输入表单
layui.use("laydate", function () {
    var laydate = layui.laydate;

    laydate.render({ //创建时间选择框
        elem: ".createdTimeBox" //指定元素
    });
});