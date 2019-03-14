package com.damu.servlet;

import com.damu.dao.UsersDao;
import com.damu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addusers")
public class UsersAddServlet extends HttpServlet {

    private UsersDao usersDao = new UsersDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要添加的数据
        String username = new String((req.getParameter("username")).getBytes("ISO-8859-1"),"UTF-8");
        String userpass = new String((req.getParameter("userpass")).getBytes("ISO-8859-1"),"UTF-8");
        String nicaname = new String((req.getParameter("nickname")).getBytes("ISO-8859-1"),"UTF-8");
        String age = new String((req.getParameter("age")).getBytes("ISO-8859-1"),"UTF-8");
        String gender = new String((req.getParameter("gender")).getBytes("ISO-8859-1"),"UTF-8");
        String email = new String((req.getParameter("email")).getBytes("ISO-8859-1"),"UTF-8");
        String phone = new String((req.getParameter("phone")).getBytes("ISO-8859-1"),"UTF-8");

        // 根据用户数据创建一个用户对象
        Users user = new Users(username, userpass, nicaname, Integer.parseInt(age), gender, email, phone, new Date(), new Date(), new Date(), 0);

        // 将用户对象添加到数据库中
        user = usersDao.addUser(user);

        // 查看刚新增的用户数据
        resp.sendRedirect("/detail?id=" + user.getId());
    }
}
