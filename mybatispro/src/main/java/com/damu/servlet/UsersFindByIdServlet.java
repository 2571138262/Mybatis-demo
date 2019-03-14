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

@WebServlet("/detail")
public class UsersFindByIdServlet extends HttpServlet {

    /*
    创建对应的日志记录对象
    通过不同的级别进行日志的记录【DEBUG \ WARNING \ INFO \ LOG】
     */
    private Logger log = Logger.getLogger(UsersFindByIdServlet.class);

    private UsersDao usersDao = new UsersDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        log.info("获取到查询参数id--》" + id);

        Users user = usersDao.findById(Integer.parseInt(id));

//        log.debug("查询数据完成，查询到的数据----debug：" + user);
//        log.warn("查询数据完成，查询到的数据----warn：" + user);
        log.info("查询数据完成，查询到的数据----info：" + user);


        request.setAttribute("user", user);

        request.getRequestDispatcher("detail.jsp").forward(request, response);
    }
}
