
package Item;


public class ItemDTO {
    private String masp;
    private String tensp;
    private String mota;
    private int soluong;
    private double dongia;
    private String hinhanh;
    private boolean trangthai;
    private String madm;
    private String mancc;

    public ItemDTO() {
    }

    public ItemDTO(String masp, String tensp, String mota, int soluong, double dongia, String hinhanh, boolean trangthai, String madm, String mancc) {
        this.masp = masp;
        this.tensp = tensp;
        this.mota = mota;
        this.soluong = soluong;
        this.dongia = dongia;
        this.hinhanh = hinhanh;
        this.trangthai = trangthai;
        this.madm = madm;
        this.mancc = mancc;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getMadm() {
        return madm;
    }

    public void setMadm(String madm) {
        this.madm = madm;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }
    
}
