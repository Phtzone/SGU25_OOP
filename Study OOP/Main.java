import java.util.Scanner;
public class Main {
    public static void main(String[] args){
    Sinhvien sv1 = new Sinhvien();
    sv1.mota();
    
    Sinhvien sv2 = new Sinhvien("tien");
    sv2.mota();

    Sinhvien sv3 = new Sinhvien("ten", 3);
    sv3.mota();
    Scanner sc = new Scanner(System.in);
    String ten2 = sc.nextLine();
    sv1.setTen(ten2);
    System.out.println(sv1.getTen());
    }
}
