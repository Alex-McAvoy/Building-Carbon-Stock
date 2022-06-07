//建筑电力碳排放比例分布页

//启动页面后自动获取建筑电力碳排放比例分布页数据
$(function () {
    getProportionData();
    $("#proportion").click(function () {
        getProportionData();
    });
});

//ajax获取建筑电力碳排放比例分布数据
function getProportionData() {
    $.ajax({
        type: "GET",
        url: APP_PATH + "",
        success: function (result) {
            generateProportionChart(result);
        }
    });
}

//生成建筑电力碳排放比例分布图表
function generateProportionChart(data) {

}