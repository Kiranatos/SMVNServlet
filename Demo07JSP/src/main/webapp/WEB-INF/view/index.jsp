<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head><title>JSP/JSTL Summary</title></head>
    <body>        
        <div>При использовании "out" контекст указывается в формате requestScope.yourObj"</div>
        <c:out value="${requestScope.simpleOutput.text}"/> <%-- like System.out.println        
         - JSP tags start with <c:
         - requestScope - always exist. Also possible to use "sessionScope"
         - simpleOutput - my key, setted in method .doGet()
         - text - it is method .getText()  --%>
        <hr />

        <div>При использовании "set" контекст указывается в формате scope="request"</div>
        <c:set var="myOperations" scope="request" value="${keyOperations}" />
        <%-- 
         - <c:set var="myOperations" - создание переменной myOperations.
         - scope="request" or "session" аналогично ${requestScope - для получения данных
         - keyOperations - my key, setted in method .doGet()
        --%>
        <hr />

        <h2>Пример использования цикла:</h2>
        <c:forEach items="${myOperations}" var="my2Oper">
            <c:out value="${my2Oper}"/><br /> <!-- described above / System.out.println --->
        </c:forEach>
        <%-- цыкл используюющий переменную myOperations созданную выше
         - my2Oper - переменнная создана для итерации
        --%>
        <hr />


        <h2>Пример использования условного оператора:</h2>
        <c:if test="${requestScope.myCondition eq true}">
            <div>Сработал условный оператор (eq,ne,lt,qt,le,ge).</div>
            <div>myCondition - my key, setted in method .doGet()</div>            
        </c:if>
    </body>
</html>