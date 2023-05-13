
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainController extends HttpServlet {

    // Page
    private final static String LOGIN = "Login";
    private final static String LOGIN_CONTROLLER = "LoginController";
    private final static String LOGINPAGE = "Login_Page";
    private final static String LOGIN_PAGE = "login.html";
    private final static String LOGOUT = "Logout";
    private final static String LOGOUT_CONTROLLER = "LogoutController";
    private final static String REGISTER = "Register";
    private final static String REGISTER_CONTROLLER = "RegisterController";
    private final static String REGISTERPAGE = "Register_Page";
    private final static String REGISTER_PAGE = "register.html";
    private final static String MAIN = "main";
    private final static String MAIN_PAGE = "main.jsp";
    // Item
    private final static String DELETE = "Delete";
    private final static String DELETE_CONTROLLER = "DeleteController";
    private final static String ADD = "Add";
    private final static String ADDITEM_CONTROLLER = "AddItemController";
    private final static String ADDITEM = "AddItem";
    private final static String ADDITEM_PAGE = "addItem.jsp";
    private final static String VIEW_ITEM = "viewItem";
    private final static String ITEM_PAGE = "viewItem.jsp";
    private final static String UPDATEITEM = "UpdateItem";
    private final static String UPDATE_PAGE = "updateItem.jsp";
    private final static String UPDATE = "Update";
    private final static String UPDATEITEM_CONTROLLER = "UpdateItemController";
    private final static String SEARCH = "Search";
    private final static String SEARCH_CONTROLLER = "SearchController";
    private final static String ITEM_DETAIL = "Detail";
    private final static String ITEMDETAIL_PAGE = "itemDetail.jsp";
    // User
    private final static String USER = "user";
    private final static String USER_PAGE = "user.jsp";
    private final static String USERDETAIL = "DetailUser";
    private final static String USERDETAIL_PAGE = "userDetail.jsp";
    private final static String DELETEUSER = "DeleteUser";
    private final static String DELETEUSER_CONTROLLER = "DeleteUserController";
    private final static String UPDATEUSER = "UpdateUser";
    private final static String UPDATEUSER_PAGE = "updateUser.jsp";
    private final static String UPDATEUSER_CONFIRM = "UpdateUser_Confirm";
    private final static String UPDATEUSER_CONTROLLER = "UpdateUserController";
    // Danh mục
    private final static String DANHMUC = "danhmuc";
    private final static String DANHMUC_PAGE = "danhmuc.jsp";
    private final static String DANHMUCDETAIL = "ChiTietDm";
    private final static String DANHMUCDETAIL_PAGE = "danhmucDetail.jsp";
    private final static String DELETEDM = "DeleteDM";
    private final static String DELETEDM_CONTROLLER = "DeleteDMController";
    private final static String UPDATEDM = "UpdateDM";
    private final static String UPDATEDM_PAGE = "updateDM.jsp";
    private final static String UPDATEDM_CONFIRM = "UpdateDM_Confirm";
    private final static String UPDATEDM_CONTROLLER = "UpdateDMController";
    private final static String ADDM = "AddDM";
    private final static String ADDM_PAGE = "addDM.jsp";
    private final static String ADDDM_CONFIRM = "AddDM_Confirm";
    private final static String ADDDM_CONTROLLER = "AddDMController";
    // error
    private final static String ERROR_PAGE = "error.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        String url = "error";
        try {
            if (action.equals(LOGIN)) {
                url = LOGIN_CONTROLLER;
            } else if (action.equals(UPDATEUSER)) {
                url = UPDATEUSER_PAGE;
            } else if (action.equals(ADDDM_CONFIRM)) {
                url = ADDDM_CONTROLLER;
            } else if (action.equals(ADDM)) {
                url = ADDM_PAGE;
            } else if (action.equals(UPDATEDM_CONFIRM)) {
                url = UPDATEDM_CONTROLLER;
            } else if (action.equals(UPDATEDM)) {
                url = UPDATEDM_PAGE;
            } else if (action.equals(DELETEDM)) {
                url = DELETEDM_CONTROLLER;
            } else if (action.equals(DANHMUCDETAIL)) {
                url = DANHMUCDETAIL_PAGE;
            } else if (action.equals(UPDATEUSER_CONFIRM)) {
                url = UPDATEUSER_CONTROLLER;
            } else if (action.equals(LOGINPAGE)) {
                url = LOGIN_PAGE;
            } else if (action.equals(DELETEUSER)) {
                url = DELETEUSER_CONTROLLER;
            } else if (action.equals(USERDETAIL)) {
                url = USERDETAIL_PAGE;
            } else if (action.equals(USER)) {
                url = USER_PAGE;
            } else if (action.equals(DANHMUC)) {
                url = DANHMUC_PAGE;
            } else if (action.equals(REGISTERPAGE)) {
                url = REGISTER_PAGE;
            } else if (action.equals(LOGOUT)) {
                url = LOGOUT_CONTROLLER;
            } else if (action.equals(VIEW_ITEM)) {
                url = ITEM_PAGE;
            } else if (action.equals(REGISTER)) {
                url = REGISTER_CONTROLLER;
            } else if (action.equals(DELETE)) {
                url = DELETE_CONTROLLER;
            } else if (action.equals(ADD)) {
                url = ADDITEM_CONTROLLER;
            } else if (action.equals(ADDITEM)) {
                url = ADDITEM_PAGE;
            } else if (action.equals(UPDATE)) {
                url = UPDATE_PAGE;
            } else if (action.equals(UPDATEITEM)) {
                url = UPDATEITEM_CONTROLLER;
            } else if (action.equals(SEARCH)) {
                url = SEARCH_CONTROLLER;
            } else if (action.equals(ITEM_DETAIL)) {
                url = ITEMDETAIL_PAGE;
            } else if (action.equals(MAIN)) {
                url = MAIN_PAGE;
            } else {
                url = ERROR_PAGE;
            }
        } catch (Exception e) {
            log("Error at MainController:" + e.toString());
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
