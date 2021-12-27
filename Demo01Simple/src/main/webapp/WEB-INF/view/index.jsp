<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>Hello from Java Vision!</h1><br />
        <h2>Все пользователи</h2><br />
        <!-- сама страница отображается методом get. Ключ-значение из метода doGet [s01]
        Объект requestScope существует по умолчанию всегда. -->
        <c:forEach var="user" items="${requestScope.users}"> <!-- типо цыкла for (var user : users){}
                                        requestScope.ключ
        Переменная items получит значение AarrayList users.            -->
            <ul>
                <li>Имя: <c:out value="${user.name}"/></li> <!-- метод getName() класса User => .name это происходит благодаря библиотекам jstl и taglibs в мавен -->
                <li>Возраст: <c:out value="${user.age}"/></li> <!-- метод getAge() класса User => .age -->
            </ul>
            <hr />
        </c:forEach>
            
        <h2>Создание нового пользователя</h2><br />
        <form method="post" action=""> <!-- action="" соотвествует '/' в web.xml 
            данные отправляются методом post            -->
            <label><input type="text" name="name"></label>Имя<br>
            <label><input type="number" name="age"></label>Возраст<br>
            <input type="submit" value="Ok" name="Ok"><br>
        </form>
    </body>
</html>
