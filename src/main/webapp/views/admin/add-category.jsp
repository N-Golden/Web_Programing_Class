<%--
  Created by IntelliJ IDEA.
  User: nguyencd
  Date: 2025-09-22
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<div class="card">
    <div class="card-header bg-light">
        <h5 class="mb-0">Thêm danh mục</h5>
    </div>
    <div class="card-body">
        <form action="${add}" method="post" enctype="multipart/form-data">

            <div class="mb-3">
                <label class="form-label">Tên danh sách:</label>
                <input type="text" class="form-control" name="name" value="${category.name}" required>
            </div>

            <div class="mb-3">
                <img class="img-responsive" width="100px" src="${imgUrl}"
                     alt="">
                <label>Ảnh đại diện</label> <input type="file" name="icon"
                                                   value="${category.icon}" />
            </div>

            <div class="d-flex gap-2">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>

        </form>
    </div>
</div>
</body>
</html>
