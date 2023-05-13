
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie[] listCookie = request.getCookies();
            String user = "";
            String pass = "";
            if (listCookie != null) {
                for (Cookie p : listCookie){
                    if (p.getName().equals("username")) {
                        user = p.getValue();
                    }
                    if (p.getName().equals("password")) {
                        pass = p.getValue();
                    }
                }

            }
        %>
        <form action="MainController" method="post">
            User name :  <input type="text" name="txtusername" value="<%=user%>"/> <br/>
            Pass word  :  <input type="password" name="txtpassword" value="<%=pass%>"/>  <br/>
            <input value="Login" name="action" type="submit"/>
            <input value="Register_Page" name="action" type="submit"/>
        </form>

        ${mess}
    </body>
</html>
