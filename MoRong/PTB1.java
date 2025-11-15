public class PTB1 {
    protected double b;
    protected double c;

    public PTB1(double b, double c) {
        this.b = b;
        this.c = c;
    }

    public String getSolution() {
        if (b == 0) {
            return c == 0 ? "Vo so nghiem" : "Vo nghiem";
    }
        double x = -c / b;
        return String.format("x = %.4f", x);
    }

    @Override
    public String toString() {
        return String.format("%.2fx + %.2f = 0", b, c);
    }
}
