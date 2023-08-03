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
                    text: 'ECharts Getting Started Example'
                },
                tooltip: {},
                legend: {
                    data: ['sales']
                },
                xAxis: {
                    data: ['Shirts', 'Cardigans', 'Chiffons', 'Pants', 'Heels', 'Socks']
                },
                yAxis: {},
                series: [
                    {
                        name: 'sales',
                        type: 'bar',
                        data: [5, 20, 36, 10, 10, 20]
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
