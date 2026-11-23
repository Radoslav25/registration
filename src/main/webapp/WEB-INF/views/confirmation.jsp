<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>P�meldingsbekreftelse</title>
</head>
<body>
    <h2>Påmeldingsbekreftelse</h2>
    <p>Påmeldingen er mottatt for</p>
    <p>
        <c:out value="${reg.fornavn}"/> <br />
        <c:out value="${reg.etternavn}"/> <br />
        <c:out value="${reg.tel}"/> <br />
        <c:out value="${reg.kjonn}" />
    </p>
    <a href="deltagerliste">Gå til deltagerlisten</a>
</body>
</html>