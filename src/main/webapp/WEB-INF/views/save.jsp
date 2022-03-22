<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: kwon
  Date: 2022/03/22
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id= ${member.id}</li>
    <li>username= ${member.userName}</li>
    <li>age= ${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
