package com.damu.servlet;

import com.damu.dao.UsersDao;
import com.damu.entity.Users;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
@WebServlet("/updateusers")
public class UsersUpdateServlet extends HttpServlet {

    private UsersDao usersDao = new UsersDao();

    private Logger log = Logger.getLogger(UsersFindByIdServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取用户要更新的数据
        String id = new String((req.getParameter("id")).getBytes("ISO-8859-1"),"UTF-8");
        String nickname = new String((req.getParameter("nickname")).getBytes("ISO-8859-1"),"UTF-8");
        String age = new String((req.getParameter("age")).getBytes("ISO-8859-1"),"UTF-8");
        String gender = new String((req.getParameter("gender")).getBytes("ISO-8859-1"),"UTF-8");
        String email = new String((req.getParameter("email")).getBytes("ISO-8859-1"),"UTF-8");
        String phone = new String((req.getParameter("phone")).getBytes("ISO-8859-1"),"UTF-8");
        String remark = new String((req.getParameter("remark")).getBytes("ISO-8859-1"),"UTF-8");


        // 创建用户对象
        Users user = new Users(Integer.parseInt(id), nickname, Integer.parseInt(age), gender, email, phone, new Date(), remark);
        // 提交更新
        user = usersDao.updateUsers(user);

        // 查看更新后的数据
        resp.sendRedirect("/detail?id=" + user.getId());
    }
}
