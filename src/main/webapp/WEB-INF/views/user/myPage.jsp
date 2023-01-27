<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <style>
        .container {
            max-width: 560px;
        }
        input:read-only{
            background-color: lightgray;
        }
    </style>
</head>
<body>

<%@ include file="../common/nav.jsp"%>
<div class="container w-50 p-1">
    <div class="py-3 text-center">
        <h2>마이 페이지</h2>
    </div>
    <form:form action="" method="post" modelAttribute="userDto">

        <div>
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" class="form-control" value="${userDto.email}" readonly>
            <form:errors path="email" cssClass="text-danger"/>
        </div>

        <br>
        <div>
            <label for="nickname">닉네임</label>
            <input type="text" id="nickname" name="nickname" class="form-control" value="${userDto.nickname}">
            <form:errors path="nickname" cssClass="text-danger"/>
        </div>
        <br>
        <div>
            <label for="insertDate">가입일</label>
            <input type="text" id="insertDate" name="insertDate" class="form-control" value="${userDto.insertDate}" readonly>
        </div>
        <br>
        <div>
            <label for="updateDate">최종 수정일</label>
            <input type="text" id="updateDate" name="updateDate" class="form-control" value="${userDto.updateDate}" readonly>
        </div>
        <br>
        <div>
            <a href="/pwChange">비밀번호 변경</a>
        </div>

        <c:if test="${result eq 'success'}">
            <p class="text-bg-info">비밀번호 변경 성공</p>
        </c:if>

        <hr class="my-4">

        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="submit">회원 정보 수정</button>
            </div>
            <div class="col">
                <button class="w-100 btn btn-danger btn-lg" onclick="deleteUser(${userSeq});"
                        type="button">회원 탈퇴</button>
            </div>
        </div>
    </form:form>

</div>

<script>
    function deleteUser(userSeq){
        if(window.confirm("탈퇴하시겠습니까?")){
            location.href= "/user/delete";
        }
    }
</script>
</body>
</html>