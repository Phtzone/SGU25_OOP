import java.util.*;

public class PTB2 extends PTB1 {
    private double a;

    public PTB2(double a, double b, double c) {
        super(b, c);
        this.a = a;
    }

    @Override
    public String getSolution() {
        if (a == 0)
            return super.getSolution();

        double delta = b * b - 4 * a * c;
        if (delta < 0)
            return "Vo nghiem (delta < 0)";
        if (delta == 0)
            return String.format("Nghiem kep (delta = 0): x = %.4f", -b / (2 * a));

        double sqrt = Math.sqrt(delta);
        double x1 = (-b + sqrt) / (2 * a);
        double x2 = (-b - sqrt) / (2 * a);
        return String.format("delta = %.4f  ->  x1 = %.4f, x2 = %.4f", delta, x1, x2);
    }

    public List<Double> getRoots() {
        List<Double> list = new ArrayList<>();
        if (a == 0) {
            if (b != 0)
                list.add(-c / b);
            return list;
        }
        double delta = b * b - 4 * a * c;
        if (delta < 0)
            return list;
        double sqrt = Math.sqrt(delta);
        list.add((-b + sqrt) / (2 * a));
        if (delta > 0)
            list.add((-b - sqrt) / (2 * a));
        return list;
    }

    @Override
    public String toString() {
        return String.format("%.2fx^2 %+.2fx %+.2f = 0", a, b, c);
    }
}
