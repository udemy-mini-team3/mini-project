<%@ page import="com.example.mini.util.SessionConst" %>
<%@ page import="com.example.mini.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<%@ include file="../common/nav.jsp"%>
<br>
<br>
<br>


<%-- contents --%>
<div class="container">
    <div class="py-5 text-center">
        <h2>게시글 등록</h2>
    </div>

    <form action="insertboard" method="post">
        <div class="form-group">
            <input type="text" name="title" class="form-control" placeholder="제목을 입력해주세요.">
        </div>
        <br>
        <div class="form-group">
            <textarea name="content" class="form-control" rows="10" placeholder="내용을 입력해주세요."></textarea>
        </div>
        <input class="form-group" type="hidden" name="writer" value=<%=((UserDto) session.getAttribute(SessionConst.LOGIN_USER)).getSeq()%>>


        <br>
        <%-- buttons --%>
        <div class="container text-center">
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-primary btn-lg" type="button" style="margin-right: 2px" onclick="location.href='/'">취소</button>
                <button class="btn btn-primary btn-lg" type="submit" >등록</button>
            </div>
        </div>
    </form>
</div>



<br>



<script src="js/bootstrap.min.js"></script>
</body>
</html>