<%--
  Created by IntelliJ IDEA.
  User: nguyencd
  Date: 2025-09-22
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa danh mục</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="p-4">

<div class="card">
    <div class="card-header bg-light">
        <h5 class="mb-0">Chỉnh sửa danh mục</h5>
    </div>
    <div class="card-body">
        <form action="${edit}" method="post" enctype="multipart/form-data">

            <!-- Hidden cate_id -->
            <input type="hidden" name="cate_id" value="${category.id}"/>

            <div class="mb-3">
                <label class="form-label">Tên danh sách:</label>
                <input type="text" class="form-control" name="name" value="${category.name}" required>
            </div>

            <div class="mb-3">
                <img class="img-responsive" width="100px" src="${category.icon}" alt="">
                <label>Ảnh đại diện</label>
                <input type="file" class="form-control" name="icon" value="${category.icon}"/>
            </div>

            <div class="d-flex gap-2">
                <input type="submit" class="btn btn-primary" value="Sửa">
<%--                <button class="btn btn-secondary">Làm mới</button>--%>
            </div>
        </form>
    </div>
</div>
</body>
</html>
