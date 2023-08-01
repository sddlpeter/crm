<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <!--  JQUERY -->
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>

    <!--  BOOTSTRAP -->
    <link rel="stylesheet" type="text/css" href="jquery/bootstrap_3.3.0/css/bootstrap.min.css">
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

    <!--  TYPE_AHEAD -->
    <script type="text/javascript" src="jquery/bs_typeahead/bootstrap3-typeahead.min.js"></script>

    <title>演示自动补全插件2</title>

    <script type="text/javascript">
        $(function () {
            $("#customerName").typeahead({
                source: function (jquery, process) { //每次键盘弹起，都会发送请求到后台，查询所有的名称，以json字符串返回
                                                     // process 是一个函数，能将查询到的结果赋给source，进行模糊匹配
                                                    // jquery 就是要查询的关键字
                    // var customerName=$("#CustomerName").val();
                    $.ajax({
                        url: 'workbench/transaction/queryAllCustomerName.do',
                        data:{
                            customerName:jquery
                        },
                        type: 'post',
                        dataType: 'json',
                        success: function (data) {
                            process(data);
                        }
                    });
                }
            });
        });
    </script>
</head>
<body>

<input type="text" id="customerName">

</body>
</html>
