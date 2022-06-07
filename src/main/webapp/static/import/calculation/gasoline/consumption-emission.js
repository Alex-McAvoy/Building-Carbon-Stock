//能耗与碳排放页


//获取数据展示页分页数据
$(function () {
    if (USER.authority == 0) {
        getDisplayGasolineConsumption(1);
        $("#consumption-emission").trigger("click");
    }
    $("#consumption-emission").click(function () {
        getDisplayGasolineConsumption(1);
    });
});

//ajax获取数据展示分页数据
function getDisplayGasolineConsumption(pn) {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/gasoline-consumption/getGasolineConsumption",
        data: "pn=" + pn,
        success: function (result) {
            showDisplayGasolineTable(result.extend.pageInfo);
        }
    });
}

//生成数据展示表格
function showDisplayGasolineTable(pageInfo) {
    var total = pageInfo.total; //数据总数
    var pageNum = pageInfo.pageNum; //页号
    var pageSize = pageInfo.pageSize; //页大小
    var data = pageInfo.list; //分页数据

    $("#displayGasolineTableTbody").html(""); //清空tbody的数据
    for (var i = 0; i < data.length; i++) { //生成表格
        $("#displayGasolineTableTbody").append(
            "<tr>" +
            "<td id='id-" + data[i].id + "'>" + data[i].id + "</td>" +
            "<td id='wGasoline-" + data[i].id + "'>" + getFiveBit(data[i].wgasoline) + "</td>" +
            "<td id='tGasoline-" + data[i].id + "'>" + getFiveBit(data[i].tgasoline) + "</td>" +
            "<td id='createdTime-" + data[i].id + "'>" + parseCreatedTime(data[i].createdTime) + "</td>" +
            "</tr>"
        );
    }
    displayGasolineTablePage(total, pageNum, pageSize); //开启分页组件
}

//启用数据展示表格 layui 分页
function displayGasolineTablePage(total, pageNum, pageSize) {
    layui.use(["laypage", "jquery"], function () {
        var laypage = layui.laypage;
        var $ = layui.jquery;

        laypage.render({
            elem: "displayGasolineTablePage", //id，不用加 #
            count: total, //数据总数
            limit: pageSize,//每页显示的条数
            curr: pageNum,//当前页号
            first: "首页",
            last: "末页",
            layout: ["prev", "page", "next", "skip", "count"], //显示分页组件
            jump: function (obj, first) { //点击页号时
                $("[name='pageNum']").val(obj.curr); //向隐藏域设置当前页的值
                $("[name='pageSize']").val(obj.limit); //向隐藏域设置当前页的大小
                if (!first) { //首次不执行，点击时才执行
                    getDisplayGasolineConsumption(obj.curr); //执行查询分页函数
                }
            }
        });
    });
}