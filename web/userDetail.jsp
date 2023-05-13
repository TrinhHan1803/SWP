<%@page import="User.UserDAO"%>
<%@page import="User.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin cá nhân</title>
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

        <%String username = request.getParameter("userName");
            UserDAO objectUser = new UserDAO();
        %>

        <h1>Thông tin người dùng</h1>
        <%UserDTO loginUser = objectUser.findUser(username);%>
        <table border="1">
            <thead>
                <tr>
                    <th>Tên tài khoản</th>
                    <th>Mật khẩu</th>
                    <th>Trạng thái</th>
                    <th>email</th>
                    <th>nhóm tài khoản</th>
                    <th>Action</th>
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
                    <td>
                        <input name="action" value="UpdateUser" type="submit"/>
                        <input name="action" value="DeleteUser" type="submit"/>
                        <input type="hidden" name="username" value="<%=loginUser.getUsername()%>"/>
                    </td>
                </tr>
            </form>
        </tbody>
    </table>

</body>
</html>
