$(function () {
    $("#visualization").click(function () {
        generateVisualization();
    });
});

//Ajax请求可视化数据
function generateVisualization() {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/gas-consumption/getAllGasConsumption",
        dataType: "json",
        success: function (data) {
            generateChart1(data); //生成天然气转换能耗图表
            generateChart2(data); //生成天然气转换碳排放图表
        }
    });
}

//生成天然气转换能耗图表
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
            precision: 1,  //设置小数精度
            pieces: [{ //定义每块范围
                gt: 0,
                lte: 0.5,
                color: '#54a1c9'
            }, {
                gt: 0.5,
                lte: 1,
                color: '#199ce1'
            }, {
                gt: 1,
                lte: 1.5,
                color: '#386ed2'
            }, {
                gt: 1.5,
                lte: 2,
                color: '#7f06a1'
            }, {
                gt: 2,
                color: '#051167'
            }],
            outOfRange: {
                color: '#0de3bd'
            }
        },
        series: {
            name: 'wgas',
            type: 'line',
            data: [],
            lineStyle:{ //修改当前线条的样式
                // color:'red',
                width:'2'
                // type:'dashed' //虚线
            },
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
                    {yAxis: 0.5},
                    {yAxis: 1},
                    {yAxis: 1.5},
                    {yAxis: 2}
                ]
            }
        }
    });

    var nameY = [];
    var series = [];
    $.each(data.extend.list, function (index, obj) {
        nameY.push(parseCreatedTime(obj.createdTime));    //挨个取出类别并填入类别数组
        series.push(getThreeBit(obj.wgas));
    });

    myChart.hideLoading(); //隐藏加载动画
    myChart.setOption({ //加载数据图表
        xAxis: {
            data: nameY
        },
        series: [{
            data: series
        }]
    });
}

//生成天然气转换碳排放图表
function generateChart2(data) {
    var myChart = echarts.init(document.getElementById("display-chart2"));
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
        visualMap: { //分段型视觉映射组件
            top: 50,
            right: 10,
            precision: 1,
            pieces: [{ //定义每块范围
                gt: 0,
                lte: 0.5,
                color: '#54a1c9'
            }, {
                gt: 0.5,
                lte: 1,
                color: '#199ce1'
            }, {
                gt: 1,
                lte: 1.5,
                color: '#386ed2'
            }, {
                gt: 1.5,
                lte: 2,
                color: '#7f06a1'
            }, {
                gt: 2,
                color: '#051167'
            }],
            outOfRange: {
                color: '#0de3bd'
            }
        },
        series: {
            name: 'tgas',
            type: 'line',
            data: [],
            smooth:0.5,
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
                    {yAxis: 0.5},
                    {yAxis: 1},
                    {yAxis: 1.5},
                    {yAxis: 2},
                    {yAxis: 2.5}
                ]
            }
        }
    });

    var nameY = [];
    var series = [];
    $.each(data.extend.list, function (index, obj) {
        nameY.push(parseCreatedTime(obj.createdTime));    //挨个取出类别并填入类别数组
        series.push(getThreeBit(obj.tgas));
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
