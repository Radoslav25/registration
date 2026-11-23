<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="no.hvl.dat108.f11.Participant" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Deltagerliste</title>
</head>
<body>
    <h2>Deltagerliste</h2>
    <table>
        <tr>
            <th>Kjønn</th>
            <th align="left">Navn</th>
            <th align="left">Mobil</th>
        </tr>

        <c:forEach var="participant" items="${participants}">
            <tr>
                <td align="center"><c:choose>
                    <c:when test="${participant.gender == 'male'}">&#9794;</c:when>
                    <c:otherwise>&#9792;</c:otherwise>
                </c:choose></td>
                <td><c:out value="${participant.firstName} ${participant.lastName}"/></td>
                <td><c:out value="${participant.mobile}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>