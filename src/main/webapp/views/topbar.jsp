<%--
  Created by IntelliJ IDEA.
  User: nguyencd
  Date: 2025-09-22
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.username == null}">
        <div class="col-sm-6">
            <ul class="list-inline right-topbar pull-right">
                <li><a href="${pageContext.request.contextPath }/login/session">Đăng nhập</a>
                    | <a href="${pageContext.request.contextPath }/register">Đăng ký</a></li>
                <li><i class="search fa fa-search search-button"></i></li>
            </ul>
        </div>
    </c:when>
    <c:otherwise>
        <div class="col-sm-6">
            <ul class="list-inline right-topbar pull-right">
                <li><a href="${pageContext.request.contextPath}/member/myaccount">${sessionScope.username}</a> | <a
                        href="${pageContext.request.contextPath }/logout">Đăng Xuất</a></li>
                <li><i class="search fa fa-search search-button"></i></li>
            </ul>
        </div>
    </c:otherwise></c:choose>
</body>
</html>
