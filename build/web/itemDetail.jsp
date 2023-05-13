
<%@page import="Item.ItemDTO"%>
<%@page import="Item.ItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin sản phẩm</title>
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

        <%String masp = (String) request.getParameter("masp");
            ItemDAO itemObject = new ItemDAO();
            ItemDTO p = itemObject.detail(masp);%>

        <table border="1">
            <thead>
                <tr>
                    <th>Mã sp</th>
                    <th>Tên sp</th>
                    <th>Mô tả</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Hình Ảnh</th>
                    <th>Trạng thái</th>
                    <th>Mã dm</th>
                    <th>Mã ncc</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <form action="MainController" method="get">
                <tr>
                    <td><%=p.getMasp()%></td>
                    <td><%=p.getTensp()%></td>
                    <td><%=p.getMota()%></td>
                    <td><%=p.getSoluong()%></td>
                    <td><%=p.getDongia()%></td>
                    <td><img src="<%=p.getHinhanh()%>" width="40" height="30"></td>
                    <td><%=p.isTrangthai()%></td>
                    <td><%=p.getMadm()%></td>
                    <td><%=p.getMancc()%></td>
                    <td>
                        <input type="submit" name="action" value="Delete"/>
                        <input type="submit" name="action" value="Update"/>
                        <input type="hidden" name="masp" value="<%=p.getMasp()%>"/>
                    </td>
                </tr>
            </form>
        </tbody>
    </table>
</body>
</html>
