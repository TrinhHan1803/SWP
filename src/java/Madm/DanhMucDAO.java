
package Madm;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;


public class DanhMucDAO {

    private static final String GET_ALL = "SELECT * FROM tblDanhMuc";
    private static final String FIND = "SELECT * FROM tblDanhMuc WHERE madm=?";
    private static final String INSERT = "INSERT INTO tblDanhMuc(madm, tendm, trangthai) VALUES(?,?,?)";
    private static final String DELETE = "DELETE tblDanhMuc WHERE madm=?";
    private static final String UPDATE = "UPDATE tblDanhMuc SET tendm=?, trangthai=?  WHERE madm=?";
    
    
    public List<DanhMucDTO> getAll() throws SQLException {
         List<DanhMucDTO> listDanhMuc = new ArrayList<>();
        DanhMucDTO danhMuc = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL);
                 rs = ptm.executeQuery();
                while (rs.next()) {
                    String _madm= rs.getString("madm");
                    String _tendm = rs.getString("tendm");
                    boolean _trangthai = rs.getBoolean("trangthai");
                    danhMuc = new DanhMucDTO(_madm, _tendm, _trangthai);
                    listDanhMuc.add(danhMuc);
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
        return listDanhMuc;
    }
    
    public DanhMucDTO find(String madm) throws SQLException {
        DanhMucDTO danhMuc = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FIND);
                ptm.setString(1, madm);
                 rs = ptm.executeQuery();
                 
                if (rs.next()) {
                    String _madm= rs.getString("madm");
                    String _tendm = rs.getString("tendm");
                    boolean _trangthai = rs.getBoolean("trangthai");
                    danhMuc = new DanhMucDTO(_madm, _tendm, _trangthai);
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
        return danhMuc;
    }
    
    public boolean delete(String madm) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, madm);
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
    
      public boolean update(DanhMucDTO item) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, item.getTendm());
                ptm.setBoolean(2, item.isTrangthai());
                ptm.setString(3, item.getMadm());
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
      
      public boolean insert(DanhMucDTO dm) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, dm.getMadm());
                ptm.setString(2, dm.getTendm());
                ptm.setBoolean(3, dm.isTrangthai());
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
