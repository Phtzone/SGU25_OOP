import java.util.*;

public class QuadraticF {
    private final double a, b, c;

    public QuadraticF(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /* C7: giao parabol va duong thang */
    public List<Point> intersect(Line l) {
        List<Point> res = new ArrayList<>();
        if (l.isVertical()) {
            double x = l.getX0();
            double y = a * x * x + b * x + c;
            res.add(new Point((int) Math.round(x), (int) Math.round(y)));
            return res;
        }
        double m = l.getSlope(), d0 = l.getIntercept();
        PTB2 eq = new PTB2(a, b - m, c - d0);
        for (double x : eq.getRoots()) {
            double y = m * x + d0;
            res.add(new Point((int) Math.round(x), (int) Math.round(y)));
        }
        return res;
    }

    /* C8: tiep tuyen song song l */
    public List<Line> tangentParallel(Line l) {
        if (l.isVertical())
            throw new IllegalArgumentException("Parabol truc Oy khong co tiep tuyen dung.");
        double m = l.getSlope();
        double d = c - (b - m) * (b - m) / (4 * a);
        return List.of(new Line(m, d));
    }
}
