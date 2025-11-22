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
		double length = 0;
		for (int i = 0; i < points.size() - 1; i++) {
			int x1 = points.get(i).getX();
			int y1 = points.get(i).getY();
			int x2 = points.get(i + 1).getX();
			int y2 = points.get(i + 1).getY();
			double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
			length += distance;
		}
		return length;
	}

    // Chu vi của đa giác đóng kín (từ cuối nối về đầu)
    public double getPerimeter() {
        double per = getLength();
        int n = points.size();
        if (n > 2) {
            int x1 = points.get(0).getX();
            int y1 = points.get(0).getY();
            int x2 = points.get(n - 1).getX();
            int y2 = points.get(n - 1).getY();
            double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            per += distance;
        }
        return per;
    }

    // Diện tích đa giác đóng kín theo công thức Shoelace:
    public double getArea() {
        int n = points.size();
        if (n < 3) return 0; 

        double sum = 0;
        for (int i = 0; i < n; i++) {
            int x1 = points.get(i).getX();
            int y1 = points.get(i).getY();
            int x2 = points.get((i + 1) % n).getX();
            int y2 = points.get((i + 1) % n).getY();
            sum += x1 * y2 - x2 * y1;
        }
        return Math.abs(sum) / 2.0;
    }

    // Câu 4: Kiểm tra điểm có nằm trong đa giác không (Ray casting)
    public boolean isPointInside(Point p) {
        int n = points.size();
        if (n < 3) return false;

        boolean inside = false;
        for (int i = 0, j = n - 1; i < n; j = i++) {
            int xi = points.get(i).getX(), yi = points.get(i).getY();
            int xj = points.get(j).getX(), yj = points.get(j).getY();
            
            boolean intersect = ((yi > p.getY()) != (yj > p.getY())) &&
                    (p.getX() < (xj - xi) * (p.getY() - yi) / (yj - yi) + xi);
            if (intersect) inside = !inside;
        }
        return inside;
    }

    // Câu 6: Tìm điểm cần bỏ để diện tích đa giác (n-1) lớn nhất
    public int findBestPointToRemove() {
        int n = points.size();
        if (n <= 3) return -1;

        double maxArea = 0;
        int bestIndex = 0;

        for (int i = 0; i < n; i++) {
            List<Point> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (j != i) temp.add(points.get(j));
            }
            PolyLine tempPoly = new PolyLine(temp);
            double area = tempPoly.getArea();
            if (area > maxArea) {
                maxArea = area;
                bestIndex = i;
            }
        }
        return bestIndex;
    }
}