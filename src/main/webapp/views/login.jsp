<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<c:if test="${alert !=null}">
    <h3 class="alert alertdanger">${alert}</h3>
</c:if>
<form action="/login" method="POST">
    Username: <input type="text" name="Username"> <br/>
    Password: <input type="password" name="Password"/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>