package servlets;

import models.User;
import services.Helper;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Helper helper;
    private LoginService loginService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        helper.render(req, resp, "login.ftl",new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String reg = req.getParameter("reg");
        boolean result = loginService.login(username, password);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> root = new HashMap<>();

            if (reg != null) {
                helper.render(req, resp, "registration.ftl", root);
            }
            else {
                if(result){
                    root.put("name", username);
                    HttpSession session = req.getSession();
                    session.setAttribute("user",username);
                    req.getServletContext().getRequestDispatcher("/profile").forward(req,resp);
                    // исправить,добавить root
                }
                else{
                    root.put("message","incorrect password");
                    helper.render(req, resp, "login.ftl", root);
                }
            }
        }

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        loginService = new LoginService();
    }

}
