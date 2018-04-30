package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

public class Barang {

    private String namabarang;
    private String targetharga;
    String uid;
    private String tanggalawal;
    private String tanggalakhir;
    private int estimasihari;

    public Barang() {
    }

    public Barang(String namabarang, String targetharga, String tanggalawal, String tanggalakhir, int estimasihari, String uid) {
        this.namabarang = namabarang;
        this.targetharga = targetharga;
        this.tanggalawal = tanggalawal;
        this.tanggalakhir = tanggalakhir;
        this.estimasihari = estimasihari;
        this.uid = uid;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getTargetharga() {
        return targetharga;
    }

    public void setTargetharga(String targetharga) {
        this.targetharga = targetharga;
    }

    public String getTanggalawal() {
        return tanggalawal;
    }

    public void setTanggalawal(String tanggalawal) {
        this.tanggalawal = tanggalawal;
    }

    public String getTanggalakhir() {
        return tanggalakhir;
    }

    public void setTanggalakhir(String tanggalakhir) {
        this.tanggalakhir = tanggalakhir;
    }

    public int getEstimasihari() {
        return estimasihari;
    }

    public void setEstimasihari(int estimasihari) {
        this.estimasihari = estimasihari;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
