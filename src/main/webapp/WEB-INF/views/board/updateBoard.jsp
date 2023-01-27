<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
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
<%@ include file="../common/nav.jsp"%>
<br>
<br>


<%-- contents --%>
<div class="container">
    <div class="py-5 text-center">
        <h2>게시글 수정</h2>
    </div>
    <form action="/board/updateboard" method="post">
        <div class="form-group">
            <input type="text" name="title" class="form-control" value="${board.title }">
        </div>
        <br>
        <div class="form-group">
            <textarea class="form-control" name="content" rows="10">${board.content }</textarea>
        </div>

        <input type="hidden" name="seq" value="${board.boardSeq}">

        <br>
        <%-- buttons --%>
        <div class="container text-center">
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-secondary btn-lg" type="button" style="margin-right: 2px " onclick="location.href='/'">취소</button>
                <button class="btn btn-primary btn-lg" type="submit">수정</button>
            </div>
        </div>
    </form>
</div>

<br>


<script src="js/bootstrap.min.js"></script>
</body>
</html>