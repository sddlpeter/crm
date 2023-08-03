<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <!--  JQUERY -->
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>

    <script type="text/javascript" src="jquery/echarts/echarts.min.js"></script>
    <title>演示echarts</title>

    <script type="text/javascript">
        $(function(){
            // 当容器加载完成，对容器调用方法

            var myChart = echarts.init(document.getElementById('main'));

            // Specify the configuration items and data for the chart
            var option = {
                title: {
                    text: 'Funnel'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c}%'
                },
                toolbox: {
                    feature: {
                        dataView: { readOnly: false },
                        restore: {},
                        saveAsImage: {}
                    }
                },
                legend: {
                    data: ['Show', 'Click', 'Visit', 'Inquiry', 'Order']
                },
                series: [
                    {
                        name: 'Expected',
                        type: 'funnel',
                        left: '10%',
                        width: '80%',
                        label: {
                            formatter: '{b}Expected'
                        },
                        labelLine: {
                            show: false
                        },
                        itemStyle: {
                            opacity: 0.7
                        },
                        emphasis: {
                            label: {
                                position: 'inside',
                                formatter: '{b}Expected: {c}%'
                            }
                        },
                        data: [
                            { value: 60, name: 'Visit' },
                            { value: 40, name: 'Inquiry' },
                            { value: 20, name: 'Order' },
                            { value: 80, name: 'Click' },
                            { value: 100, name: 'Show' }
                        ]
                    }
                ]
            };

            // Display the chart using the configuration items and data just specified.
            myChart.setOption(option);


        });
    </script>
</head>
<body>

<div id="main" style="width: 600px;height:400px;"></div>

</body>
</html>
