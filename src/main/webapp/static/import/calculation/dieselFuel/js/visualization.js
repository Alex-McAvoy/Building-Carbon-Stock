$(function () {
    $("#visualization").click(function () {
        generateVisualization();
    });
});


function generateVisualization() {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/dieselFuel-consumption/getDieselFuelConsumption",//请求数据的地址
        dataType: "json",        //返回数据形式为json
        success: function (data) {
            generateChart1(data);
            generateChart2(data);
             // console.log(data)
        },
        error: function (errorMsg) {
            alert("图表请求数据失败!");
            // myChart.hideLoading();
        }
    });
}

function generateChart1(data) {
    var myChart = echarts.init(document.getElementById("display-chart1"));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        //标题组件
        title: {
            text: '柴油转换能耗',
            left: '1%'
        },
        tooltip: {         //提示框组件
            trigger: 'axis'//触发类型,坐标轴触发
        },
        grid: {
            left: '5%',    //grid 组件离容器左侧的距离
            right: '15%',
            bottom: '10%'
        },
        xAxis: {
            data: []
        },

        yAxis: {},
        toolbox: {    //工具栏
            right: 10,
            feature: {
                // dataZoom: {    //数据区域缩放
                //     yAxisIndex: 'none'
                // },
                magicType: {   //动态类型切换
                    type: ['line', 'bar']
                },
                // restore: {},  //配置项还原
                // saveAsImage: {}//保存为图片
            }
        },
        dataZoom: [   //用于区域缩放,从而能自由关注细节的数据信息
            {
                startValue: '2022-05-08'
            },
            {
                type: 'inside'//内置型数据区域缩放组件
            }
        ],
        visualMap: {  //分段型视觉映射组件
            top: 50,
            right: 10,
            precision:1,  //设置小数精度
            pieces: [  //定义每块范围

                {
                    gt: 0,
                    lte: 0.5,
                    color: '#FBDB0F'
                },
                {
                    gt: 0.5,
                    lte: 1,
                    color: '#FC7D02'
                },
                {
                    gt: 1,
                    lte: 1.5,
                    color: '#FD0100'
                },
                {
                    gt: 1.5,
                    lte: 2,
                    color: '#AA069F'
                },
                {
                    gt: 2,
                    color: '#AC3B2A'
                }
            ],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: 'wDiesel',

            type: 'line',
            data: [],
            markLine: {//图表标线
                silent: true,   //默认为 false，即响应和触发鼠标事件。
                lineStyle: {    //标线的样式
                    color: '#333'
                },
                data: [
                    // {
                    //     name: '平均线',
                    //     // 支持 'average', 'min', 'max'
                    //     type: 'average'
                    // },
                    {
                        yAxis: 0.5
                    },
                    {
                        yAxis: 1
                    },
                    {
                        yAxis: 1.5
                    },
                    {
                        yAxis: 2
                    }
                ]
            }
        }
    });

    var namey = [];
    var series = [];
    $.each(data.extend.pageInfo.list, function (index, obj) {
        namey.push(parseCreatedTime(obj.createdTime));    //挨个取出类别并填入类别数组
        series.push(getThreeBit(obj.wdiesel));

    });

    myChart.hideLoading();    //隐藏加载动画
    myChart.setOption({        //加载数据图表
        xAxis: {
            data: namey
        },
        series: [{
            data: series
        }]
    });

}
function generateChart2(data) {
    var myChart = echarts.init(document.getElementById("display-chart2"));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        //标题组件
        title: {
            text: '柴油转换碳排放',
            left: '1%'
        },
        tooltip: {         //提示框组件
            trigger: 'axis'//触发类型,坐标轴触发
        },
        grid: {
            left: '5%',    //grid 组件离容器左侧的距离
            right: '15%',
            bottom: '10%'
        },
        xAxis: {
            data: []
        },

        yAxis: {},
        toolbox: {    //工具栏
            right: 10,
            feature: {
                // dataZoom: {    //数据区域缩放
                //     yAxisIndex: 'none'
                // },
                magicType: {   //动态类型切换
                    type: [ 'line','bar']
                },
                // restore: {},  //配置项还原
                // saveAsImage: {}//保存为图片
            }
        },
        dataZoom: [   //用于区域缩放,从而能自由关注细节的数据信息
            {
                startValue: '2022-05-08'
            },
            {
                type: 'inside'//内置型数据区域缩放组件
            }
        ],
        visualMap: {  //分段型视觉映射组件
            top: 50,
            right: 10,
            precision:1,
            pieces: [  //定义每块范围

                {
                    gt: 0,
                    lte: 1,
                    color: '#FBDB0F'
                },
                {
                    gt: 1,
                    lte: 2,
                    color: '#FC7D02'
                },
                {
                    gt: 2,
                    lte: 3,
                    color: '#FD0100'
                },
                {
                    gt: 3,
                    lte: 4,
                    color: '#AA069F'
                },
                {
                    gt: 4,
                    color: '#b035d3'
                }
            ],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: 'tDiesel',

            type: 'bar',
            data: [],
            markLine: {  //图表标线
                silent: true,   //默认为 false，即响应和触发鼠标事件。
                lineStyle: {    //标线的样式
                    color: '#333'
                },
                data: [
                    // {
                    //     name: '平均线',
                    //     // 支持 'average', 'min', 'max'
                    //     type: 'average'
                    // },
                    {
                        yAxis: 1
                    },
                    {
                        yAxis: 2
                    },
                    {
                        yAxis: 3
                    },
                    {
                        yAxis: 4
                    },
                    {
                        yAxis: 5
                    }
                ]
            }
        }
    });

    var namey = [];
    var series = [];
    $.each(data.extend.pageInfo.list, function (index, obj) {
        namey.push(parseCreatedTime(obj.createdTime));    //挨个取出类别并填入类别数组
        series.push(getThreeBit(obj.tdiesel));
    });

    myChart.hideLoading();    //隐藏加载动画
    myChart.setOption({        //加载数据图表
        xAxis: {
            data: namey
        },
        series: [{
            data: series
        }]
    });

}
generateChart1();
generateChart2();