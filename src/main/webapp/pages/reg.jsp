<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Skritex
  Date: 05.04.2024
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="home.jsp"/>

<s:form action="/user/reg" modelAttribute="newUserReg">
    <br>
    <s:input path="firstname" placeholder="FirstName"/>
    <br>
    <s:errors path="firstname"/>
    <br>
    <s:input path="lastname" placeholder="LastName"/>
    <br>
    <s:errors path="lastname"/>
    <br>
    <s:input path="username" placeholder="UserName"/>
    <br>
    <s:errors path="username"/>
    <br>
    <s:input path="email" placeholder="Email"/>
    <br>
    <s:errors path="email"/>
    <br>
    <s:input path="password" placeholder="Password"/>
    <br>
    <s:errors path="password"/>
    <br>

    <s:button>Submit</s:button>

</s:form>

<h1>${regError}</h1>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
