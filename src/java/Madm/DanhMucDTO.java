
package Madm;


public class DanhMucDTO {
    private String madm;
    private String tendm;
    private boolean trangthai;

    public DanhMucDTO() {
    }

    public DanhMucDTO(String madm, String tendm, boolean trangthai) {
        this.madm = madm;
        this.tendm = tendm;
        this.trangthai = trangthai;
    }

    public String getMadm() {
        return madm;
    }

    public void setMadm(String madm) {
        this.madm = madm;
    }

    public String getTendm() {
        return tendm;
    }

    public void setTendm(String tendm) {
        this.tendm = tendm;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }
    
    
    
}
