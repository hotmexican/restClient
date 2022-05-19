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
        <th>Operations</th>
    </tr>
    <c:forEach var="stud" items="${allStudents}">
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="studentId" value="${stud.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteStudent">
            <c:param name="studentId" value="${stud.id}"/>
        </c:url>
        <tr>
            <td>${stud.name}</td>
            <td>${stud.surname}</td>
            <td>
                <input type="button" value="UPDATE" onclick="window.location.href='${updateButton}'">
                <input type="button" value="DELETE" onclick="window.location.href='${deleteButton}'">
            </td>

        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="ADD" onclick="window.location.href='addNewStudent'"/>
</body>