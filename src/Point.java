import java.awt.geom.Point2D;

public class Point extends Point2D.Double implements Comparable<Point> {

    private double goldDensity;

    public Point() {
        super();
        this.x = 0.0;
        this.y = 0.0;
        this.goldDensity = Gold.evaluate(this.toArray());
    }

    public Point(double x, double y) {
        super(x, y);
        this.goldDensity = Gold.evaluate(this.toArray());

        return;
    }

    public void moveTo(double x, double y) {
        this.x = this.fixValue(-1e6, 1e6, this.x + x);
        this.y = this.fixValue(-1e6, 1e6, this.y + y);

        this.goldDensity = Gold.evaluate(this.toArray());

        return;
    }

    @Override
    public void setLocation(double x, double y) {
        super.setLocation(x, y);
        this.goldDensity = Gold.evaluate(this.toArray());

        return;
    }

    private double fixValue(double min, double max, double point) {
        if (point < min) point = min;
        if (point > max) point = max;
        return point;
    }

    public double[] toArray() {
        return new double[]{x, y};
    }

    public double getGoldDensity() {
        return this.goldDensity;
    }

    @Override
    public String toString() {
        // return super.toString();
        return x + "," + y + "," + goldDensity;
    }

    @Override
    public int compareTo(Point o) {
        if (this.goldDensity == o.goldDensity) return 0;
        return this.goldDensity > o.goldDensity ? 1 : -1;
    }
}
