$(function () {
    $("#visualization").click(function () {
        generateVisualization();
    });
});

//Ajax请求可视化数据
function generateVisualization() {
    $.ajax({
        type: "GET",
        url: APP_PATH + "/electricity-consumption/getAllElectricConsumption",
        dataType: "json",
        success: function (data) {
            // console.log(data);
            generateChart1(data); //生成蒸汽转换能耗图表
            generateChart2(data); //生成总用电量图表
            generateChart3(data);
        }
    });
}
//生产各种设备能耗图
function generateChart1(data) {
    var myChart = echarts.init(document.getElementById("display-chart1"));

     myChart.setOption ({
         tooltip: { //提示框组件
             trigger: 'axis', //触发类型,坐标轴触发
             // showContent: false
         },
         xAxis: {
             type: 'category'  //坐标轴类型，'category' 类目轴，适用于离散的类目数据。为该类型时类目数据可自动从 series.data 或 dataset.source 中取，或者可通过 xAxis.data 设置类目数据
         },
         yAxis: {
             gridIndex: 0  //y 轴所在的 grid 的索引，默认位于第一个 grid
         },
         grid: {  //直角坐标系内绘图网格，单个 grid 内最多可以放置上下两个 X 轴，左右两个 Y 轴。
              top: '55%',
              left: '5%',
              right: '15%',
              bottom: '10%'
         },
         dataZoom: [ //区域缩放
             {startValue: '2022-05-08'},
             {type: 'inside'} //内置型数据区域缩放组件
         ],
         toolbox: { //工具栏
             right: 50,
             top:190,
             feature: {
                 magicType: { //动态类型切换
                     type: ['line', 'bar']
                 }
             }
         },
         series: [{
             name: '暖通空调能耗',
             type: 'line',
             smooth:true,      //是否平滑曲线显示
             markLine: { //图表标线
                 silent: true, //默认为 false，即响应和触发鼠标事件
                 lineStyle: { //标线样式
                     color: '#333'},},
             emphasis: {  //折线图的高亮状态
                 focus: 'series'  //在高亮图形时，是否淡出其它数据的图形已达到聚焦的效果,聚焦当前高亮的数据所在的系列的所有图形。
             }},
         {
             name: '生活热水能耗',
             type: 'line',
             smooth:true,
             markLine: { //图表标线
                 silent: true, //默认为 false，即响应和触发鼠标事件
                 lineStyle: { //标线样式
                     color: '#333'
                 },},
             emphasis: {  //折线图的高亮状态
                 focus: 'series'  //在高亮图形时，是否淡出其它数据的图形已达到聚焦的效果,聚焦当前高亮的数据所在的系列的所有图形。
             }},
             {
                 name: '照明能耗',
                 type: 'line',
                 smooth:true,
                 markLine: { //图表标线
                     silent: true, //默认为 false，即响应和触发鼠标事件
                     lineStyle: { //标线样式
                         color: '#333'
                     },},
                 emphasis: {  //折线图的高亮状态
                     focus: 'series'  //在高亮图形时，是否淡出其它数据的图形已达到聚焦的效果,聚焦当前高亮的数据所在的系列的所有图形。
                 }},
             {
                 name: '其它用能设备能耗',
                 type: 'line',
                 smooth:true,
                 markLine: { //图表标线
                     silent: true, //默认为 false，即响应和触发鼠标事件
                     lineStyle: { //标线样式
                         color: '#333'
                     },},
                 emphasis: {  //折线图的高亮状态
                     focus: 'series'  //在高亮图形时，是否淡出其它数据的图形已达到聚焦的效果,聚焦当前高亮的数据所在的系列的所有图形。
                 }},
             {
                 type: 'pie',  //饼图
                 id: 'pie',   //默认不指定。指定则可用于在 option 或者 API 中引用组件。
                 // radius: '30%',
                 radius:['20%','40%'],  //饼图的半径
                 // avoidLabelOverlap: false,//是否启用防止标签重叠策略，默认开启
                 center: ['50%', '25%'],
                 emphasis: {     //高亮状态的扇区和标签样式
                     focus: 'self'  //只聚焦（不淡出）当前高亮的数据的图形。
                 },
                 itemStyle: {    //图形样式
                     borderRadius: 5,  //用于指定饼图扇形区块的内外圆角半径，支持设置固定数值或者相对于扇形区块的半径的百分比值。
                     borderColor: '#fff',//图形的描边颜色
                     borderWidth: 1
                 },
                 label: {
                     formatter: '{b}: {@2022-05-08} ({d}%)'  //标签内容格式器，支持字符串模板和回调函数两种形式，字符串模板与回调函数返回的字符串均支持用 \n 换行。
                     // 字符串模板 模板变量有：
                     // {a}：系列名。
                     // {b}：数据名。
                     // {c}：数据值。
                     // {d}：百分比。
                     // {@xxx}：数据中名为 'xxx' 的维度的值，如 {@product} 表示名为 'product' 的维度的值。
                     // {@[n]}：数据中维度 n 的值，如 {@[3]} 表示维度 3 的值，从 0 开始计数。
                 },
                 encode: {  //可以定义 data 的哪个维度被编码成什么
                     itemName: '创建时间',
                     value: '2022-05-08',
                     tooltip: '2022-05-08'
                 }
             }
         ]
    });
    var nameY = ['创建时间'];
    var series1 = ['暖通空调能耗'];
    var series2 = ['生活热水能耗'];
    var series3 = ['照明能耗'];
    var series4 = ['其他用能设备能耗'];
    $.each(data.extend.list, function (index, obj) {
        nameY.push(parseCreatedTime(obj.createdTime));    //挨个取出类别并填入类别数组
        series1.push(obj.wn);
        series2.push(obj.wr);
        series3.push(obj.ww);
        series4.push(obj.we);
         // console.log(series1)
    });
    myChart.setOption({
        xAxis: {     //传入折线图x轴数据
            data: nameY
        },
        dataset:{  //传入饼图数据，数据集（dataset）组件用于单独的数据集声明，从而数据可以单独管理，被多个组件复用，并且可以自由指定数据到视觉的映射。
            source:[    //原始数据
            nameY,
           series1,
           series2,
           series3,
           series4
       ]},
        series:[{   //传入折线图y轴数据
            data:series1
        },{
            data: series2
        },{
            data: series3
        },{
            data: series4
        }
        ]
    });
    myChart.on('updateAxisPointer', function (event) {
        const xAxisInfo = event.axesInfo[0];
        if (xAxisInfo) {
            const dimension = xAxisInfo.value+1 ;
            myChart.setOption({
                series: {
                    id: 'pie',
                    label: {
                        formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                    },
                    encode: {
                        value: dimension,
                        tooltip: dimension
                    }
                }
            });
        }
    });

};

//生成总用电量图
function  generateChart2(data) {
    var myChart  = echarts.init(document.getElementById("display-chart2"));
    // 显示标题，图例和空的坐标轴
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
                lte: 3000,
                color: '#FBDB0F'
            }, {
                gt: 3000,
                lte: 6000,
                color: '#FC7D02'
            }, {
                gt: 6000,
                lte: 9000,
                color: '#FD0100'
            }, {
                gt: 9000,
                lte: 12000,
                color: '#AA069F'
            }, {
                gt: 12000,
                color: '#b035d3'
            }],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '总用电量',
            type: 'line',
            data: [],
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
    $.each(data.extend.list, function (index, obj) {
        nameY.push(parseCreatedTime(obj.createdTime));    //挨个取出类别并填入类别数组
        series.push(getThreeBit(obj.d));
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
//生成电力转换能耗图
function generateChart3(data) {
    var myChart = echarts.init(document.getElementById("display-chart3"));
    // 显示标题，图例和空的坐标轴
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
                lte: 3,
                color: '#FBDB0F'
            }, {
                gt: 3,
                lte: 6,
                color: '#FC7D02'
            }, {
                gt: 6,
                lte: 9,
                color: '#FD0100'
            }, {
                gt:12,
                lte: 15,
                color: '#AA069F'
            }, {
                gt: 15,
                color: '#b035d3'
            }],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '电力转换能耗',
            type: 'line',
            data: [],
            markLine: { //图表标线
                silent: true, //默认为false，即响应和触发鼠标事件
                lineStyle: { //标线的样式
                    color: '#333'
                },
                data: [
                    {yAxis: 3},
                    {yAxis: 6},
                    {yAxis: 9},
                    {yAxis: 12},
                    {yAxis: 15}
                ]
            }
        }
    });

    var nameY = [];
    var series = [];
    $.each(data.extend.list, function (index, obj) {
        nameY.push(parseCreatedTime(obj.createdTime));    //挨个取出类别并填入类别数组
        series.push(getThreeBit(obj.welectricity));
    });

    // myChart.hideLoading();    //隐藏加载动画
    myChart.setOption({        //加载数据图表
        xAxis: {
            data: nameY
        },
        series: [{
            data: series
        }]
    });
}



