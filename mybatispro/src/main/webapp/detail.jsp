<%@ page import="com.damu.entity.Users" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="com.damu.entity.Address" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/27
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <p><a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>/index" role="button">返回主页</a></p>
        </div>
    </div>
    <% Users user = (Users) request.getAttribute("user");%>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal" action="<%=request.getContextPath()%>/updateusers">
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户账号</label>
                    <div class="col-sm-10">
                        <p class="form-control-static"><%=user.getName()%></p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">登录密码</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">********</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickname" class="col-sm-2 control-label">昵称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nickname" name="nickname" value="<%=(user.getNickname()==null ? "" : user.getNickname())%>" placeholder="请输入昵称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">年龄</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="age" name="age" value="<%=(user.getAge()==null ? "" : user.getAge())%>" placeholder="请输入年龄">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="gender" name="gender" value="<%=(user.getGender()==null ? "" : user.getGender())%>" placeholder="请输入性别">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">联系方式</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" name="phone" value="<%=(user.getPhone()==null ? "" : user.getPhone())%>" placeholder="请输入联系方式">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" value="<%=(user.getEmail()==null ? "" : user.getEmail())%>" placeholder="请输入邮箱">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">账号创建时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static"><%=(user.getCreateTime() == null ? "--- ---" : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(user.getCreateTime()))%></p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">最后修改时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static"><%=(user.getUpdateTime() == null ? "--- ---" : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(user.getUpdateTime()))%></p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">最后登录时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static"><%=(user.getLastLogin() == null ? "--- ---" : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(user.getLastLogin()))%></p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户状态</label>
                    <div class="col-sm-10">
                        <% if (user.getUserStatus() == 0){%>
                        <p class="form-control-static">正常</p>
                        <% }else if(user.getUserStatus() == 1){%>
                        <p class="form-control-static">锁定</p>
                        <% }else if(user.getUserStatus() == 2){%>
                        <p class="form-control-static">删除</p>
                        <% }%>
                    </div>
                </div>
                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="remark" name="remark" value="<%=(user.getRemark()==null ? "" : user.getRemark())%>" placeholder="请输入备注">
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" value="提交数据更新" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>地址编号</th>
                <th>国家</th>
                <th>省区</th>
                <th>市区</th>
                <th>县区</th>
                <th>街道</th>
                <th>详细地址</th>
                <th>是否默认</th>
            </tr>
            <% for (Address addr : user.getAddresses()) {%>
            <tr>
                <td><%=addr.getId()%></td>
                <td><%=addr.getNation()%></td>
                <td><%=addr.getProvince()%></td>
                <td><%=addr.getCity()%></td>
                <td><%=addr.getCountry()%></td>
                <td><%=addr.getStreet()%></td>
                <td><%=addr.getRemark()%></td>
                <% if(addr.getDefaultAddr() == true) {%>
                <td>默认地址</td>
                <% }else if (addr.getDefaultAddr() == false){%>
                <td>-----</td>
                <%}%>
            </tr>
            <%}%>
        </table>
    </div>
</div>
</body>
</html>
