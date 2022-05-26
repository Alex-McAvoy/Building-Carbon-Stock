//区域排放因子页

$(function () {
    $("#carbon").click(function () {
        getCarbonTable();
    });
});

//获取数据
function getCarbonTable() {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/carbon-factor/getCarbonEmission",
        success: function (result) {
            showCarbonTable(result.extend.carbonEmissionFactor);
        }
    });
}

//生成表格
function showCarbonTable(data) {
    $("#carbonTableTbody").html(""); //清空tbody的数据
    for (var i = 0; i < data.length; i++) { //生成表格
        $("#carbonTableTbody").append (
            "<tr>" +
            "<td id='carbonId-" + data[i].carbonId + "'>" + data[i].carbonId + "</td>" +
            "<td id='energyName-" + data[i].carbonId + "'>" + data[i].energyName + "</td>" +
            "<td id='carbonContent-" + data[i].carbonId + "'>" + data[i].carbonContent + "</td>" +
            "<td id='carbonOxidationRate-" + data[i].carbonId + "'>" + data[i].carbonOxidationRate + "</td>" +
            "<td id='co2EmissionFactor-" + data[i].carbonId + "'>" + data[i].co2EmissionFactor + "</td>" +
            "</tr>"
        );
    }
}
