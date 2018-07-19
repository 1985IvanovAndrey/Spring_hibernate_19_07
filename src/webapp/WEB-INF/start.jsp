<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Dron
  Date: 19.07.2018
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../index.jsp">Back to main menu</a>
<br/>
<br/>

<h1>Book List</h1>

<c:if test="${!empty studentList}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Phone</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td>${student.idStud}</td>
                <td><a href="/studentdata/${student.idStud}" target="_blank">${student.nameStud}</a></td>
                <td>${student.phoneStud}</td>
                <td><a href="<c:url value='/edit/${student.idStud}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${student.idStud}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<h1>Add a Student</h1>

<c:url var="addAction" value="/start/add"/>

<form:form action="${addAction}" commandName="student">
    <table>
        <c:if test="${!empty student.nameStud}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idStud" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="idStud"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="nameStud">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameStud"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="phoneStud">
                    <spring:message text="Phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="phoneStud"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty student.nameStud}">
                    <input type="submit"
                           value="<spring:message text="Edit Students"/>"/>
                </c:if>
                <c:if test="${empty student.nameStud}">
                    <input type="submit" value="<spring:message text="Add Student"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>