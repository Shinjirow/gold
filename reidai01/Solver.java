public class Solver {

    private static double[] bestPoint = new double[2];
    private static double best = Double.MIN_VALUE;


    private final double MIN = -1.0e6;
    private final double MAX = 1.0e6;

    private void run() {
        double value;
        double[] p = new double[2];

        for (int i = 0; i < Gold.EvalMax; i++) {
            p[0] = MIN + (MAX - MIN) * Math.random();
            p[1] = MIN + (MAX - MIN) * Math.random();
            value = Gold.evaluate(p);
//			System.out.println(i + "," + value);
            this.changeMax(p, value);

        }
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
