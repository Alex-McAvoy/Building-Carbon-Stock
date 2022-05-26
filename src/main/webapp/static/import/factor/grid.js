//区域排放因子页
$(function () {
    $("#grid").click(function () {
        getGridTable();
    });
});

//获取数据
function getGridTable() {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/grid-factor/getGridEmissionFactor",
        success: function (result) {
            showGridTable(result.extend.gridEmissionFactor);
        }
    });
}

//生成表格
function showGridTable(data) {
    $("#gridTableTbody").html(""); //清空tbody的数据
    for (var i = 0; i < data.length; i++) { //生成表格
        $("#gridTableTbody").append(
            "<tr>" +
            "<td id='areaId-" + data[i].areaId + "'>" + data[i].areaId + "</td>" +
            "<td id='gridName-" + data[i].areaId + "'>" + data[i].gridName + "</td>" +
            "<td id='om-" + data[i].areaId + "'>" + data[i].om + "</td>" +
            "<td id='bm-" + data[i].areaId + "'>" + data[i].bm + "</td>" +
            "</tr>"
        );
    }
}
