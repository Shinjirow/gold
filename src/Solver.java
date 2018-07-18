import java.util.Collections;
import java.util.PriorityQueue;

public class Solver extends Object {

    private static double[] bestPoint = new double[2];
    private static double best = Double.MIN_VALUE;

    public final double MIN = -1.0e6;
    public final double MAX = 1.0e6;

    private void run() {
        RandomWalk aWalker = new LevyWalker();
        Point aPoint = ((LevyWalker) aWalker).getPoint();
        System.err.println(aPoint);
        this.changeMax(aPoint.toArray(), aPoint.getGoldDensity());
        //PriorityQueue<Point> aQueue = new PriorityQueue<>(11000, Collections.reverseOrder());

        for (int i = 1; i < Gold.EvalMax; i++) {
            aWalker.walk();
            this.changeMax(aPoint.toArray(), aPoint.getGoldDensity());
            //aPoint = new Point(MIN + (MAX - MIN) * Math.random(), MIN + (MAX - MIN) * Math.random());
            System.err.println(aPoint);
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
            bestPoint[0] = point[0];
            bestPoint[1] = point[1];
        }
    }

    public static void answer() {
        Solver solver = new Solver();
        solver.run();
        Gold.submit(bestPoint);
    }
}
