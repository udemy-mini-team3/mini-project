<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>회원가입</title>
    <style>
        .container {
            max-width: 560px;
        }
    </style>
    <script src="js/jquery-3.6.1.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#form').on('submit', function(e){
                if ($('#pw').val() !== $('#pw2').val()) {
                    alert("암호가 일치하지 않습니다.");
                    e.preventDefault();
                }
            });
        });
    </script>
</head>
<body>
<%@ include file="../common/nav.jsp"%>
<div class="container w-50 p-3">
    <div class="py-5 text-center">
        <h2>회원 가입</h2>
    </div>
    <h4 class="mb-3">회원 정보 입력</h4>
    <form id ="form" action="<%= request.getContextPath()%>/register" method="post">
        <div>
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" required class="form-control">
        </div>
        <div>
            <label for="pw">비밀번호</label>
            <input type="password" id="pw" name="pw" required class="form-control">
        </div>
        <div>
            <label for="pw2">비밀번호 확인</label>
            <input type="password" id="pw2" name="pw2" required class="form-control">
        </div>
        <div>
            <label for="nickname">닉네임</label>
            <input type="text" id="nickname" name="nickname" required class="form-control">
        </div>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="submit">회원 가입</button>
            </div>
            <div class="col">
                <button class="w-100 btn btn-secondary btn-lg"
                        onclick="location.href='<%= request.getContextPath()%>/login'"
                        type="button">로그인</button>
            </div>
        </div>
    </form>
</div> <!-- /container -->
</body>
</html>
