public class HillClimber extends Object {

    private Point aPoint;

    public HillClimber() {
    }

    public HillClimber(Point aPoint) {
        this.aPoint = aPoint;
    }

    public Point climb(int limit) {
        int yes = 0, no = 0;
        double distance;
        double angle;

        for (int index = 0; index < limit; index++) {
            double x = limit - index;
            distance = x * x * 0.5;
            distance = Math.pow(x, 10) * Math.exp(-x/20) / 5e14;
            //System.out.println(distance);
            angle = Math.random() * 2.0 * Math.PI - Math.PI;
            Point after = (Point) this.aPoint.clone();
            after.moveTo(distance * Math.cos(angle), distance * Math.sin(angle));
            if (after.compareTo(this.aPoint) > 0) {
                this.aPoint = after;
                yes++;
            } else {
                no++;
                // System.out.println("failed, " + index);
            }
            //System.err.println(this.aPoint);
        }
        //System.out.println("yes "+ yes + ", no " + no);

        return this.aPoint;
    }
}
