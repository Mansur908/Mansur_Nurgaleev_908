package servlets;

import models.User;
import services.Helper;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/reg")
public class RegServlet extends HttpServlet {
    private Helper helper;
    private LoginService loginService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        helper.render(req, resp, "registration.ftl",new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean result = loginService.registration(username, password);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Map<String, Object> root = new HashMap<>();
        if(result){
            root.put("message","You are reristered,enter login and password");
            helper.render(req, resp, "login.ftl", root);
        }else{
            root.put("message","You already have account");
            helper.render(req, resp, "login.ftl", root);
        }
    }

    @Override
    public void init() throws ServletException {
        helper = new Helper();
        loginService = new LoginService();
    }
}
