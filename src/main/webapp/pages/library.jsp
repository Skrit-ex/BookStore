<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Skritex
  Date: 01.04.2024
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body style="background-color: #525151;">

<jsp:include page="home.jsp"/>
<div class="container text-center">
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

    <br>

<div class="container text-center">
    <div class="row align-items-end">
        <div class="col">
            Atlas Shrugged
        </div>
        <div class="col">
            Ayn
        </div>
        <div class="col">
           Rand
        </div>
        <div class="col">
            novel
        </div>
        <div class="col">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                            data-bs-target="#flush-collapseOne" aria-expanded="false"
                            aria-controls="flush-collapseOne" style="color: cornflowerblue">
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

    <br>

    <div class="container text-center">
        <div class="row align-items-end">
            <div class="col">
                The Fountainhead
            </div>
            <div class="col">
                Ayn
            </div>
            <div class="col">
                Rand
            </div>
            <div class="col">
                novel
            </div>
            <div class="col">
                <div class="accordion accordion-flush" id="accordionFlushExample">
                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#flush-collapseOne" aria-expanded="false"
                                aria-controls="flush-collapseOne" style="color: cornflowerblue">
                            Description
                        </button>
                    </h2>
                    <div id="flush-collapseTwo" class="accordion-collapse collapse"
                         data-bs-parent="#accordionFlushExample">
                        <div class="accordion-body">The novel describes a dystopian United States of America in which
                            private business suffers from regulatory government policies. Railroad manager
                            <code> Dagny Taggert </code>
                            and her lover, steel magnate Hank Rearden, are trying to build their business without following
                            the orders of government officials, who are considered "bandits." There are a number of
                            mysterious disappearances of entrepreneurs, prominent specialists and artists.</div>
                        </div>
                </div>
            </div>
        </div>
    </div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
