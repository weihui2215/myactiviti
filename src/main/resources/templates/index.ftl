<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - FreeMarker</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
</head>
<body>
<h2>首页${request.contextPath}<h2>

    <font>
        <#list userList as item>
            ${item!}<br />
        </#list>
    </font>

    <button class="a"> click me</button>
</body>
</html>