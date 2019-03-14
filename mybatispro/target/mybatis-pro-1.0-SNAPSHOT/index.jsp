<%@ page import="java.util.List" %>
<%@ page import="com.damu.entity.Users" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/26
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<html>
<head>
    <title>用户管理中心</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <scrpt src="lib/2.2.4/jquery-1.12.4.js"></scrpt>
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>后台管理系统<small>用户数据管理中心</small></h1>
            </div>
        </div>
        <div class="row">
            <div class="jumbotron">
                <h1>Mybatis基础入门课程</h1>
                <p>通过一个项目来完成基础部分的学习</p>
                <p><a class="btn btn-primary btn-lg" href="#" role="button">查看更多，请百度</a></p>
                <p><a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>/addusers.jsp" role="button">新增用户</a></p>
            </div>
        </div>
        <div class="row">
            <table class="table table-hover table-striped">
                <tr>
                    <th>用户编号</th>
                    <th>登录账号</th>
                    <th>用户昵称</th>
                    <th>用户邮箱</th>
                    <th>联系方式</th>
                    <th>账号创建时间</th>
                    <td>用户状态</td>
                    <td>操作</td>
                </tr>
                <%--<c:forEach var="user" items="${usersList}">--%>
                <% for (Users user : (List<Users>) request.getAttribute("usersList")) {%>
                <tr>
                    <td><%=user.getId()%></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getNickname()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getPhone()%></td>
                    <td><%=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(user.getCreateTime())%></td>
                    <% int a = user.getUserStatus();if (a == 0){%>
                    <td>正常</td>
                    <%}else if (a == 1){%>
                    <td>锁定</td>
                    <%}else if (a == 2){%>
                    <td>删除</td>
                    <%}%>
                    <td>
                        <a href="<%=request.getContextPath()%>/detail?id=<%=user.getId()%>">查看</a>
                        <% if(user.getUserStatus() == 0){%>
                        <a href="<%=request.getContextPath()%>/deluser?id=<%=user.getId()%>&type=lock">锁定</a>
                        <% }else if(user.getUserStatus() == 1){%>
                        <a href="<%=request.getContextPath()%>/deluser?id=<%=user.getId()%>&type=unlock">解锁</a>
                        <% }%>
                        <a href="<%=request.getContextPath()%>/deluser?id=<%=user.getId()%>&type=del">删除</a>
                    </td>
                </tr>
                <%}%>
                <%--</c:forEach>--%>
            </table>
        </div>
    </div>
</body>
</html>
