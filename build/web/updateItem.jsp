
<%@page import="Madm.DanhMucDTO"%>
<%@page import="java.util.List"%>
<%@page import="Madm.DanhMucDAO"%>
<%@page import="Item.ItemDTO"%>
<%@page import="Item.ItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update sản phẩm</title>
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
            ItemDAO objectItem = new ItemDAO();
            ItemDTO item = objectItem.detail(masp);
        %>
        <h4>Thông tin sản phẩm</h4>
        <table border="1">
            <thead>
                <tr>
                    <th>Mã sp</th>
                    <th>Tên sp</th>
                    <th>Mô tả</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Hình Ảnh</th>
                    <th>Mã danh mục</th>
                    <th>Mã ncc</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=item.getMasp()%></td>
                    <td><%=item.getTensp()%></td>
                    <td><%=item.getMota()%></td>
                    <td><%=item.getSoluong()%></td>
                    <td><%=item.getDongia()%></td>
                    <td><img src="<%=item.getHinhanh()%>" width="40" height="30"></td>
                    <td><%=item.getMadm()%></td>
                    <td><%=item.getMancc()%></td>
                </tr>
            </tbody>
        </table>
        <form action="MainController" method="post">
            Tên sp : <input name="txttensp" type="text"/> <br/>
            Mô tả : <input name="txtmota" type="text"/> <br/>
            Số lượng : <input name="txtsoluong" type="number"/> <br/>
            Đơn giá : <input name="txtdongia" type="number"/> <br/>
            Hình ảnh : <input name="txthinhanh" type="text"/> <br/>
            <%DanhMucDAO objectDM = new DanhMucDAO();
                List<DanhMucDTO> listDM = objectDM.getAll();
            %>
            Mã danh mục : <select name="txtmadm">
                <%for (DanhMucDTO p : listDM) {%>
                <option value="<%=p.getMadm()%>"><%=p.getTendm()%></option>
                <%}%>
            </select> <br/>
            Mã ncc : <input name="txtmancc" type="text"/> <br/>
            <input name="action" type="submit" value="UpdateItem"/>
        </form>
    </body>
</html>
