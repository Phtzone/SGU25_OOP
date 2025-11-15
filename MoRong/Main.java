import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Point> rectPts = Arrays.asList(
                new Point(0, 0),
                new Point(3, 0),
                new Point(3, 4),
                new Point(0, 4));
        PolyLine pl = new PolyLine(rectPts);

        System.out.println("PolyLine  : " + pl);
        System.out.printf("Length    : %.2f%n", pl.getLength());
        System.out.printf("Perimeter : %.2f%n", pl.getPerimeter());
        System.out.printf("Area      : %.2f%n%n", pl.getArea());

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
            System.out.println(eq + "  ->  " + eq.getSolution());
        }

        // PHAN MO RONG (C3 -> C8)
        System.out.println("\n Mo rong C3 -> C8 ");

        // C3: da giac 5 dinh
        List<Point> pts = Arrays.asList(
                new Point(0, 0), new Point(5, 0),
                new Point(6, 3), new Point(3, 6),
                new Point(0, 4));
        PolyLine poly = new PolyLine(pts);
        System.out.println("Da giac    : " + poly);
        System.out.printf("Chu vi     : %.2f%n", poly.getPerimeter());
        System.out.printf("Dien tich  : %.2f%n", poly.getArea());

        // C4: kiem tra diem
        Point q = new Point(3, 2);
        System.out.println(q + (poly.contains(q) ? " nam TRONG " : " nam NGOAI ") + "da giac");

        // C6: bo dinh toi uu
        int idx = poly.bestRemovalIndex();
        System.out.printf("Bo dinh #%d %s  ->  dien tich con lai = %.2f%n",
                idx, pts.get(idx), poly.areaWithout(idx));

        // C7: giao duong thang va parabol
        Line l1 = new Line(1, 0); // y = x
        QuadraticF f = new QuadraticF(1, -2, -3); // y = x^2 - 2x - 3
        System.out.println("Giao l1 va f: " + f.intersect(l1));

        // C8: tiep tuyen song song l1
        System.out.println("Tiep tuyen song song l1: " + f.tangentParallel(l1));
    }
}
