//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Gold {
    private static double[] shift2 = new double[]{13.63837177D, -27.89950671D};
    private static int fnum = 7;
    private static double bairitsu = 10000.0D;
    private static double limit = 1000000.0D;
    private static double s = Math.toRadians(40.0D);
    private static int fcount;
    public static int EvalMax = 10000;
    private static int fcountmax;
    private static long start;
    private static long end;

    public Gold() {
    }

    public static void main(String[] var0) {
        start = System.currentTimeMillis();
        Solver.answer();
        System.out.println("*** No answer submitted. ***");
    }

    public static double evaluate(double[] var0) {
        double var1 = 0.0D;
        double[] var3 = new double[1];
        double[] var4 = new double[10];
        ++fcount;

        try {
            testfunc var9 = new testfunc();
            double var5 = var0[0] / bairitsu;
            double var7 = var0[1] / bairitsu;
            var4[2] = var5 * Math.cos(s) - var7 * Math.sin(s) - shift2[0];
            var4[7] = var5 * Math.sin(s) + var7 * Math.cos(s) - shift2[1];
            var9.test_func(var4, var3, var4.length, 1, fnum);
            var1 = 100.0D - (var3[0] - (double)fnum * 100.0D) / 0.02D;
        } catch (Exception var10) {
            var10.printStackTrace();
        }

        return var1;
    }

    public static void submit(double[] var0) {
        end = System.currentTimeMillis();
        if (var0.length != shift2.length) {
            System.out.println("*** Invalid array length. ***");
            System.exit(0);
        }

        if (var0[0] < -limit || var0[1] < -limit || var0[0] > limit || var0[1] > limit) {
            System.out.println("*** Invalid point. ***");
            System.exit(0);
        }

        if (fcount > fcountmax) {
            System.out.println("*** Too many evaluations. ***");
            System.exit(0);
        }

        System.out.println(evaluate(var0) + "\t" + var0[0] + "\t" + var0[1] + "\t" + (fcount - 1));
        System.out.println(end - start + "\t msecs.");
        System.exit(0);
    }

    static {
        fcountmax = EvalMax;
        fcount = 0;
    }
}
