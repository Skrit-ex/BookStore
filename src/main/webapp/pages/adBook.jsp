<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Skritex
  Date: 05.05.2024
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdBook</title>
    <jsp:include page="home.jsp"/>
    
    <s:form action="/library/adBook" modelAttribute="adNewBook">
        <br>
        <s:input path="nameBook" placeholder="NameBook"/>
        <br>
        <s:errors path="nameBook"/>
        <br>
        <s:input path="nameAuthor" placeholder="NameAuthor" />
        <br>
        <s:errors path="nameAuthor"/>
        <br>
        <s:input path="lastNameAuthor" placeholder="LastNameAuthor"/>
        <br>
        <s:errors path="lastNameAuthor"/>
        <br>
        <s:input path="genre" placeholder="Genre"/>
        <br>
        <s:errors path="genre"/>
        <br>
        <s:input path="description" placeholder="Description"/>
        <br>
        <s:errors path="description"/>

        <s:button> Submit </s:button>
    </s:form>

    <div class="alert alert-success" role="alert" id="successMessage" style="display: ${bookAddedSuccessfully ? 'block' : 'none'}">
        <h4 class="alert-heading">Your book was added!</h4>
    </div>

    <h1>${errorBook}</h1>
</head>
<body>

</body>
</html>
