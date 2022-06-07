//各类能耗情况页

//获取各类能耗情况页数据
$(function () {
    $("#consumption").click(function () {
        getConsumptionData();
    });
});

//ajax获取各类能耗情况数据
function getConsumptionData() {
    $.ajax({
        type: "GET",
        url: APP_PATH + "",
        success: function (result) {
            generateConsumptionChart(result);
        }
    });
}

//生成各类能耗情况图表
function generateConsumptionChart(data) {

}