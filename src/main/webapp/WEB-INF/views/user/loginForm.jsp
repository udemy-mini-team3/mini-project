<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>로그인</title>
    <style>
        .container {
            max-width: 560px;
        }
    </style>
    <script>
        $(document).ready(function () {

        });
    </script>
</head>
<body>
<%@ include file="../common/nav.jsp"%>
<div class="container w-50 p-1">
    <div class="py-3 text-center">
        <h2>로그인</h2>
    </div>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <div>
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" required class="form-control">
        </div>
        <div>
            <label for="pw">비밀번호</label>
            <input type="password" id="pw" name="pw" required class="form-control">
        </div>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="submit">로그인</button>
            </div>
            <div class="col">
                <button class="w-100 btn btn-secondary btn-lg"
                    onclick="location.href='<%=request.getContextPath()%>/register'"
                    type="button">회원가입</button>
            </div>
        </div>
    </form>
</div> <!-- /container -->
</body>
</html>
