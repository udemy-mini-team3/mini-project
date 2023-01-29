<%@ page import="com.example.mini.util.SessionConst" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="tag.jsp"%>
<%-- navbar --%>
<c:set var="userDto" value="${sessionScope.get(SessionConst.LOGIN_USER)}" scope="session"/>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/">
            <img src="/img/bae.jpg" alt="Logo" width="35" height="35" class="d-inline-block align-text-top">
            배용남
        </a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">질문답변</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">정보공유</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">이벤트</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <c:choose>
                    <c:when test="${empty userDto}">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="<%=request.getContextPath()%>/login">로그인</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/register">회원가입</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="<%=request.getContextPath()%>/logout">로그아웃</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/myPage">마이페이지</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>