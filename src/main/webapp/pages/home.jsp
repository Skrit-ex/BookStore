<%--
  Created by IntelliJ IDEA.
  User: Skritex
  Date: 01.04.2024
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body body style="background-color: #b6b2b2;">

<nav class="navbar navbar-expand-lg bg-dark p2 " style="--bs-bg-opacity: .3;">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="/">Home</a>
        <c:if test="${sessionScope.userSession == null}">
        <a class="nav-link" href="/user/reg">Registration</a>
        </c:if>
        <a class="nav-link" href="/user/login">LogIn</a>

        <c:if test="${sessionScope.userSession != null}">
          <a class="nav-link" href="/user/logout">LogOut</a>
        </c:if>

        <c:if test="${sessionScope.userSession != null}">
          <li class="nav-item">
            <a class="nav-link" href="/library">Library</a>
          </li>
        </c:if>

        <li class="nav-item">

          <c:if test="${sessionScope.userSession != null}">
            <a class="nav-link disabled">Hello ${sessionScope.userSession.username}</a>
          </c:if>

          <c:if test="${sessionScope.userSession == null}">
            <a class="nav-link disabled">Hello Guest</a>
          </c:if>

          <c:if test="${pageName == 'library'}">
            <form  action="/library/search" method="get" class="d-flex" role="search">
              <input name="nameBook" class="form-control me-2" type="search" placeholder="Search nameBook"
                     aria-label="Search">
              <input name="nameAuthor" class="form-control me-2" type="search" placeholder="Search nameAuthor"
                     aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </c:if>

        </li>
      </div>
    </div>
  </div>
</nav>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>

</html>
