<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.6.1.min.js" ></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
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
			<h3><b>도움을 요청합니다.</b></h3>
			<p><span>작성자</span>&nbsp;<span>작성시간</span></p>
			<p>안녕하세요. 공부를 시작한지 얼마 되지 않고 이러 저런 시행착오를 겪고 있는중 문제가 도저히 해결되지 않아 질문 드립니다.
			일단 저는 mac os, m1칩을 사용중이며 현재 docker와 colima를 이용하여 oracle 을 로컬에서 사용중에 있습니다.
			JDBC 공부를 위하여 이클립스에서 oracle DB에 연결하고자 하는데 로케일을 인식할 수 없다는 에러가 자꾸 발생합니다.
			웹상에 나와있는 많은 해결법들을 시도 해 보았으나 해결되지 않고 있습니다.
			시도한 방법은 다음과 같습니다.
			지역 대한민국->미국->대한민국 변경 SQLDeveloper 에 로케일 설정 추가(AddVMOption -Duser.language=ko 
			AddVMOption -Duser.country=KR_Tomcat에 로케일 설정 추가</p>
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
			<div class="col-8 md">
				<p><span>댓글작성자</span>&nbsp;<span>작성시간</span></p>
				<p>안녕하세요. docker와 colima를 이용하여 oracle 을 로컬에서 인식할 수 없다는 에러가 자꾸 발생합니다.
				웹상에 나와있는 많은 해결법들을 시도 해 보았으나 해결되지 않고 있습니다.
				지역 대한민국->미국->대한민국 변경</p>
			</div>
			<div id="box-commentbtn" class="col-10 btn-right">
				<button type="button" class="btn btn-primary btn-sm" id="btn-modify-comment">수정하기</button>		
				<button type="button" class="btn btn-primary btn-sm" id="btn-delete-comment">삭제하기</button>		
			</div>
		</div>
		<hr>
		<div class="row mb-5 md" >
			<div class="col-8 md">
				<p><span>댓글작성자</span>&nbsp;<span>작성시간</span></p>
				<p>안녕하세요. docker와 colima를 이용하여 oracle 을 로컬에서 인식할 수 없다는 에러가 자꾸 발생합니다.
				웹상에 나와있는 많은 해결법들을 시도 해 보았으나 해결되지 않고 있습니다.
				지역 대한민국->미국->대한민국 변경 SQLDeveloper 에 로케일 설정 추가(AddVMOption -Duser.language=ko 
				</p>
			</div>
			<div id="box-commentbtn" class="btn-right col-10">
				<button type="button" class="btn btn-primary btn-sm" id="btn-modify-comment">수정하기</button>		
				<button type="button" class="btn btn-primary btn-sm" id="btn-delete-comment">삭제하기</button>		
			</div>
		</div>
	</div>
</div>

</body>
</html>