Servlet Summary

Объязательные структуры папок:
src/main/java/net/kiranatos/servlet - классы-сервлеты
src/main/webapp/WEB-INF/web.xml - deployment descriptor (DD) дескриптор развёртывания

веб-сервер - только принимает запросы (в основном тестовые)
сервер веб-приложений - принимает, парсит работает и обрабатывает запросы (могут быть уже в виде объектов)

Demo03JSON: зависимость url-ов из-за которых могут возникнуть траблы:
context.xml /Demo03 - начальный url, он же отображается в браузере
web.xml /json - а в браузере как /Demo03/json
в json_example.jsp пришлось писать тоже /Demo03/json, вместо /json

Demo05Session - пример работы с сесией, но ютубер хреново объясняет, поэтому тема не слиишком расскрыта
task: вернутся и дополнить, когда рассмотрю остальные курсы и книги

INTELEJI:
Preferences>Application Server
Java Vision (1st video - server configuaration in IDE)

1) YouTubeChannel: Java Vision https://www.youtube.com/channel/UChs3Aql8iq3MD1UD303_bMg
playlist: Сервлеты(Servlets) (10 video) https://www.youtube.com/playlist?list=PL7Bt6mWpiizZq71c4wuBl7lmY-M7nen_J
Pavel Ravvich https://github.com/PavelRavvich/servlet-tutorial

1) YouTubeChannel: letsCode https://www.youtube.com/c/letsCodeDru
playlist: Servlets (5 video) https://www.youtube.com/playlist?list=PLU2ftbIeotGoQGD51e0qb98lE0xhgNDF1

1) что такое сервлет контейнер и жизненый цикл сервлетов?

(пример использвания в классе AddUserServlet. Подумать - возможно добавить этот вопрос в проект HRTrainer)
из телеграмма какой-то новостной паблик:
Чем отличается sendRedirect() от forward()?
forward():
☕️ Выполняется на стороне сервера;
☕️ Запрос перенаправляется на другой ресурс в пределах того же сервера;
☕️ Не зависит от протокола клиентского запроса, так как обеспечивается контейнером сервлетов;
☕️ Нельзя применять для внедрения сервлета в другой контекст;
☕️ Клиент не знает о фактически обрабатываемом ресурсе и URL в строке остается прежним;
☕️ Выполняется быстрее метода sendRedirect();
☕️ Определён в интерфейсе RequestDispatcher.

sendRedirect():
☕️ Выполняется на стороне клиента;
☕️ Клиенту возвращается ответ 302 (redirect) и запрос перенаправляется на другой сервер;
☕️ Может использоваться только с клиентами HTTP;
☕️ Разрешается применять для внедрения сервлета в другой контекст;
☕️ URL адрес изменяется на адрес нового ресурса;
☕️ Медленнее forward() т.к. требует создания нового запроса;
☕️ Определён в интерфейсе HttpServletResponse.

JSP / JSTL
https://www.javatpoint.com/jstl
https://ru.bmstu.wiki/JSTL_(JavaServer_Pages_Standard_Tag_Library)

Demo01Simple: simple servlet: add name & age;
Demo02:

из Видео в СофтСерве:
скрыплеты
<% %>
56:04 импорты классов в жсп