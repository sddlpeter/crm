<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">

    <!-- bs datetimepicker 依赖 bootstrap, bootstrap 依赖 jquery -->
    <!-- 1. 引入Jquery -->
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>

    <!-- 2. 引入bootstrap框架 -->
    <link rel="stylesheet" href="jquery/bootstrap_3.3.0/css/bootstrap.min.css">
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

    <!-- 3. 引入Boostrap DateTimePicker -->
    <link rel="stylesheet" href="jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>

    <title>演示bs_datetimepicker插件</title>

    <script type="text/javascript">
        // 在入口函数里面调用bs datetimepicker，好处是当页面加载完成，才开始运行这个代码，可以确保容器先被初始化
        $(function(){
            // 当容器加载完，对容器调用工具函数
            $("#myDate").datetimepicker({
                language:'en',
                format:'yyyy-mm-dd',
                minView:'month',
                autoclose:true,
                initialDate:new Date(),
                todayBtn:true,
                clearBtn:true
            });
        });
    </script>
</head>
<body>

<input type="text" id="myDate" readonly>

</body>
</html>
