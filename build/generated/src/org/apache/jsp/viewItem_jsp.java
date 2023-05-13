package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Comparator;
import java.util.Collections;
import Madm.DanhMucDTO;
import Madm.DanhMucDAO;
import Item.ItemDTO;
import java.util.List;
import Item.ItemDAO;

public final class viewItem_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Danh sách sản phẩm</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-light\" style=\"background-color: yellow;\">\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"MainController?action=main\">Cửa hàng Mỹ phẩm</a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li class=\"active\"><a href=\"MainController?action=viewItem\">Danh sách sản phẩm</a></li>\n");
      out.write("                    <li><a href=\"MainController?action=danhmuc\">Danh mục</a></li>\n");
      out.write("                    <li><a href=\"MainController?action=user\">Tài khoản</a></li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                <form class=\"navbar-form navbar-left\" action=\"MainController\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Search\" name=\"search\">\n");
      out.write("                    </div>\n");
      out.write("                    ");
DanhMucDAO objectDM = new DanhMucDAO();
                        List<DanhMucDTO> listDM = objectDM.getAll();
                    
      out.write("\n");
      out.write("                    <select name=\"dm\">\n");
      out.write("                        <option value=\"\">Danh mục</option>\n");
      out.write("                        ");
for (DanhMucDTO p : listDM) {
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(p.getMadm());
      out.write('"');
      out.write('>');
      out.print(p.getTendm());
      out.write("</option>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    <input name=\"action\" type=\"submit\" value=\"Search\" class=\"btn btn-default\"/>\n");
      out.write("                </form>\n");
      out.write("                ");
String url = "login.html";
                    String action = "Login";
                    if (request.getSession().getAttribute("username") != null) {
                        action = "Logout";
                        url = "MainController?action=Logout";
                    }
                
      out.write("\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li><a href=\"register.html\"><span class=\"glyphicon glyphicon-user\"></span>Tạo tài khoản mới</a></li>\n");
      out.write("                    <li><a href=\"");
      out.print(url);
      out.write("\"><span class=\"glyphicon glyphicon-log-in\"></span> ");
      out.print(action);
      out.write("</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
ItemDAO objectItem = new ItemDAO();
            List<ItemDTO> listItem = objectItem.getAll();
        
      out.write("\n");
      out.write("        ");
if (listItem.size() > 0) {
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Tên sp</th>\n");
      out.write("                    <th>Mô tả</th>\n");
      out.write("                    <th>Đơn giá</th>\n");
      out.write("                    <th>Hình Ảnh</th>\n");
      out.write("                    \n");
      out.write("                    <th>chiết khấu</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
for (ItemDTO p : listItem) {
      out.write("\n");
      out.write("            <form action=\"MainController\" method=\"get\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(p.getTensp());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(p.getMota());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(p.getDongia());
      out.write("</td>\n");
      out.write("                    <td><img src=\"");
      out.print(p.getHinhanh());
      out.write("\"\n");
      out.write("                             width=\"100\" height=\"50\"></td>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                        ");
String a = "";
                            if (p.getSoluong() > 10) {
                                a = " chiet khau 10%";
                            }
                        
      out.write("\n");
      out.write("                    <td>");
      out.print(a);
      out.write("</td>\n");
      out.write("                <input type=\"submit\" name=\"action\" value=\"Detail\"/>\n");
      out.write("                <input type=\"hidden\"name=\"masp\" value=\"");
      out.print(p.getMasp());
      out.write("\"/>\n");
      out.write("                </td>\n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("    ");
} else {
      out.write("\n");
      out.write("    <h1>Don't have any Item</h1>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    <form action=\"MainController\" method=\"get\">\n");
      out.write("        <input type=\"submit\" value=\"AddItem\" name=\"action\"/>\n");
      out.write("    </form>\n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
