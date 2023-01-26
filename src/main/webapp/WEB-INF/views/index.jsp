<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        .b{
            border: solid 1px black;
        }

    </style>
</head>
<body>

<%-- navbar --%>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="img/bae.jpg" alt="Logo" width="35" height="35" class="d-inline-block align-text-top">
            배용남
        </a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">질문답변</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">정보공유</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">이벤트</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="#">로그인</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">회원가입</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<br>
<br>

<div class="container">
    <div class="container text-center">
        <div class="row">
            <div class="col">
                <button type="button" class="btn btn-outline-secondary" onclick="location.href='writeBoard'">글 작성</button>
            </div>
            <div class="col-6">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="검색어를 입력하세요" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
                </div>
            </div>
            <div class="col">
                <select class="form-select" aria-label="Default select example">
                    <option selected>정렬</option>
                    <option value="1">최신순</option>
                    <option value="2">오래된순</option>
                    <option value="3">조회수</option>
                </select>
            </div>
        </div>
    </div>
</div>

<br>

<%-- 테이블 --%>
<%-- class="table"을 적어야 bootstrap 스타일이 적용됨 --%>
<div class="container">
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">제목</th>
            <th scope="col">내용</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
            <th scope="col">조회수</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${boardList }" var="board">
        <tr onclick="location.href='getBoard?seq=${board.boardSeq}'">
            <th scope="row">${board.boardSeq}</th>
            <td>${board.title}</td>
            <td>${board.content}</td>
            <td>${board.nickname}</td>
            <td>${board.insertDate}</td>
            <%--<fmt:parseDate value="${board.insertDate}" var="convertedDate" pattern="yyyy-MM-dd HH:mm:ss"/>
            <td><fmt:formatDate value="${convertedDate}" pattern="yyyy-MM-dd"/></td>--%>
            <td>${board.viewcount}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<br>

<%-- button group --%>
<div class="container text-center">
    <div class="row justify-content-md-center">
        <div class="col col-lg-2">
        </div>
        <div class="col-md-auto">
            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group me-2" role="group" aria-label="First group">
                    <% int pageCount = (Integer)request.getAttribute("pageCount");
                        for (int i = 1; i <= pageCount; i++) {
                    %>
                        <button type="button" class="btn btn-primary" onclick="location.href='boardList?pageNum=<%=i%>'"><%=i%></button>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
        <div class="col col-lg-2">
        </div>

    </div>
</div>
<%-- end of button group --%>

<br>

<script src="js/bootstrap.min.js"></script>
</body>
</html>