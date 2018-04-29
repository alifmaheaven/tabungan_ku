package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

public class InputCicilan {
    private String bid;
    private String iuang;
    private String tanggal;

    public InputCicilan() {
    }

    public InputCicilan(String bid, String iuang, String tanggal) {
        this.bid = bid;
        this.iuang = iuang;
        this.tanggal = tanggal;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getIuang() {
        return iuang;
    }

    public void setIuang(String iuang) {
        this.iuang = iuang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
