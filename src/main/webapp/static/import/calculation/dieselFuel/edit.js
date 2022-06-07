//数据编辑页

//获取数据编辑页分页数据
$(function () {
    getEditDieselFuelConsumption(1);
    $("#edit").click(function () {
        getEditDieselFuelConsumption(1);
    });
});


//ajax获取数据编辑分页数据
function getEditDieselFuelConsumption(pn) {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/dieselFuel-consumption/getDieselFuelConsumption",
        data: "pn=" + pn,
        success: function (result) {
            showEditDieselFuelTable(result.extend.pageInfo);
        }
    });
}

//生成数据编辑表格
function showEditDieselFuelTable(pageInfo) {
    var total = pageInfo.total; //数据总数
    var pageNum = pageInfo.pageNum; //页号
    var pageSize = pageInfo.pageSize; //页大小
    var data = pageInfo.list; //分页数据


    $("#editDieselFuelTableTbody").html(""); //清空tbody的数据
    for (var i = 0; i < data.length; i++) { //生成表格
        var editButton = "<a href=javascript:void(0) id='editButton-" + data[i].id + "' title='点击修改' onclick='editDieselFuel(" + data[i].id + ")'><i class='layui-icon'>&#xe642;</i></a>";
        var delButton = "<a href=javascript:void(0) id='delButton-" + data[i].id + "' title='点击删除' onclick='delDieselFuel(" + data[i].id + ")'><i class='layui-icon'>&#xe640;</i></a>";

        $("#editDieselFuelTableTbody").append(
            "<tr>" +
            "<td id='id-" + data[i].id + "'>" + data[i].id + "</td>" +
            "<td id='yDiesel-" + data[i].id + "'>" + getThreeBit(data[i].ydiesel) + "</td>" +
            "<td id='createdTime-" + data[i].id + "'>" + parseCreatedTime(data[i].createdTime) + "</td>" +
            "<td>" + editButton + "/" + delButton + "</td>" +
            "</tr>"
        );
    }

    editDieselFuelTablePage(total, pageNum, pageSize); //开启分页组件
}

//启用数据编辑表格 layui 分页
function editDieselFuelTablePage(total, pageNum, pageSize) {
    layui.use(["laypage", "jquery"], function () {
        var laypage = layui.laypage;
        var $ = layui.jquery;

        laypage.render({
            elem: "editDieselFuelTablePage", //id，不用加 #
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
                    getEditDieselFuelConsumption(obj.curr); //执行查询分页函数
                }
            }
        });
    });
}
