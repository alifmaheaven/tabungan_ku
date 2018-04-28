package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

public class Barang {

    private String namabarang;
    private String targetharga;
    private String uid;

    public Barang(String namabarang, String targetharga, String uid) {

        this.namabarang = namabarang;
        this.targetharga = targetharga;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }


    public Barang() {

    }

    public void setUid(String uid) {
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


}
