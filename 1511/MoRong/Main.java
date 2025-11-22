import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        // Tạo đa giác với số điểm ngẫu nhiên
        Random rd0 = new Random();
        int soDiem = rd0.nextInt(6) + 3; 
        List<Point> rectPts = new ArrayList<>();
        for (int i = 0; i < soDiem; i++) {
            int x = rd0.nextInt(10) - 2; 
            int y = rd0.nextInt(10) - 2; 
            rectPts.add(new Point(x, y));
        }

        PolyLine pl = new PolyLine(rectPts);  

        System.out.println("PolyLine  : " + pl);
        System.out.printf("Length    : %.2f%n", pl.getLength());     // 10.00
        System.out.printf("Perimeter : %.2f%n", pl.getPerimeter());  // 14.00
        System.out.printf("Area      : %.2f%n%n", pl.getArea());     // 12.00

        int n = 5;
        PTB2[] arr = new PTB2[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            double a = rd.nextInt(11) - 5;
            double b = rd.nextInt(11) - 5;
            double c = rd.nextInt(11) - 5;
            arr[i] = new PTB2(a, b, c);
        }

        System.out.println("Ket qua nghiem PTB2");
        for (PTB2 eq : arr) {
            System.out.println(eq + "  ⇒  " + eq.getSolution());
        }

        System.out.println("\nCau 3: Ve da giac n canh");
        PolyLine polygon = new PolyLine(rectPts);
        int soCanh = rectPts.size();
        System.out.println("Da giac " + soCanh + " canh: " + polygon);
        System.out.printf("So dinh: %d%n", rectPts.size());
        System.out.printf("Chu vi: %.2f%n", polygon.getPerimeter());
        System.out.printf("Dien tich: %.2f%n", polygon.getArea());

        System.out.println("\nCau 4: Kiem tra diem nam trong da giac");
        Point testPoint = new Point(1, 1);
        System.out.println("Diem " + testPoint + " co nam trong? " + polygon.isPointInside(testPoint));
        Point outsidePoint = new Point(10, 10);
        System.out.println("Diem " + outsidePoint + " co nam trong? " + polygon.isPointInside(outsidePoint));

        System.out.println("\nCau 5: Dien tich da giac");
        System.out.printf("Dien tich da giac: %.2f%n", polygon.getArea());

        System.out.println("\nCau 6: Tim diem can bo de dien tich lon nhat");
        int bestIdx = polygon.findBestPointToRemove();
        System.out.println("Bo diem tai vi tri: " + bestIdx + " (" + rectPts.get(bestIdx) + ")");

        System.out.println("\nCau 7: Giao diem duong thang va PTB2");
        PTB1 line1 = new PTB1(2, -1); // y = 2x - 1
        PTB2 para1 = new PTB2(1, -3, 2); // y = x² - 3x + 2
        System.out.println("Duong thang: " + line1);
        System.out.println("Parabol: " + para1);
        System.out.println("Ket qua: " + para1.getIntersection(line1));

        System.out.println("\nCau 8: Duong thang song song va tiep xuc");
        PTB1 line2 = new PTB1(1, 0); // y = x
        PTB2 para2 = new PTB2(1, 0, 0); // y = x²
        PTB1 tangent = para2.getTangentParallel(line2);
        if (tangent != null) {
            System.out.println("Duong thang goc: " + line2);
            System.out.println("Parabol: " + para2);
            System.out.println("Duong thang tiep xuc: " + tangent);
        }
    }
}
