<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>演示文件下载</title>

    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js">
        // 入口函数
        $(function(){
            // 给"下载"按钮添加单击事件
            $("#fileDownloadBtn").click(function(){
                // 所有文件下载的请求，只能发同步请求，不能发异步请求
                // 虽然发同步请求，但是返回的（响应信息）是一个文件，不会把页面覆盖
                window.location.href="workbench/activity/fileDownload.do";
            });
        });
    </script>
</head>
<body>

<input type="button" value="下载" id="fileDownloadBtn">
</body>
</html>
