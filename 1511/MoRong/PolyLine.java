import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    private final List<Point> points;

    public PolyLine() {
        points = new ArrayList<>();
    }

    public PolyLine(List<Point> pts) {
        points = new ArrayList<>(pts);
    }

    public void appendPoint(Point p) {
        points.add(new Point(p.getX(), p.getY()));
    }

    public void appendPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point p : points)
            sb.append(p);
        return sb.append("}").toString();
    }

    /* ---- C3: do dai & chu vi ---- */
    public double getLength() {
        double len = 0;
        for (int i = 1; i < points.size(); i++)
            len += points.get(i).distance(points.get(i - 1));
        return len;
    }

    public double getPerimeter() {
        if (points.size() < 2)
            return 0;
        return getLength() + points.get(0).distance(points.get(points.size() - 1));
    }

    /* ---- C5: dien tich Shoelace ---- */
    public double getArea() {
        int n = points.size();
        if (n < 3)
            return 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            sum += (long) p1.getX() * p2.getY() - (long) p2.getX() * p1.getY();
        }
        return Math.abs(sum) / 2.0;
    }

    /* ---- C4: diem nam trong da giac? ---- */
    public boolean contains(Point p) {
        int n = points.size();
        if (n < 3)
            return false;
        boolean inside = false;
        for (int i = 0, j = n - 1; i < n; j = i++) {
            Point pi = points.get(i), pj = points.get(j);
            boolean intersect = ((pi.getY() > p.getY()) != (pj.getY() > p.getY())) &&
                    (p.getX() < (long) (pj.getX() - pi.getX()) * (p.getY() - pi.getY())
                            / (pj.getY() - pi.getY()) + pi.getX());
            if (intersect)
                inside = !inside;
        }
        return inside;
    }

    /* ---- C6: bo mot dinh de dien tich lon nhat ---- */
    public int bestRemovalIndex() {
        int n = points.size();
        if (n <= 3)
            return -1;
        double best = -1;
        int idx = -1;
        for (int k = 0; k < n; k++) {
            double area = areaWithout(k);
            if (area > best) {
                best = area;
                idx = k;
            }
        }
        return idx;
    }

    public double areaWithout(int skip) {
        int n = points.size();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == skip)
                continue;
            int j = (i + 1) % n;
            if (j == skip)
                j = (j + 1) % n;
            Point p1 = points.get(i), p2 = points.get(j);
            sum += (long) p1.getX() * p2.getY() - (long) p2.getX() * p1.getY();
        }
        return Math.abs(sum) / 2.0;
    }
}
