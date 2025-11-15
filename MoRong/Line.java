public class Line {
    private final boolean vertical;
    private final double m, d, x0;

    public Line(double m, double d) {
        vertical = false;
        this.m = m;
        this.d = d;
        x0 = Double.NaN;
    }

    public Line(double x0) {
        vertical = true;
        this.x0 = x0;
        m = d = Double.NaN;
    }

    public boolean isVertical() {
        return vertical;
    }

    public double getSlope() {
        return m;
    }

    public double getIntercept() {
        return d;
    }

    public double getX0() {
        return x0;
    }

    @Override
    public String toString() {
        return vertical
                ? String.format("x = %.4f", x0)
                : String.format("y = %.4fx %+.4f", m, d);
    }
}
