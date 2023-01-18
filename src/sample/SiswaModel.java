package sample;

public class SiswaModel {
    private String nisn;
    private String nama;
    private String alamat;
    public SiswaModel(String nisn, String nama, String alamt) {
        this.nisn = nisn;
        this.nama = nama;
        this.alamat = alamt;
    }
    public String getNisn(){
        return  nisn;
    }
    public void setNisn(String nisn) {
        this.nisn = nisn;
    }
    public  String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat() {
        this.alamat = alamat;
    }
}