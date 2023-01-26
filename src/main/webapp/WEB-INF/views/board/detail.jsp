<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/tag.jsp"%>
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){
    $("#btn-delete-board").on('click', function() {
        location.href="delete?seq=" + ${board.boardSeq };
        alert("삭제가 완료되었습니다!");
    })

    $("#btn-insert-comment").on('click', function() {
        console.log("insert 작동");

        if($("#content").val().trim() == "") {
            alert("내용을 입력해주세요!");
            return;
        }

        $.ajax({
            url: '/comment/insert',
            type: 'post',
            dataType: 'json',
            data: {'boardSeq':${board.boardSeq }, 'writer':2, 'content':$("#content").val()},
            success: function(data) {
                $("#commentbox").html('');
                for (var i = 0; i < data.length; i++) {
                    $("#commentbox").append("<div class='row'><div class='col-2'></div>"
                    + "<div class='col-8 '>"
                    + "<p><span>" + data[i].nickname + "</span>&nbsp;<span>" + data[i].insertDate + "</span></p>"
                    + "<p>" + data[i].content + "</p>"
                    + "</div>"
                    + "<div class='col-8 btn-right'>"
                    + "<button type='button' class='btn btn-primary btn-sm' id='btn-modify-" + data[i].commentSeq +"'>수정하기</button>"
                    + "<button type='button' class='btn btn-primary btn-sm' id='btn-delete-" + data[i].commentSeq +"'>삭제하기</button></div>"
                    + "</div>"
                    + "<hr>");
                }},
                error : function(request, status, error) {
                    alert("code:"+request.status+"\n"
                        +"message:"+request.responseText+"\n"
                        +"error:"+error);
                }

        })
    })

 });
</script>
<style>
	.md {
		margin:auto;
	}

	.btn-right {
		text-align: right;
	}
</style>
</head>
<body>
<%@ include file="../common/nav.jsp"%>
<div class="container">
    <c:if test="${board == null || board.isEmpty()}">
        <script>
            alert("잘못된 접근입니다.");
            location.href="/";
        </script>
    </c:if>

	<div class="row mt-5 md" id="box-detail">
		<div class="col-8 mb-3 md">
			<h3><b>${board.boardSeq }번째 글입니다.</b></h3>
			<h3><b>${board.title } ${board.boardSeq }</b></h3>
			<p><span>작성자 ${board.nickname}</span>&nbsp;| <span>${board.insertDate }</span>&nbsp;| <span>조회수 ${board.viewcount }</span></p>
			<p>${board.content }</p>
		</div>
		<div id="box-boardbtn" class="btn-right col-10">
			<button type="button" class="btn btn-primary btn-sm" id="btn-modify-board">수정하기</button>
			<button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal" >삭제하기</button>
		</div>
	</div>

	<br><br><hr><br><br>

    <c:choose>
        <c:when test="${empty loginid}">
            <div class="row md mb-3">
                <div class="col-8 md mb-5">
                    <textarea style="width:100%; text-align:center;" rows="3" placeholder="로그인 후 사용 가능합니다." readonly></textarea>
                </div>
                <div class="btn-right col-10">
                    <button type="button" class="btn btn-primary btn-sm" id="btn-insert-comment" disabled>등록하기</button>
                </div>
            </div>
        </c:when>
        <c:otherwise>
        	<div class="row md mb-3">
        	    <form id="form-comment" method="post" action="<%=request.getContextPath() %>/comment/insert">
        	    <input type="hidden" name="boardSeq" value="${board.boardSeq }">
                    <div class="col-8 md mb-5">
                        <textarea style="width:100%; text-align:center;" rows="3" name="content" id="content" placeholder="댓글 내용을 입력해주세요."></textarea>
                        <input type="button" value="댓글 입력" class="btn btn-primary btn-sm" id="btn-insert-comment" >
                    </div>
        	    <form>
        	</div>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="">
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>

	<div id="box-comment-list">
        <div class="row mb-5 md" id="commentbox" >
        <c:forEach items="${commentList}" var="comment">
            <div class="col-8 md" >
                <p><span>${comment.nickname}</span>&nbsp;<span>${comment.insertDate}</span></p>
                <p>${comment.content}</p>
            </div>
            <div class="col-10 btn-right">
                <button type="button" class="btn btn-primary btn-sm" id="btn-modify-${comment.commentSeq}" onclick="location.href='/comment/update/${comment.commentSeq}'">수정하기</button>
                <button type="button" class="btn btn-primary btn-sm" id="btn-delete-${comment.commentSeq}" data-bs-toggle="modal" data-bs-target="#deleteCommentModal">삭제하기</button>
            </div>
		    <hr>
        </c:forEach>
        </div>
	</div>

	<!-- Modal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="닫기"></button>
          </div>
          <div class="modal-body" style="text-align: center">
            <h4><strong>정말 삭제하시겠습니까?</strong><h4>
            <p class="fs-5 mb-5">삭제 후 복구는 불가합니다.</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
            <button type="button" class="btn btn-primary" id="btn-delete-board">확인</button>
          </div>
        </div>
      </div>
    </div>
    <!-- Comment delete modal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="닫기"></button>
          </div>
          <div class="modal-body" style="text-align: center">
            <h4><strong>정말 삭제하시겠습니까?</strong><h4>
            <p class="fs-5 mb-5">삭제 후 복구는 불가합니다.</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
            <button type="button" class="btn btn-primary" id="btn-delete-board">확인</button>
          </div>
        </div>
      </div>
    </div>
</div>

</body>
</html>