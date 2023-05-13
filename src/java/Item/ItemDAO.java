
package Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class ItemDAO {

    private static final String GET_ALL = "SELECT * FROM tblSanPham";
    private static final String DELETE = "DELETE tblSanPham WHERE masp=?";
    private static final String INSERT = "INSERT INTO tblSanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm, mancc) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE tblSanPham SET tensp=?, mota=?, soluong=?, dongia=?, hinhanh=?, trangthai=?, madm=?, mancc=? WHERE masp=?";
    private static final String DETAIL = "SELECT * FROM tblSanPham WHERE masp=?";
    private static final String SEARCH_DM = "SELECT * FROM tblSanPham WHERE madm=?";
    private static final String SEARCH = "SELECT * FROM tblSanPham WHERE tensp like ?";
    private static final String DELETE_DM = "DELETE tblSanPham WHERE madm=?";

    public List<ItemDTO> getAll() throws SQLException {
        List<ItemDTO> listItem = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String _masp = rs.getString("masp");
                    String _tensp = rs.getString("tensp");
                    String _mota = rs.getString("mota");
                    int _soluong = rs.getInt("soluong");
                    double _dongia = rs.getDouble("dongia");
                    String _hinhanh = rs.getString("hinhanh");
                    boolean _trangthai = rs.getBoolean("trangthai");
                    String _madm = rs.getString("madm");
                    String _mancc = rs.getString("mancc");
                    ItemDTO item = new ItemDTO(_masp, _tensp, _mota, _soluong, _dongia, _hinhanh,
                            _trangthai, _madm, _mancc);
                    listItem.add(item);
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
        return listItem;
    }

    public boolean delete(String masp) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, masp);
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
    
    public boolean delete_dm(String madm) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_DM);
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
    

    public boolean add(ItemDTO item) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, item.getMasp());
                ptm.setString(2, item.getTensp());
                ptm.setString(3, item.getMota());
                ptm.setInt(4, item.getSoluong());
                ptm.setDouble(5, item.getDongia());
                ptm.setString(6, item.getHinhanh());
                ptm.setBoolean(7, item.isTrangthai());
                ptm.setString(8, item.getMadm());
                ptm.setString(9, item.getMancc());
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

    public ItemDTO detail(String masp) throws SQLException {
        ItemDTO item = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DETAIL);
                ptm.setString(1, masp);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String _masp = rs.getString("masp");
                    String _tensp = rs.getString("tensp");
                    String _mota = rs.getString("mota");
                    int _soluong = rs.getInt("soluong");
                    double _dongia = rs.getDouble("dongia");
                    String _hinhanh = rs.getString("hinhanh");
                    boolean _trangthai = rs.getBoolean("trangthai");
                    String _madm = rs.getString("madm");
                    String _mancc = rs.getString("mancc");
                    item = new ItemDTO(_masp, _tensp, _mota, _soluong, _dongia, _hinhanh,
                            _trangthai, _madm, _mancc);

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
        return item;
    }
    
    public boolean update(ItemDTO item) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, item.getTensp());
                ptm.setString(2, item.getMota());
                ptm.setInt(3, item.getSoluong());
                ptm.setDouble(4, item.getDongia());
                ptm.setString(5, item.getHinhanh());
                ptm.setBoolean(6, item.isTrangthai());
                ptm.setString(7, item.getMadm());
                ptm.setString(8, item.getMancc());
                ptm.setString(9, item.getMasp());
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
    
    public List search(String search) throws SQLException {
        List listItem = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String _masp = rs.getString("masp");
                    String _tensp = rs.getString("tensp");
                    String _mota = rs.getString("mota");
                    int _soluong = rs.getInt("soluong");
                    double _dongia = rs.getDouble("dongia");
                    String _hinhanh = rs.getString("hinhanh");
                    boolean _trangthai = rs.getBoolean("trangthai");
                    String _madm = rs.getString("madm");
                    String _mancc = rs.getString("mancc");
                    ItemDTO item = new ItemDTO(_masp, _tensp, _mota, _soluong, _dongia, _hinhanh,
                            _trangthai, _madm, _mancc);
                    listItem.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return listItem;
    }
    
     public List searchDm(String madm) throws SQLException {
        List listItem = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_DM);
                ptm.setString(1, madm);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String _masp = rs.getString("masp");
                    String _tensp = rs.getString("tensp");
                    String _mota = rs.getString("mota");
                    int _soluong = rs.getInt("soluong");
                    double _dongia = rs.getDouble("dongia");
                    String _hinhanh = rs.getString("hinhanh");
                    boolean _trangthai = rs.getBoolean("trangthai");
                    String _madm = rs.getString("madm");
                    String _mancc = rs.getString("mancc");
                    ItemDTO item = new ItemDTO(_masp, _tensp, _mota, _soluong, _dongia, _hinhanh,
                            _trangthai, _madm, _mancc);
                    listItem.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return listItem;
    }
}
