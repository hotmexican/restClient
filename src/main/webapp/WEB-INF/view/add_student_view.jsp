<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Student info</h2>
<br>
<form:form action="saveStudent" modelAttribute="student">
    <form:hidden path="id"/>
    Name <form:input path="name"/>
    <br>
    <br>
    Surname <form:input path="surname"/>
    <br>
    <br>
<input type="submit" value="OK">
</form:form>
</body>
</html>