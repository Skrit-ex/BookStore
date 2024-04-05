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

<form class="row g-3" action="/user/reg" modelAttribute="newUserReg">
    <div class="col-md-4">
        <label for="validationCustom01" class="form-label">First name</label>
        <input type="text" class="form-control" id="validationCustom01" name="firstName" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
    <div class="col-md-4">
        <label for="validationCustom02" class="form-label">LastName</label>
        <input type="text" class="form-control" id="validationCustom02" name="lastName" required>
        <div class="valid-feedback">
            Looks good!
        </div>

        <div class="col-md-4">
            <label for="validationServer02" class="form-label">UserName</label>
            <input type="text" name="userName" class="form-control is-valid" id="validationServer02" required>
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>

    </div>
    <div class="col-md-4">
        <label for="validationServer03" class="form-label">Email</label>
        <input type="text" name="email" class="form-control is-valid" id="validationServer03" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
    <div class="col-md-4">
        <label for="validationServer04" class="form-label">Password</label>
        <input type="text" name="password" class="form-control is-valid" id="validationServer04" required>
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
    <button>submit</button>
</form>

<h1>${regError}</h1>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
