<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg,#eef2ff 0%, #f8fafc 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 2rem;
        }
        .auth-card {
            background: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 30px rgba(20,20,50,0.08);
            width: 400px;
        }
        .auth-card h2 {
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
        .switch-link {
            text-align: center;
            margin-top: 15px;
        }
        .switch-link a {
            color: #3498db;
            text-decoration: none;
            font-weight: 500;
        }
        .switch-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="auth-card">
    <h2>Đăng nhập</h2>

    <!-- Alert -->
    <c:if test="${alert != null}">
        <div class="alert">${alert}</div>
    </c:if>

    <form action="/login" method="POST" novalidate id="loginForm">
        <div class="input-group">
            <span><i class="fa fa-user"></i></span>
            <input type="text" name="username" placeholder="Tên đăng nhập" required>
        </div>

        <div class="input-group">
            <span><i class="fa fa-lock"></i></span>
            <input type="password" name="password" placeholder="Mật khẩu" required>
        </div>

        <button type="submit" class="submit-btn">Đăng nhập</button>

        <div class="switch-link">
            Chưa có tài khoản? <a href="/register">Đăng ký</a>
        </div>
    </form>
</div>

<script>
    // Simple client-side validation
    (function() {
        'use strict';
        const form = document.getElementById('loginForm');
        form.addEventListener('submit', function(event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    })();
</script>
</body>
</html>
