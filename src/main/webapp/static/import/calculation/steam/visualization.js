$(function () {
    $("#visualization").click(function () {
        generateVisualization();
    });
});

//Ajax请求可视化数据
function generateVisualization() {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/steam-consumption/getSteamConsumption",
        dataType: "json",
        success: function (data) {
            generateChart1(data); //生成蒸汽转换能耗图表
            generateChart2(data); //生成蒸汽转换碳排放图表
        }
    });
}

//生成蒸汽转换能耗图表
function generateChart1(data) {
    var myChart = echarts.init(document.getElementById("display-chart1"));
    myChart.setOption({
        tooltip: { //提示框组件
            trigger: 'axis' //触发类型,坐标轴触发
        },
        grid: { //grid组件
            left: '5%',
            right: '15%',
            bottom: '10%'
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        toolbox: { //工具栏
            right: 10,
            feature: {
                magicType: { //动态类型切换
                    type: ['line', 'bar']
                }
            }
        },
        dataZoom: [ //区域缩放
            {startValue: '2022-05-08'},
            {type: 'inside'} //内置型数据区域缩放组件
        ],
        visualMap: {  //分段型视觉映射组件
            top: 50,
            right: 10,
            precision: 2,  //设置小数精度
            pieces: [{ //定义每块范围
                gt: 0,
                lte: 0.03,
                color: '#54a1c9'
            }, {
                gt: 0.03,
                lte: 0.06,
                color: '#199ce1'
            }, {
                gt: 0.06,
                lte: 0.09,
                color: '#386ed2'
            }, {
                gt: 0.09,
                lte: 0.12,
                color: '#7f06a1'
            }, {
                gt: 0.12,
                color: '#051167'
            }],
            outOfRange: {
                color: '#0de3bd'
            }
        },
        series: {
            name: 'wSteam',
            type: 'line',
            data: [],
            smooth:0.5, //线是否圆滑
            areaStyle:{
                color: new echarts.graphic.LinearGradient(
                    0,0,0,1,[
                        {
                            offset:0,
                            color:"rgba(1,132,213,0.4)"
                        },
                        {
                            offset: 0.8,
                            color: "rgba(1,132,213,0.1)"
                        }
                    ], false
                ),shadowColor: "rgba(0,0,0,0.1)"
            },
            markLine: { //图表标线
                silent: true, //默认为 false，即响应和触发鼠标事件
                lineStyle: { //标线样式
                    color: '#333'
                },
                data: [
                    {yAxis: 0.03},
                    {yAxis: 0.06},
                    {yAxis: 0.09},
                    {yAxis: 0.12}
                ]
            }
        }
    });

    var nameY = [];
    var series = [];
    $.each(data.extend.pageInfo.list, function (index, obj) {
        nameY.push(parseCreatedTime(obj.createdTime));    //挨个取出类别并填入类别数组
        series.push(getThreeBit(obj.wsteam));

    });

    myChart.hideLoading();    //隐藏加载动画
    myChart.setOption({        //加载数据图表
        xAxis: {
            data: nameY
        },
        series: [{
            data: series
        }]
    });
}

//生成蒸汽转换碳排放图表
function generateChart2(data) {
    var myChart = echarts.init(document.getElementById("display-chart2"));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        tooltip: { //提示框组件
            trigger: 'axis' //触发类型,坐标轴触发
        },
        grid: { //grid组件
            left: '5%',
            // right: '15%',
            bottom: '10%'
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        toolbox: { //工具栏
            right: 10,
            feature: {
                magicType: { //动态类型切换
                    type: ['line', 'bar']
                }
            }
        },
        dataZoom: [ //区域缩放
            {startValue: '2022-05-08'},
            {type: 'inside'} //内置型数据区域缩放组件
        ],
        visualMap: { //分段型视觉映射组件
            top: 50,
            right: 10,
            precision: 1,
            pieces: [{ //定义每块范围
                gt: 0,
                lte: 3000,
                color: '#54a1c9'
            }, {
                gt: 3000,
                lte: 6000,
                color: '#199ce1'
            }, {
                gt: 6000,
                lte: 9000,
                color: '#386ed2'
            }, {
                gt: 9000,
                lte: 12000,
                color: '#7f06a1'
            }, {
                gt: 12000,
                color: '#051167'
            }],
            outOfRange: {
                color: '#0de3bd'
            }
        },
        series: {
            name: 'tSteam',
            type: 'line',
            data: [],
            smooth:0.5, //线是否圆滑
            areaStyle:{
                color: new echarts.graphic.LinearGradient(
                    0,0,0,1,[
                        {
                            offset:0,
                            color:"rgba(1,132,213,0.4)"
                        },
                        {
                            offset: 0.8,
                            color: "rgba(1,132,213,0.1)"
                        }
                    ], false
                ),shadowColor: "rgba(0,0,0,0.1)"
            },
            markLine: { //图表标线
                silent: true, //默认为false，即响应和触发鼠标事件
                lineStyle: { //标线的样式
                    color: '#333'
                },
                data: [
                    {yAxis: 3000},
                    {yAxis: 6000},
                    {yAxis: 9000},
                    {yAxis: 12000},
                    {yAxis: 15000}
                ]
            }
        }
    });

    var nameY = [];
    var series = [];
    $.each(data.extend.pageInfo.list, function (index, obj) {
        nameY.push(parseCreatedTime(obj.createdTime));    //挨个取出类别并填入类别数组
        series.push(getThreeBit(obj.tsteam));
    });

    myChart.hideLoading();    //隐藏加载动画
    myChart.setOption({        //加载数据图表
        xAxis: {
            data: nameY
        },
        series: [{
            data: series
        }]
    });
}