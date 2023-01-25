<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script> $(document).ready(function(){ }); </script>
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
<div class="container">
<%@ include file="../common/nav.jsp"%>
	<div class="row mt-5 md" id="box-detail">
		<div class="col-8 mb-3 md">
			<h3><b>${board.title }</b></h3>
			<p><span>작성자 ${board.nickname}</span>&nbsp;| <span>${board.insertDate }</span>&nbsp;| <span>조회수 ${board.viewcount }</span></p>
			<p>${board.content }</p>
		</div>
		<div id="box-boardbtn" class="btn-right col-10">
			<button type="button" class="btn btn-primary btn-sm" id="btn-modify-board">수정하기</button>		
			<button type="button" class="btn btn-primary btn-sm" id="btn-delete-board">삭제하기</button>		
		</div>
	</div>
	<br><br><hr><br><br>
	<div class="row md mb-3">
		<div class="col-8 md mb-5">
			<textarea style="width:100%; text-align:center;" rows="3" placeholder="로그인 후 사용 가능합니다." readonly></textarea>
			<textarea style="width:100%; text-align:center;" rows="3" placeholder="댓글 내용을 입력해주세요."></textarea>
		</div>
		<div id="box-boardbtn" class="btn-right col-10">
			<button type="button" class="btn btn-primary btn-sm" id="btn-insert-comment" >등록하기</button>		
			<button type="button" class="btn btn-primary btn-sm" id="btn-insert-comment" disabled>등록하기</button>		
		</div>
	</div>
	<div id="box-comment">
		<div class="row mb-5 md" >
		</div>
		<hr>
	</div>
</div>

</body>
</html>