<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Svetlana
  Date: 11.12.2021
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Группы университета </h2>
<table border="1">
<tr>
    <th>Номер(название)</th>
    <th>Кол-во студентов</th>
    <th>Действия</th>
</tr>
<c:forEach var="group" items="${allGroups}">
    <tr>
        <td>${group.groupName}</td>
        <td>${group.students.size()}</td>
        <td><a href="/group/showGroup?groupName=${group.groupName}">Редактировать</a></td>
    </tr>

</c:forEach>
</table>
<br>
<form action="/university/showGroups" method="get">
    <input type="text" name="newGroupName" placeholder="Введите название группы">
    <br>
    <input type="submit" name="Добавить группу">
</form>

</body>
</html>
