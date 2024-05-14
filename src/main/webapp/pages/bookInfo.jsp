<%--
  Created by IntelliJ IDEA.
  User: Skritex
  Date: 14.05.2024
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookInfo</title>
</head>
<body>

<h1>${book.nameBook}</h1>
<p>Автор: ${book.nameAuthor}</p>
<p>Описание: ${book.description}</p>
<br>
<a href="/library">Вернуться в библиотеку</a>

</body>
</html>
