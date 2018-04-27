package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

public class Input {

    private String namabarang;
    private String targetharga;
    private String tanggalawal;
    private String tanggalakhir;
    private int estimasihari;

    public Input() {
    }

    public Input(String namabarang, String targetharga, String tanggalawal, String tanggalakhir, int estimasihari) {
        this.namabarang = namabarang;
        this.targetharga = targetharga;
        this.tanggalawal = tanggalawal;
        this.tanggalakhir = tanggalakhir;
        this.estimasihari = estimasihari;
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
}
