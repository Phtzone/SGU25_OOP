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
            return "Vo nghiem";
        if (delta == 0) {
            double x = -b / (2 * a);
            return String.format("Nghiem kep x1 = x2 = %.4f", x);
        }
        double sqrtD = Math.sqrt(delta);
        double x1 = (-b + sqrtD) / (2 * a);
        double x2 = (-b - sqrtD) / (2 * a);
        return String.format("x1 = %.4f, x2 = %.4f", x1, x2);
    }

    @Override
    public String toString() {
        return String.format("%.2fx² + %.2fx + %.2f = 0", a, b, c);
    }
}
