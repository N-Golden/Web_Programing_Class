<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .register-form {
            background: #fff;
            padding: 30px 40px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        .register-form h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .alert {
            color: #fff;
            background-color: #e74c3c;
            padding: 10px;
            border-radius: 5px;
            text-align: center;
            margin-bottom: 15px;
        }

        .input-group {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }

        .input-group span {
            background: #eee;
            padding: 10px;
            border: 1px solid #ccc;
            border-right: none;
            border-radius: 5px 0 0 5px;
        }

        .input-group input {
            flex: 1;
            padding: 10px;
            border: 1px solid #ccc;
            border-left: none;
            border-radius: 0 5px 5px 0;
        }

        .input-group input:focus {
            outline: none;
            border-color: #3498db;
        }

        .submit-btn {
            width: 100%;
            padding: 12px;
            background: #3498db;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }

        .submit-btn:hover {
            background: #2980b9;
        }
    </style>
</head>
<body>
<form action="register" method="post" class="register-form">
    <h2>Register</h2>

    <c:if test="${alert != null}">
        <div class="alert">${alert}</div>
    </c:if>

    <div class="input-group">
        <span><i class="fa fa-user"></i></span>
        <input type="text" placeholder="Fullname" name="fullname" required>
    </div>
    <div class="input-group">
        <span><i class="fa fa-envelope"></i></span>
        <input type="email" placeholder="Email" name="email" required>
    </div>
    <div class="input-group">
        <span><i class="fa fa-phone"></i></span>
        <input type="text" placeholder="Phone" name="phone">
    </div>

    <div class="input-group">
        <span><i class="fa fa-user"></i></span>
        <input type="text" placeholder="Username" name="username" required>
    </div>
    <div class="input-group">
        <span><i class="fa fa-lock"></i></span>
        <input type="password" placeholder="Password" name="password" required>
    </div>
<%--    <div class="input-group">--%>
<%--        <span><i class="fa fa-lock"></i></span>--%>
<%--        <input type="password" placeholder="Nhập lại password" name="confirmPassword" required>--%>
<%--    </div>--%>

    <button type="submit" class="submit-btn">Tạo tài khoản</button>

    <!-- Link chuyển sang login -->
    <div class="switch-link">
        Đã có tài khoản? <a href="/login">Đăng nhập</a>
    </div>
</form>
</body>
</html>
