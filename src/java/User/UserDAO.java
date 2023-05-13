
package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class UserDAO {

    private static final String LOGIN = "SELECT * FROM tblTaiKhoan WHERE tentk=? AND matkhau=?";
    private static final String GET_ALL = "SELECT * FROM tblTaiKhoan";
    private static final String FIND = "SELECT * FROM tblTaiKhoan WHERE tentk=?";
    private static final String INSERT = "INSERT INTO tblTaikhoan(tentk, matkhau, trangthai, email, nhomtk) VALUES(?,?,?,?,?)";
    private static final String DELETE = "DELETE tblTaiKhoan WHERE tentk=?";
    private static final String UPDATE = "UPDATE tblTaiKhoan SET matkhau=?, trangthai=?, email=?, nhomtk=?  WHERE tentk=?";
    
    
    public boolean update(UserDTO user) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getPassword());
                ptm.setBoolean(2, user.isActive());
                ptm.setString(3, user.getEmail());
                ptm.setString(4, user.getGroupUser());
                ptm.setString(5, user.getUsername());
                checkUpdate = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkUpdate;
    }
    
    
    public boolean delete(String tenk) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, tenk);
                checkDelete = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkDelete;
    }
    
     public UserDTO findUser(String username) throws SQLException {
        UserDTO loginUser = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FIND);
                ptm.setString(1, username);
                 rs = ptm.executeQuery();
                if (rs.next()) {
                    String _password = rs.getString("matkhau");
                    boolean _active = rs.getBoolean("trangthai");
                    String _email = rs.getString("email");
                    String _groupUser = rs.getString("nhomtk");
                    loginUser = new UserDTO(username, _password, _active, _email, _groupUser);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return loginUser;
    }
    
     public List<UserDTO> getAll() throws SQLException {
         List<UserDTO> listUser = new ArrayList<>();
        UserDTO loginUser = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL);
                 rs = ptm.executeQuery();
                while (rs.next()) {
                    String _tentk = rs.getString("tentk");
                    String _matkhau = rs.getString("matkhau");
                    boolean _active = rs.getBoolean("trangthai");
                    String _email = rs.getString("email");
                    String _groupUser = rs.getString("nhomtk");
                    loginUser = new UserDTO(_tentk, _matkhau, _active, _email, _groupUser);
                    listUser.add(loginUser);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listUser;
    }
    
    public UserDTO checkLogin(String username, String password) throws SQLException {
        UserDTO loginUser = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, username);
                ptm.setString(2, password);
                 rs = ptm.executeQuery();
                if (rs.next()) {
                    boolean _active = rs.getBoolean("trangthai");
                    String _email = rs.getString("email");
                    String _groupUser = rs.getString("nhomtk");
                    loginUser = new UserDTO(username, password, _active, _email, _groupUser);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return loginUser;
    }
    
    public boolean register(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUsername());
                ptm.setString(2, user.getPassword());
                ptm.setBoolean(3, user.isActive());
                ptm.setString(4, user.getEmail());
                ptm.setString(5, user.getGroupUser());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
        
    }
    
}
