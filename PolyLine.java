import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    private List<Point> points;

    public PolyLine() {
        this.points = new ArrayList<>();
    }

    public PolyLine(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public void appendPoint(Point point) {
        this.points.add(new Point(point.getX(), point.getY()));
    }

    public void appendPoint(int x, int y) {
        this.points.add(new Point(x, y));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point p : points) {
            sb.append(p);
        }
        sb.append("}");
        return sb.toString();
    }

    // Tổng chiều dài các đoạn nối liên tiếp (không đóng kín)
    public double getLength() {
        double sum = 0;
        for (int i = 1; i < points.size(); i++) {
            Point a = points.get(i - 1);
            Point b = points.get(i);
            sum += Math.hypot(b.getX() - a.getX(), b.getY() - a.getY());
        }
        return sum;
    }

    // Chu vi của đa giác đóng kín (từ cuối nối về đầu)
    public double getPerimeter() {
        double per = getLength();
        int n = points.size();
        if (n > 2) {
            Point first = points.get(0);
            Point last  = points.get(n - 1);
            per += Math.hypot(last.getX() - first.getX(), last.getY() - first.getY());
        }
        return per;
    }

    /** 
     * Diện tích đa giác đóng kín theo công thức Shoelace:
     * ½ * |Σ (x_i * y_{i+1} − x_{i+1} * y_i)| 
     */
    public double getArea() {
        int n = points.size();
        if (n < 3) return 0; 

        double sum = 0;
        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            sum += p1.getX() * p2.getY() - p2.getX() * p1.getY();
        }
        return Math.abs(sum) / 2.0;
    }
}
