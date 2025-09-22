<%--
  Created by IntelliJ IDEA.
  User: nguyencd
  Date: 2025-09-22
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            display: flex;
            min-height: 100vh;
        }

        .sidebar {
            width: 250px;
            background-color: #2196F3;
            color: #fff;
            padding: 20px;
        }

        .sidebar a {
            color: #fff;
            display: block;
            padding: 10px;
            margin: 5px 0;
            text-decoration: none;
        }

        .sidebar a.active, .sidebar a:hover {
            background-color: #E91E63;
            border-radius: 5px;
        }

        .content {
            flex-grow: 1;
            background-color: #f5f5f5;
            padding: 20px;
        }

        .topbar {
            display: flex;
            justify-content: flex-end;
            align-items: center;
            padding: 10px;
            background-color: #2196F3;
            color: #fff;
        }

        .table img {
            width: 60px;
            height: 60px;
            border-radius: 50%;
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <div class="text-center mb-3">
        <img src="avatar.png" class="img-fluid rounded-circle" width="120" alt="Admin">
        <p>Bạn là Admin</p>
    </div>
    <a href="dashboard.jsp" class="active">Dashboard</a>
    <a href="#">Quản lý Danh mục</a>
    <a href="<c:url value='/admin/category/add'/>">Thêm danh mục mới</a>
    <a href="<c:url value='/admin/category/list'/>">Danh sách danh mục</a>
    <a href="#">Quản lý sản phẩm</a>
    <a href="#">Quản lý tài khoản</a>
</div>

<div class="content">
    <!-- Topbar -->
    <div class="topbar">
        <span>Xin chào, <c:out value="${sessionScope.user.fullname}"/></span>
        <a href="logout" class="btn btn-danger btn-sm ms-3">Đăng xuất</a>
    </div>

    <!-- Main Content -->
    <h2 class="text-danger mt-3">Quản lý danh mục</h2>
    <p>Nơi bạn có thể quản lý danh mục của mình</p>

    <table class="table table-bordered table-hover bg-white">
        <thead>
        <tr>
            <th>STT</th>
            <th>Hình ảnh</th>
            <th>Tên danh mục</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cateList}" var="cate" varStatus="STT">
            <tr class="odd gradeX">
                <td>${STT.index+1 }</td>
                <c:url value="/image?fname=${cate.icon}" var="imgUrl"></c:url>
                <td><img height="150" width="200" src="${imgUrl}"/></td>
                <td>${cate.name }</td>
                <td>
                    <a href="<c:url value='/admin/category/edit?id=${cate.id}'/>" class="center">Sửa</a>|
                    <a href="<c:url value='/admin/category/delete?id=${cate.id}'/>" class="center">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
