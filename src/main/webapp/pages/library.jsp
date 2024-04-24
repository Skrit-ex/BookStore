<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Skritex
  Date: 01.04.2024
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("pageName", "library"); %>
<html>
<head>
    <title>Library</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="background-color: #a4a3a3" >

<jsp:include page="home.jsp"/>
<div class="container text-center color=red">
    <div class="row align-items-end">
        <div class="col">
            NameBook
        </div>
        <div class="col">
            NameAuthor
        </div>
        <div class="col">
            LastNameAuthor
        </div>
        <div class="col">
            Genre
        </div>
        <div class="col">
            Description
        </div>
    </div>
</div>

    <br>

<c:forEach var="book" items="${books}">

<div class="container text-center" >
    <div class="row align-items-end">



        <div class="col">
            ${book.nameBook}
        </div>
        <div class="col">
            ${book.nameAuthor}
        </div>
        <div class="col">
            ${book.lastNameAuthor}
        </div>
        <div class="col">
            ${book.genre}
        </div>
        <div class="col">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                            data-bs-target="#flush-collapseOne" aria-expanded="false"
                            aria-controls="flush-collapseOne" style="color: #918e76">
                        Description
                    </button>
                </h2>
                <div id="flush-collapseOne" class="accordion-collapse collapse"
                     data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">The main idea of the novel is that the main engine of progress
                        is creative people with a pronounced ego. The main character of the novel is the talented
                        architect <code> Howard Roark </code>, a staunch individualist whose mission is to create
                        and transform the world. Roark defends the freedom of a creative person, refuses to compromise
                        and deviate from his own life and professional standards.
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    <br>
</c:forEach>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
