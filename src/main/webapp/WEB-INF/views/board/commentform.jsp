<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/tag.jsp"%>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.min.js"></script>
    <title>리뷰 수정</title>
    <style>
    </style>
    <script>
        $(document).ready(function () {
                console.log("${dto.boardSeq}");
                console.log("sefsfd");
                console.log("location.href='/comment/update/"+${dto.boardSeq}+"'>수정하기");

        });
    </script>
</head>
<body>
<%@ include file="../common/nav.jsp"%>
<div class="container">
    <div class="py-5 text-center">
        <h2>댓글 수정하기</h2>
    </div>
    <form action="/comment/update" method="post" style="width:100%; text-align:center;">
        <textarea name="content" cols="100" rows="5">${dto.content}</textarea>
        <input type="hidden" name="boardSeq" value="${dto.boardSeq}">
        <input type="hidden" name="seq" value="${dto.seq}">
        <div class="row">
            <div class="col mt-5" text-align="center">
                <button class="btn btn-secondary btn-lg" type="button" onclick="history.back()">취소하기</button>
                <button class="btn btn-primary btn-lg" type="submit" >수정하기</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
