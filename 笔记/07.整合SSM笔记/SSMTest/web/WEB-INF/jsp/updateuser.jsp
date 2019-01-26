<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modify Page</title>
</head>
<body>
<h4>Modify Page</h4>
<form action="updateuser" method="post">
    <table>
        <tr>
            <td><label>id:</label></td>
            <td><input type="text" id="id" name="id" value="${user_id}" readonly="readonly"/>
        </tr>
        <tr>
            <td><label>username:</label></td>
            <td><input type="text" id="username" name="username" />
        </tr>
        <tr>
            <td><label>password:</label></td>
            <td><input type="password" id="password" name="password" />
        </tr>
        <tr>
            <td><label>sex:</label></td>
            <td><input type="text" id="sex" name="sex" />
        </tr>
        <tr>
            <td><label>age:</label></td>
            <td><input type="text" id="age" name="age" />
        </tr>
        <tr>
            <td><input type="submit" value="modify" />
        </tr>
    </table>
</form>
</body>
</html>
