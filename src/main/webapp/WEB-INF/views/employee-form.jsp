<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Form</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f8f9fa; }
        h2 { color: #333; }
        form { width: 300px; margin: 20px auto; padding: 20px; background: #fff; box-shadow: 0 2px 8px #eee; }
        input[type="text"] { width: 100%; padding: 8px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px; }
        input[type="submit"] { background: #007bff; color: #fff; border: none; padding: 10px 15px; border-radius: 4px; cursor: pointer; }
        input[type="submit"]:hover { background: #0056b3; }
    </style>
</head>
<body>
<h2>Employee Form</h2>
<form action="${pageContext.request.contextPath}/employee/save" method="post">
    <input type="hidden" name="id" value="${employee.id}"/>
    Name: <input type="text" name="name" value="${employee.name}"/><br/>
    Department: <input type="text" name="department" value="${employee.department}"/><br/>
    Salary: <input type="text" name="salary" value="${employee.salary}"/><br/>
    <input type="submit" value="Save"/>
</form>
<br/>
<a href="${pageContext.request.contextPath}/employees">Back to Employee List</a>
</body></html>
