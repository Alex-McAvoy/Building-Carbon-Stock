//能耗与碳排放页

//获取数据展示页分页数据
$(function () {
    if (USER.authority == 0) {
        getDisplayElectricityConsumption(1);
        $("#consumption-emission").trigger("click");
    }
    $("#consumption-emission").click(function () {
        getDisplayElectricityConsumption(1);
    });
});

//ajax获取数据展示分页数据
function getDisplayElectricityConsumption(pn) {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/electricity-consumption/getElectricityConsumption",
        data: "pn=" + pn,
        success: function (result) {
            showDisplayElectricityTable(result.extend.pageInfo);
        }
    });
}

//生成数据展示表格
function showDisplayElectricityTable(pageInfo) {
    var total = pageInfo.total; //数据总数
    var pageNum = pageInfo.pageNum; //页号
    var pageSize = pageInfo.pageSize; //页大小
    var data = pageInfo.list; //分页数据

    $("#displayElectricityTableTbody").html(""); //清空tbody的数据
    for (var i = 0; i < data.length; i++) { //生成表格
        $("#displayElectricityTableTbody").append(
            "<tr>" +
            "<td id='id-" + data[i].id + "'>" + data[i].id + "</td>" +
            "<td id='wN-" + data[i].id + "'>" + getFiveBit(data[i].wn) + "</td>" +
            "<td id='wR-" + data[i].id + "'>" + getFiveBit(data[i].wr) + "</td>" +
            "<td id='wW-" + data[i].id + "'>" + getFiveBit(data[i].ww) + "</td>" +
            "<td id='wE-" + data[i].id + "'>" + getFiveBit(data[i].we) + "</td>" +
            "<td id='d-" + data[i].id + "'>" + getThreeBit(data[i].d) + "</td>" +
            "<td id='wElectricity-" + data[i].id + "'>" + getFiveBit(data[i].welectricity) + "</td>" +
            "<td id='areaId-" + data[i].gridEmissionFactor.areaId + "'>" + data[i].gridEmissionFactor.gridName + "</td>" +
            "<td id='tGrid-" + data[i].id + "'>" + getFiveBit(data[i].tgrid) + "</td>" +
            "<td id='createdTime-" + data[i].id + "'>" + parseCreatedTime(data[i].createdTime) + "</td>" +
            "</tr>"
        );
    }
    displayElectricityTablePage(total, pageNum, pageSize); //开启分页组件
}

//启用数据展示表格 layui 分页
function displayElectricityTablePage(total, pageNum, pageSize) {
    layui.use(["laypage", "jquery"], function () {
        var laypage = layui.laypage;
        var $ = layui.jquery;
        laypage.render({
            elem: "displayElectricityTablePage", //id，不用加 #
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
                    getDisplayElectricityConsumption(obj.curr); //执行查询分页函数
                }
            }
        });
    });
}