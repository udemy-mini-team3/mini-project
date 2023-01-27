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
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
    <div class="text-center">
        비밀번호를 잊어 버리셨나요?
        <a href="#" id="testBtn" >비밀번호 찾기</a>
    </div>
</div>



<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="padding:35px 50px;">
                <h4><span class="glyphicon glyphicon-lock"></span> 비밀번호 찾기</h4>
            </div>
            <div class="modal-body" style="padding:40px 50px;">
                <div style="color: #ac2925">
                    <center>입력된 정보로 임시 비밀번호가 전송됩니다.</center>
                </div>
                <hr>
                <form role="form">
                    <div class="form-group">
                        <label for="email"><span class="glyphicon glyphicon-user"></span>email</label>
                        <input type="text" class="form-control" id="email" placeholder="가입시 등록한 이메일을 입력하세요.">
                    </div>
                    <button type="button" class="btn btn-success btn-block" id="checkEmail">OK</button>
                </form>
                <hr>
                <div class="text-center small mt-2" id="checkMsg" style="color: red"></div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-danger btn-default pull-left close" data-dismiss="modal"><span
                        class="glyphicon glyphicon-remove" id="cancelBtn"></span> Cancel
                </button>
            </div>
        </div>

    </div>
</div>
</div>

<script>
    $('#testBtn').click(function(e) {
        $('#myModal').modal("show");
    })


    $('#myModal').on('click','button.close', function (){
        $('#myModal').modal('hide');
    })


    $('.modal').on('hidden.bs.modal', function (e) {
        console.log('modal close');
        $(this).find('form')[0].reset()
    });


    $("#checkEmail").click(function () {
        let email = $("#email").val();

        $.ajax({
            type: "GET",
            url: "/findPw",
            data: {
                "email": email,
            },
            success: function (res) {
                if (res['check']) {
                    swal("발송 완료!", "입력하신 이메일로 임시비밀번호가 발송되었습니다.", "success").then((OK) => {
                            if(OK) {
                                $.ajax({
                                    type: "POST",
                                    url: "/findPw/sendEmail",
                                    data: {
                                        "email": email,
                                    }
                                })
                                window.location = "/login";
                            }
                        }
                    )
                    $('#checkMsg').html('<p style="color:darkblue"></p>');
                } else {
                    $('#checkMsg').html('<p style="color:red">일치하는 정보가 없습니다.</p>');
                }
            }
        })
    })
</script>

</body>
</html>
