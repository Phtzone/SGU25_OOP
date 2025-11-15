import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        List<Point> rectPts = Arrays.asList(
                new Point(0, 0),
                new Point(3, 0),
                new Point(3, 4),
                new Point(0, 4)
        );

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
    }
}
