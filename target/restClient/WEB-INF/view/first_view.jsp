<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<body>
<h2>All Students</h2>
<br>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
    </tr>
    <c:forEach var="stud" items="${allStudents}">
        <tr>
            <td>${stud.name}</td>
            <td>${stud.surname}</td>
        </tr>
    </c:forEach>
</table>
</body>