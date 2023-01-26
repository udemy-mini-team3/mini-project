<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Home</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <%@ include file="../common/tag.jsp"%>
    <style>
        .b{
            border: solid 1px black;
        }
    </style>
    <script src="js/jquery-3.6.1.min.js"></script>
    <script>
        function sort() {
            $.ajax({
                url : '/boardlist/sorted/' + $("#selectbox option:selected").val(),
                type : 'get',
                dataType : 'json',
                success : function(data) { // 자바 배열 List == 자바스크립트 배열
                    $("#ajaxtbody").html(''); // 빈값 할당
                    for (var i = 0; i < data.length; i++) {
                        $("#ajaxtbody").append("<tr><td>"+data[i].boardSeq+"</td><td>"+data[i].title+"</td><td>"+data[i].content+"</td><td>"+data[i].nickname+"</td><td>"+data[i].insertDate+"</td><td>"+data[i].viewcount+"</td></tr>");
                    }
                },
                error : function(request, status, error) {
                    alert("code:"+request.status+"\n"
                        +"message:"+request.responseText+"\n"
                        +"error:"+error);
                }
            }); // ajax
        }
        $(document).ready(function(){

        });
    </script>
</head>
<body>

<%@ include file="../common/nav.jsp"%>

<div class="container">
    <div class="container text-center">
        <div class="row">
            <div class="col">
                <button type="button" class="btn btn-outline-secondary" onclick="location.href='writeboard'">글 작성</button>
            </div>
            <div class="col-6">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="검색어를 입력하세요" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
                </div>
            </div>
            <div class="col">
                <select class="form-select" aria-label="Default select example" onchange="sort()" id="selectbox">
                    <option selected value="0">정렬</option>
                    <option value="1">최신순</option>
                    <option value="2">오래된순</option>
                    <option value="3">조회수</option>
                </select>
            </div>
        </div>
    </div>
</div>

<br>

<%-- 테이블 --%>
<%-- class="table"을 적어야 bootstrap 스타일이 적용됨 --%>
<div class="container">
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">제목</th>
            <th scope="col">내용</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
            <th scope="col">조회수</th>
        </tr>
        </thead>
        <tbody id="ajaxtbody">
        <c:forEach items="${boardList }" var="board">
        <tr onclick="location.href='getboard?seq=${board.boardSeq}'" id="ajaxtr">
            <th scope="row">${board.boardSeq}</th>
            <td>${board.title}</td>
            <td>${board.content}</td>
            <td>${board.nickname}</td>
            <td>${board.insertDate}</td>
            <%--<fmt:parseDate value="${board.insertDate}" var="convertedDate" pattern="yyyy-MM-dd HH:mm:ss"/>
            <td><fmt:formatDate value="${convertedDate}" pattern="yyyy-MM-dd"/></td>--%>
            <td>${board.viewcount}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<br>

<%-- button group --%>
<div class="container text-center">
    <div class="row justify-content-md-center">
        <div class="col col-lg-2">
        </div>
        <div class="col-md-auto">
            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group me-2" role="group" aria-label="First group">
                    <% int pageCount = (Integer)request.getAttribute("pageCount");
                        for (int i = 1; i <= pageCount; i++) {
                    %>
                        <button type="button" class="btn btn-primary" onclick="location.href='boardlist?page=<%=i%>'"><%=i%></button>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
        <div class="col col-lg-2">
        </div>

    </div>
</div>
<%-- end of button group --%>

<br>

<script src="js/bootstrap.min.js"></script>
</body>
</html>