public class Solver extends Object {

    private static double[] bestPoint = new double[2];
    private static double best = -Double.MAX_VALUE;

    public final double MIN = -1.0e6;
    public final double MAX = 1.0e6;

    private void run() {
        RandomWalk aWalker = new LevyWalker();
        Point aPoint = aWalker.getPoint();
        System.err.println(aPoint);
        this.changeMax(aPoint.toArray(), aPoint.getGoldDensity());
        //PriorityQueue<Point> aQueue = new PriorityQueue<>(11000, Collections.reverseOrder());

        for (int i = 1; i < Gold.EvalMax; i++) {
            aWalker.walk();
            this.changeMax(aWalker.getPoint().toArray(), aWalker.getPoint().getGoldDensity());

            if (aWalker.isImproved()) {
                System.out.println("Yes, before = " + aWalker.getPoint());
                HillClimber aClimber = new HillClimber((Point) aWalker.getPoint().clone());
                int limit = i + 200 >= Gold.EvalMax - 1 ? Gold.EvalMax - i - 1 : 200;
                Point topOfTheMountain = aClimber.climb(limit);
                this.changeMax(topOfTheMountain.toArray(), topOfTheMountain.getGoldDensity());
                i += limit;
                System.out.println("      After = " + topOfTheMountain);
            }
            //aPoint = new Point(MIN + (MAX - MIN) * Math.random(), MIN + (MAX - MIN) * Math.random());
            // System.err.println(aPoint);
            //aQueue.add(aPoint);
        }
        //Point bestOne = aQueue.poll();

        //bestPoint = bestOne.toArray();
    }

    /**
     * 最初に与えられるランダムに座標生やすやつ
     */
    private void randomMove() {
        double value;
        double[] p = new double[2];
        p[0] = MIN + (MAX - MIN) * Math.random();
        p[1] = MIN + (MAX - MIN) * Math.random();
        value = Gold.evaluate(p);
        // System.out.println(i + "," + value);
        this.changeMax(p, value);

    }

    private void changeMax(double[] point, double value) {
        if (best < value) {
            best = value;
            bestPoint = point;
        }
        return;
    }

    public static void answer() {
        Solver solver = new Solver();
        solver.run();
        // solver.test();
        Gold.submit(bestPoint);

        return;
    }

    private void test() {
        HillClimber aClimber = new HillClimber(new Point());
        Point res = aClimber.climb(9999);
        this.changeMax(res.toArray(), res.getGoldDensity());
    }
}
