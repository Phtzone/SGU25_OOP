public class Sinhvien{
    private String ten = "hoang";
    public int tuoi;
    public String diachi;

    public Sinhvien(){
    }

    public Sinhvien(String ten){
        this.ten = ten;
    }

    public Sinhvien(String ten, int tuoi){
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public Sinhvien(String ten, int tuoi, String diachi){
        this.ten = ten;
        this.tuoi = tuoi;
        this.diachi = diachi;
    }

    public void mota(){
        System.out.println("ten SV la: " + ten + " tuoi la: " + tuoi + " dia chi: "+ diachi);
    }

    public String getTen(){
        return this.ten;

    }
    public void setTen(String ten){
        this.ten = ten;
    }

}