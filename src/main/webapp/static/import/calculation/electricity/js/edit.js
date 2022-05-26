//数据编辑页

//启动页面后自动获取数据编辑页分页数据
$(function () {
    getEditElectricityConsumption(1);
    $("#edit").click(function () {
        getDisplayElectricityConsumption(1);
    });
});

//ajax获取数据编辑分页数据
function getEditElectricityConsumption(pn) {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/electricity-consumption/getElectricityConsumption",
        data: "pn=" + pn,
        success: function (result) {
            showEditElectricityTable(result.extend.pageInfo);
        }
    });
}

//生成数据编辑表格
function showEditElectricityTable(pageInfo) {
    var total = pageInfo.total; //数据总数
    var pageNum = pageInfo.pageNum; //页号
    var pageSize = pageInfo.pageSize; //页大小
    var data = pageInfo.list; //分页数据


    $("#editElectricityTableTbody").html(""); //清空tbody的数据
    for (var i = 0; i < data.length; i++) { //生成表格
        var date = new Date(data[i].createdTime);
        var editButton = "<a href=javascript:void(0) id='editButton-" + data[i].id + "' title='点击修改' onclick='editElectricity(" + data[i].id + ", " + data[i].gridEmissionFactor.areaId + ")'><i class='layui-icon'>&#xe642;</i></a>";
        var delButton = "<a href=javascript:void(0) id='delButton-" + data[i].id + "' title='点击删除' onclick='delElectricity(" + data[i].id + ")'><i class='layui-icon'>&#xe640;</i></a>";

        $("#editElectricityTableTbody").append(
            "<tr>" +
            "<td id='id-" + data[i].id + "'>" + data[i].id + "</td>" +
            "<td id='dN-" + data[i].id + "'>" + getThreeBit(data[i].dn) + "</td>" +
            "<td id='dR-" + data[i].id + "'>" + getThreeBit(data[i].dr) + "</td>" +
            "<td id='dW-" + data[i].id + "'>" + getThreeBit(data[i].dw) + "</td>" +
            "<td id='dE-" + data[i].id + "'>" + getThreeBit(data[i].de) + "</td>" +
            "<td id='e-" + data[i].id + "'>" + getThreeBit(data[i].e) + "</td>" +
            "<td id='areaId-" + data[i].gridEmissionFactor.areaId + "'>" + data[i].gridEmissionFactor.gridName + "</td>" +
            "<td id='createdTime-" + data[i].id + "'>" + date.toLocaleDateString().split('/').join('-') + "</td>" +
            "<td>" + editButton + "/" + delButton + "</td>" +
            "</tr>"
        );
    }

    editElectricityTablePage(total, pageNum, pageSize); //开启分页组件
}

//启用数据编辑表格 layui 分页
function editElectricityTablePage(total, pageNum, pageSize) {
    layui.use(["laypage", "jquery"], function () {
        var laypage = layui.laypage;
        var $ = layui.jquery;
        laypage.render({
            elem: "editElectricityTablePage", //id，不用加 #
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
                    getEditElectricityConsumption(obj.curr); //执行查询分页函数
                }
            }
        });

    });
}