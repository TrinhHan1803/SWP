
<%@page import="Madm.DanhMucDTO"%>
<%@page import="java.util.List"%>
<%@page import="Madm.DanhMucDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách danh mục</title>
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

        <h1>Danh sách danh mục</h1>
        <%DanhMucDAO objectDM = new DanhMucDAO();
            List<DanhMucDTO> listDanhMuc = objectDM.getAll();
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>Tên danh mục</th>
                </tr>
            </thead>
            <tbody>
                <%for (DanhMucDTO p : listDanhMuc) {%>
            <form action="MainController" method="get">
                <tr>
                    <td><%=p.getTendm()%></td>
                    <td>
                        <input type="submit" value="ChiTietDm" name="action"/>
                        <input type="hidden" value="<%=p.getMadm()%>" name="madm"/>
                    </td>
                </tr>
            </form>
            <%}%>
        </tbody>
        ${mess}
    </table>
    <form action="MainController" method="get">
        <input type="submit"  value="AddDM" name="action"/>
    </form>

</body>
</html>
