//各类碳排放情况页

//获取各类碳排放情况页数据
$(function () {
    $("#emission").click(function () {
        getEmissionData();
    });
});

//ajax获取各类碳排放情况数据
function getEmissionData() {
    $.ajax({
        type: "GET",
        url: APP_PATH + "",
        success: function (result) {
            generateEmissionChart(result);
        }
    });
}

//生成各类碳排放情况图表
function generateEmissionChart(data) {

}