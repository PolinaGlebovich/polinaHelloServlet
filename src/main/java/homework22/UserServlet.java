package homework22;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/MyNewFilter")
public class MyFilter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("name");
        String userPassword = (String) session.getAttribute("password");
        System.out.println("name: " + userName + " " + "password: " + userPassword);

        if(userName.equals("polina")){
            resp.sendRedirect("/here");
            User user = new User();
            user.setUser("polina");
            user.setPassword("12345");

        }

        //
        //
        //        if (currentParam > 102) {
        //            resp.sendRedirect("/here");
        //            Person person = new Person();
        //            person.setName("Polina");
        ////            resp.setStatus(500);
        ////            //resp.sendError(410, "Too much");
        //         }                                               // выбрасывает ошибку
        //    }
    }
}
