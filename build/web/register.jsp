

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="MainController" method="post">
            Tên tài khoản : <input name="txtusername" type="text"/> <br/>
            Mật khẩu : <input name="txtpassword" type="password"/> <br/>
            email : <input name="txtemail" type="text"/>    <br/>
            Nhóm tài khoản : <input name="txtgroupuser" type="text"/> <br/>
            <input type="submit" name="action" value="Register"/>
            <input type="submit" name="action" value="Login_Page"/>
        </form>
        ${mess}
    </body>
</html>
