public class Point {
    private int x;
    private int y;

    
    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    // Khoảng cách Euclid tới điểm khác
    public double distance(Point other) {
        int dx = x - other.x;
        int dy = y - other.y;
        return Math.hypot(dx, dy);
    }
}
