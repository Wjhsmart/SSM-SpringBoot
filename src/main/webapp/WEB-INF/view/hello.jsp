<%--
  Created by IntelliJ IDEA.
  User: Wjhsmart
  Date: 2017/7/24
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>欢迎页面</title>
    <link href="<%=path %>/static/css/main.css" rel="stylesheet"/>
</head>
<body>
    <p>Hello, ${name },<br />你的名字是:${user.name },<br />ID是:${user.id },<br />创建时间是:<fmt:formatDate value="${user.createdTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </p>

    <button onclick="hello()">Hello</button>
    <p class="test">test css</p>

    <script src="<%=path %>/static/js/main.js"></script>
</body>
</html>
