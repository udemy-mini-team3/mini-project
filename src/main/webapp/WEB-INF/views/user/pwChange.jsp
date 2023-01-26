<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <style>
        .container {
            max-width: 560px;
        }
    </style>
</head>
<body>

<%@ include file="../common/nav.jsp"%>
<div class="container w-50 p-3">

    <div class="py-5 text-center">
        <h2>비밀번호 변경</h2>
    </div>

        <form:form action="" method="post" modelAttribute="userPwdDto">

            <div>
                <label for="oldPwd">기존 비밀번호</label>
                <input type="password" id="oldPwd" name="oldPwd" class="form-control">
                <form:errors path="oldPwd" cssClass="fs-6 text-danger" />
            </div>
            <br>
            <div>
                <label for="newPwd">새 비밀번호</label>
                <input type="password" id="newPwd" name="newPwd" class="form-control">
                <form:errors path="newPwd" cssClass="text-danger"/>
            </div>
            <br>
            <div>
                <label for="newPwdConf">새 비밀번호 확인</label>
                <input type="password" id="newPwdConf" name="newPwdConf" class="form-control">
                <form:errors path="newPwdConf" cssClass="text-danger"/>
            </div>

            <hr class="my-4">



            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="submit" >변경</button>
            </div>

        </form:form>
    </div>


</div>
</body>
</html>
