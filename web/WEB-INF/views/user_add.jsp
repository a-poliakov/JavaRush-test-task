<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <spring:form method="post" modelAttribute="user" action="add">
        <spring:hidden path="id"/>
        Name: <spring:input path="name"/><br/>
        Age: <spring:input path="age"/><br/>
        Is Admin? <spring:checkbox path="isAdmin"/>
        <spring:button>OK</spring:button>
    </spring:form>
</body>
</html>
