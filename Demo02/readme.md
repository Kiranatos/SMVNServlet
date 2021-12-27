SUMMARY & ATTENTION to FILES/CLASSES:
ContextListener, GetIndexPageServlet, AddUserServlet, UpdateUserServlet,
index.jsp, update.jsp, web.xml

Пример работы апдейта:
1) Основная страница: web.xml > / > GetStartPageServlet > class GetIndexPageServlet > index.jsp
2) button update pressed
3) index.jsp > post > /update > UpdateUserServlet > class UpdateUserServlet > doGet() > update.jsp > 
> post > class UpdateUserServlet > doPost() > / > GetStartPageServlet > class GetIndexPageServlet > index.jsp
    