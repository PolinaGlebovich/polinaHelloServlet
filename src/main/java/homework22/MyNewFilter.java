package homework22;

import jakarta.servlet.*;

import java.io.IOException;
//Создать защищенную страницу, попасть на которую можно только после логина
//Все запросы к защищенной странице должны приводить к перенаправлению на страницу логина,
// если пользователь еще не залогинен, а если залогинен – должны всегда быть успешными.
// Что для этого нужно — у вас должен сервлет (допустим LoginServlet), который будет считывать данные передаваемые как параметры
// (/abc?login=Pasha&password=123 – это пример) , проверять с установленным значением имени и пароля
// (например как context param), и если они совпадают — добавлять имя юзера в сессию как аттрибут.
// Далее необходимо создать еще две страницы — например error.html и success.html и фильтр, привязанный к странице success.html.
// На страницу ошибки будет выбрасывать с фильтра , если в сессии не будет атрибута с именем юзера. Так как фильтр будет привязан к странице,
// то если человек попробует сразу зайти на страницу success.html, то его отправит на страницу ошибки.
//
//Дополнительное задание
//2. Создать сервлет для вывода всех студентов группы. Информация о
//студентах должна храниться в базе данных.
//3. Создать сервлет для вывода количества посещений страницы.
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
    }
    @Override
    public void destroy() {
        System.out.println("destroy servlet");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.getWriter().write("before");
        if(true) {
            filterChain.doFilter(servletRequest, servletResponse);  // мы получаем наш запрос
        }
        servletResponse.getWriter().write("after");
    }
}
