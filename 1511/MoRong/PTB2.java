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

    // Câu 7: Tìm giao điểm giữa đường thẳng l1 (PTB1: y = b1*x + c1) và PTB2 (y = a*x² + b2*x + c2)
    public String getIntersection(PTB1 l1) {
        if (a == 0) return "Khong phai parabol";
        
        // Giao điểm: b1*x + c1 = a*x² + b2*x + c2
        // → a*x² + (b2 - b1)*x + (c2 - c1) = 0
        double newB = b - l1.b;
        double newC = c - l1.c;
        double delta = newB * newB - 4 * a * newC;
        
        if (delta < 0) return "Khong co giao diem";
        if (delta == 0) {
            double x = -newB / (2 * a);
            double y = l1.b * x + l1.c;
            return String.format("Tiep xuc: (%.4f, %.4f)", x, y);
        }
        double sqrtD = Math.sqrt(delta);
        double x1 = (-newB + sqrtD) / (2 * a);
        double x2 = (-newB - sqrtD) / (2 * a);
        double y1 = l1.b * x1 + l1.c;
        double y2 = l1.b * x2 + l1.c;
        return String.format("Giao diem: (%.4f, %.4f), (%.4f, %.4f)", x1, y1, x2, y2);
    }

    // Câu 8: Tìm đường thẳng l2 song song l1 và tiếp xúc với PTB2
    public PTB1 getTangentParallel(PTB1 l1) {
        if (a == 0) return null;
        
        // l2 song song l1: y = b1*x + d (cùng hệ số góc b1)
        // Tiếp xúc PTB2: b1*x + d = a*x² + b2*x + c2
        // → a*x² + (b2 - b1)*x + (c2 - d) = 0 có nghiệm kép
        // Delta = 0: (b2 - b1)² - 4*a*(c2 - d) = 0
        // → d = c2 - (b2 - b1)²/(4*a)
        double d = c - (b - l1.b) * (b - l1.b) / (4 * a);
        return new PTB1(l1.b, d);
    }
}
