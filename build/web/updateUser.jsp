
<%@page import="User.UserDTO"%>
<%@page import="User.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thay đổi thông tin cá nhân</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-light" style="background-color: yellow;">

            <div class="container-fluid">

                <div class="navbar-header">
                    <a class="navbar-brand" href="MainController?action=main">Cửa hàng Mỹ phẩm</a>
                </div>

                <ul class="nav navbar-nav">
                    <li class="active"><a href="MainController?action=viewItem">Danh sách sản phẩm</a></li>
                    <li><a href="MainController?action=danhmuc">Danh mục</a></li>
                    <li><a href="MainController?action=user">Tài khoản</a></li>
                </ul>
                <%String url = "login.html";
                    String action = "Login";
                    if (request.getSession().getAttribute("username") != null) {
                        action = "Logout";
                        url = "MainController?action=Logout";
                    }
                %>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="register.html"><span class="glyphicon glyphicon-user"></span>Tạo tài khoản mới</a></li>
                    <li><a href="<%=url%>"><span class="glyphicon glyphicon-log-in"></span> <%=action%></a></li>
                </ul>
            </div>
        </nav>
        <%String username = request.getParameter("username");
            if (request.getSession().getAttribute("username").equals(username)) {%>

        <h1>Thay đổi thông tin cá nhân</h1>
        <% 
            UserDAO objectUser = new UserDAO();
            UserDTO loginUser = objectUser.findUser(username);
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Tên tài khoản</th>
                    <th>Mật khẩu</th>
                    <th>Trạng thái</th>
                    <th>email</th>
                    <th>nhóm tài khoản</th>
                </tr>
            </thead>
            <tbody>
            <form action="MainController" method="get">
                <tr>
                    <td><%=loginUser.getUsername()%></td>
                    <td><%=loginUser.getPassword()%></td>
                    <td><%=loginUser.isActive()%></td>
                    <td><%=loginUser.getEmail()%></td>
                    <td><%=loginUser.getGroupUser()%></td>
                </tr>
            </form>
        </tbody>
    </table>
    <form action="MainController" method="post">
        Mật khẩu :          <input name="txtpsw" type="text"/> <br/>
        Email :                <input name="txtemail" type="text"/> <br/>
        Nhóm tài khoản : <input name="txtgroupuser" type="text"/> <br/>
        <input name="action" type="submit" value="UpdateUser_Confirm"/>
    </form>
    <%} else {
            request.setAttribute("mess", "Bạn không thể sửa thông tin người khác");
            request.getRequestDispatcher("user.jsp").forward(request, response);
        }%>
</body>
</html>
