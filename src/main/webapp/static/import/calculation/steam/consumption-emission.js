//能耗与碳排放页

//获取数据展示页分页数据
$(function () {
    if (USER.authority == 0) {
        getDisplaySteamConsumption(1);
        $("#consumption-emission").trigger("click");
    }
    $("#consumption-emission").click(function () {
        getDisplaySteamConsumption(1);
    });
});

//ajax获取数据展示分页数据
function getDisplaySteamConsumption(pn) {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/steam-consumption/getSteamConsumption",
        data: "pn=" + pn,
        success: function (result) {
            showDisplaySteamTable(result.extend.pageInfo);
        }
    });
}

//生成数据展示表格
function showDisplaySteamTable(pageInfo) {
    var total = pageInfo.total; //数据总数
    var pageNum = pageInfo.pageNum; //页号
    var pageSize = pageInfo.pageSize; //页大小
    var data = pageInfo.list; //分页数据

    $("#displaySteamTableTbody").html(""); //清空tbody的数据
    for (var i = 0; i < data.length; i++) { //生成表格
        $("#displaySteamTableTbody").append(
            "<tr>" +
            "<td id='id-" + data[i].id + "'>" + data[i].id + "</td>" +
            "<td id='wSteam-" + data[i].id + "'>" + getFiveBit(data[i].wsteam) + "</td>" +
            "<td id='tSteam-" + data[i].id + "'>" + getFiveBit(data[i].tsteam) + "</td>" +
            "<td id='createdTime-" + data[i].id + "'>" + parseCreatedTime(data[i].createdTime) + "</td>" +
            "</tr>"
        );
    }
    displaySteamTablePage(total, pageNum, pageSize); //开启分页组件
}

//启用数据展示表格 layui 分页
function displaySteamTablePage(total, pageNum, pageSize) {
    layui.use(["laypage", "jquery"], function () {
            var laypage = layui.laypage;
            var $ = layui.jquery;
            laypage.render({
                elem: "displaySteamTablePage", //id，不用加 #
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
                        getDisplaySteamConsumption(obj.curr); //执行查询分页函数
                    }
                }
            });
        }
    );
}
