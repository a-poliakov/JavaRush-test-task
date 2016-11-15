<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Hello Page</title>
</head>
<body>
<h1>Our users list.</h1>

<p>
    <a href="<s:url value="/addUser"/>">Добавить нового пользователя</a>
</p>

<spring:form  method="get" modelAttribute="searchText" action="">
    Поиск: <input name="name" class="form-control" placeholder="Введите имя пользователя"/><button type="submit" class="btn btn-success">Найти</button>
</spring:form>

<table class="block">
    <tr class="pagination">
        <th><a href="<c:url value='/?pageNumber=0'/>" aria-label="First"><span aria-hidden="true">&laquo;</span></a></th>
        <c:forEach items="${pagination}" var="page">
            <c:choose>
                <c:when test="${page == currentPage}"><th class="active"><a href="http://localhost:8080/?pageNumber=<c:out value="${page} "/>"> <c:out value="${page} "/><span class="sr-only">(current)</span></a></th></c:when>
                <c:when test="${page != currentPage}"><th><a href="<s:url value="/?pageNumber=${page}"/>"> <c:out value="${page} "/></a></th></c:when>
            </c:choose>
        </c:forEach>
        <th><a href="http://localhost:8080/?pageNumber=<c:out value="${countOFPages} "/>" aria-label="Last"><span aria-hidden="true">&raquo;</span></a></th>
    </tr>
</table>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Is Admin</th>
        <th>Created Date</th>
        <th>Tools</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id} "/></td>
            <td><c:out value="${user.name} "/></td>
            <td><c:out value="${user.age} "/></td>
            <td><c:out value="${user.isAdmin} "/></td>
            <td><c:out value="${user.createdDate} "/></td>
            <td>
                <a href="<s:url value="/remove?id=${user.id}"/>">Удалить </a>
                <a href="<s:url value="/add?id=${user.id}"/>">Изменить </a>
            </td>
        </tr>
    </c:forEach>
</table>
<table class="block">
    <tr class="pagination">
        <th><a href="<c:url value='/?pageNumber=0'/>" aria-label="First"><span aria-hidden="true">&laquo;</span></a></th>
        <c:forEach items="${pagination}" var="page">
            <c:choose>
                <c:when test="${page == currentPage}"><th class="active"><a href="http://localhost:8080/?pageNumber=<c:out value="${page} "/>"> <c:out value="${page} "/><span class="sr-only">(current)</span></a></th></c:when>
                <c:when test="${page != currentPage}"><th><a href="<s:url value="/?pageNumber=${page}"/>"> <c:out value="${page} "/></a></th></c:when>
            </c:choose>
        </c:forEach>
        <th><a href="http://localhost:8080/?pageNumber=<c:out value="${countOFPages} "/>" aria-label="Last"><span aria-hidden="true">&raquo;</span></a></th>
    </tr>
</table>

</body>
</html>
