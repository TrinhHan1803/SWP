
package controller;

import Item.ItemDAO;
import Item.ItemDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddItemController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        try {
            ItemDAO objectItem = new ItemDAO();
            String masp = request.getParameter("txtmasp");
            String tensp = request.getParameter("txttensp");
            String mota = request.getParameter("txtmota");
            int soluong = Integer.parseInt(request.getParameter("txtsoluong"));
            double dongia = Double.parseDouble(request.getParameter("txtdongia"));
            String hinhanh = request.getParameter("txthinhanh");
            boolean trangthai = true;
            String madm = request.getParameter("txtmadm");
            String mancc = request.getParameter("txtmancc");
            ItemDTO item = new ItemDTO(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm, mancc);
            
            boolean check = objectItem.add(item);
            if (check) {
                url = "viewItem.jsp";
                request.setAttribute("mess", "Add success");
            } else {
                url = "addItem.jsp";
                request.setAttribute("mess", "add failed");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddItemController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
