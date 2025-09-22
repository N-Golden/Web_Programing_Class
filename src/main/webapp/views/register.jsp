<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
>

<form action="register" method="post">
    <h2>Register</h2>
    <c:if test="${alert !=null}">
    <h3 class="alert alertdanger">${alert}</h3>
    </c:if>
    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Username" name="username"
                       class="form-control">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Fullname" name="fullname"
                       class="form-control">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Email" name="email"
                       class="form-control">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Phone" name="phone"
                       class="form-control">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="password" placeholder="Password" name="password"
                       class="form-control">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                <input type="text" placeholder="Type password again" name=""
                       class="form-control">
            </div>
        </label>
    </section>
    <input type="submit" value="Create Account"/>
</form>
</html>
