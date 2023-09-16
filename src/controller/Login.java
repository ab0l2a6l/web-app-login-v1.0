package controller;

import domain.Users;
import service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Users user = UsersService.getInstance().login(req.getParameter("username"),req.getParameter("password"));
            req.getSession().setAttribute("user" , user);
            System.out.println(user.getRoleName());
            resp.sendRedirect("/"+user.getRoleName()+"/index.jsp");
        }catch (Exception e){
            resp.sendRedirect("/index.jsp");
        }
    }

}
