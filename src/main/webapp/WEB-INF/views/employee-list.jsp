<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f8f9fa; }
        h2 { color: #333; }
        table { border-collapse: collapse; width: 80%; margin: 20px auto; background: #fff; box-shadow: 0 2px 8px #eee; }
        th, td { padding: 10px 16px; text-align: left; }
        th { background: #007bff; color: #fff; }
        tr:nth-child(even) { background: #f2f2f2; }
        a.button {
            display: inline-block;
            padding: 6px 12px;
            margin: 2px;
            background: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
        }
        a.button:hover { background: #0056b3; }
        .add-btn { margin: 20px auto; display: block; width: 200px; text-align: center; }
    </style>
</head>
<body>
<h2 style="text-align:center">Employee List</h2>
<a href="${pageContext.request.contextPath}/employee/form" class="button add-btn" style="float:right;margin-right:10%;">Add New Employee</a>
<table>
    <tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th><th>Actions</th></tr>
    <c:forEach items="${employees}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <a href="${pageContext.request.contextPath}/employee/edit?id=${emp.id}" class="button">Edit</a>
                <a href="${pageContext.request.contextPath}/employee/delete?id=${emp.id}" class="button" style="background:#dc3545;">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
