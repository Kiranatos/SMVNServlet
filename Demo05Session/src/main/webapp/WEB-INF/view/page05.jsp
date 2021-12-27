<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Servlets Demo 5 Session</title>
    </head>
    <body>
        <p>Testing Session!</p>
        <br />
        <p><c:out value = "${requestScope.dataForView}"/></p>
        <form method="post" action="">
            <input type="text" name="data" />
            <input type="submit" value="Send" />
        </form>
    </body>
</html>