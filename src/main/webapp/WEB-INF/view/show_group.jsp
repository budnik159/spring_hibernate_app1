<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Svetlana
  Date: 05.12.2021
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Информация о группе ${universityGroupName}</h2>
<table border="1">
    <tr>
        <th>Дата принятия</th>
        <th>ФИО студента</th>
        <th>Действия</th>
    </tr>
  <%--  <tr>
        <td>${student.receiptDate}</td>
        <td>${student.surname}</td>
        <td>${student.name}</td>
    </tr>--%>

    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.receiptDate}</td>
            <td>${student.surname} ${student.name}</td>
            <td><a href="/group/showGroup?groupName=${universityGroupName}&studentId=${student.id}">Delete</a></td>
        </tr>
    </c:forEach>

</table>
<br>
<form action="/group/showGroup" method="get">
    <input type="text" name="newStudentSurnameAndName" placeholder="Фамилия Имя">
    <input type="hidden" name="groupName" value="${universityGroupName}">
    <br>
    <input type="submit" name="Добавить студента">
</form>


</body>
</html>
