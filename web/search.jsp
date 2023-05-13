

<%@page import="Madm.DanhMucDTO"%>
<%@page import="Madm.DanhMucDAO"%>
<%@page import="java.util.List"%>
<%@page import="Item.ItemDTO"%>
<%@page import="Item.ItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

                <form class="navbar-form navbar-left" action="MainController">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search" name="search">
                    </div>
                    <%DanhMucDAO objectDM = new DanhMucDAO();
                        List<DanhMucDTO> listDM = objectDM.getAll();
                    %>
                    <select name="dm">
                        <option value="">Danh mục</option>
                        <%for (DanhMucDTO p : listDM) {%>
                        <option value="<%=p.getMadm()%>"><%=p.getTendm()%></option>
                        <%}%>
                    </select>
                    <input name="action" type="submit" value="Search" class="btn btn-default"/>
                </form>
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

        <%List<ItemDTO> listItem = (List<ItemDTO>) request.getAttribute("searchList");%>
        <%if (listItem.size() > 0) {%> 
        <table border="1">
            <thead>
                <tr>
                    <th>Tên sp</th>
                    <th>Mô tả</th>
                    <th>Đơn giá</th>
                    <th>Hình Ảnh</th>
                    <th>Xem</th>
                </tr>
            </thead>
            <tbody>
                <%for (ItemDTO p : listItem) {%>
            <form action="MainController" method="get">
                <tr>
                    <td><%=p.getTensp()%></td>
                    <td><%=p.getMota()%></td>
                    <td><%=p.getDongia()%></td>
                    <td><img src="<%=p.getHinhanh()%>"
                             width="100" height="50"></td>
                    <td>
                        <input type="submit" name="action" value="Detail"/>
                        <input type="hidden"name="masp" value="<%=p.getMasp()%>"/>
                    </td>
                </tr>
            </form>
            <%}%>
        </tbody>
    </table>
    <%} else {%>
    <h1>Don't have item</h1>
    <%}%>
    <form action="MainController" method="get">
        <input type="submit" value="AddItem" name="action"/>
    </form>
    ${mess}
</body>
</html>
