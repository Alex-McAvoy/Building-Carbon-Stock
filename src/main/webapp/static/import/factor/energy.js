//区域排放因子页
$(function () {
    getEnergyTable();
    $("#energy").click(function () {
        getEnergyTable();
    });
});

//获取数据
function getEnergyTable() {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/energy-factor/getEnergyCoalFactor",
        success: function (result) {
            showEnergyTable(result.extend.energyCoalFactor);
        }
    });
}

//生成表格
function showEnergyTable(data) {
    $("#energyTableTbody").html(""); //清空tbody的数据
    for (var i = 0; i < data.length; i++) { //生成表格
        $("#energyTableTbody").append (
            "<tr>" +
            "<td id='energyId-" + data[i].energyId + "'>" + data[i].energyId + "</td>" +
            "<td id='energyName-" + data[i].energyId + "'>" + data[i].energyName + "</td>" +
            "<td id='averageLowCalorificValue-" + data[i].energyId + "'>" + data[i].averageLowCalorificValue + "</td>" +
            "<td id='standardCoaCoefficient-" + data[i].energyId + "'>" + data[i].standardCoaCoefficient + "</td>" +
            "</tr>"
        );
    }
}
