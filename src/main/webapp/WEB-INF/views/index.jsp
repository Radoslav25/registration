<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="css/simple.css" rel="stylesheet" type="text/css" />
    <script src="js/myscript.js" defer></script>
    <title>Påmelding</title>
    
</head>

<body>
    <h2>Påmelding</h2>
    <c:if test="${hasErrors}">
        <p style="color:red;">Påmeldingsdetaljer er ugyldige:</p>
        <ul style="color:red;">
            <c:forEach var="err" items="${errors}">
                <li><c:out value="${err}" /></li>
            </c:forEach>
        </ul>
    </c:if>

      <form name="registrationForm" action="registrasjon" method="post" onsubmit="return validateForm()">
        <label>First Name: <input type="text" name="fornavn" required /></label><br>
        <label>Last Name: <input type="text" name="etternavn" required /></label><br>
        <label>Phone Number: <input type="tel" name="tel" required /></label><br>
        <label>
            Gender:
            <input type="radio" name="kjonn" value="male" <c:if test="${reg.kjonn == 'male'}">checked</c:if> required /> Male
            <input type="radio" name="kjonn" value="female" <c:if test="${reg.kjonn == 'female'}">checked</c:if> required /> Female
        </label><br>
        <label>Password: <input type="password" name="passord" required /></label><br>
        <label>Repeat Password: <input type="password" name="repetertPassord" required /></label><br>
        <button type="submit">Register</button>
    </form>
    

</body>
</html>