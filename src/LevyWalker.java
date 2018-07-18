public class LevyWalker extends Object implements RandomWalk {

    private Point aPoint;

    private Point bestPoint;

    private boolean isImproved;

    public LevyWalker() {
        this.aPoint = new Point();
        this.bestPoint = (Point) this.aPoint.clone();
        this.isImproved = false;
    }

    /**
     * LevyWalkアルゴリズムにしたがってランダムに移動する
     */
    public void walk() {
        this.isImproved = false;
        double angle = Math.random() * 2.0 * Math.PI;
        double distance = this.calculate();
        this.aPoint.moveTo(distance * Math.cos(angle), distance * Math.sin(angle));

        if (this.bestPoint.compareTo(this.aPoint) < 0) {
            this.bestPoint = (Point) this.aPoint.clone();
            this.isImproved = true;
        }

        return;
    }

    public boolean isImproved() {
        return this.isImproved;
    }

    /**
     * levy式に基づいてやるやつ
     * xの範囲を増やすとハズレの確率が増えてその場をちょろちょろが増える
     * valueの定数倍が増えると全体的にジャンプが増える
     * ラムダを変えると式の傾きが変わる
     *
     * @return
     */
    private double calculate() {
        double x = Math.random() * 89.0 + 1.0; // 1 to 1000
        double lambda = -1.25;
        double mul = 1.0 * 1e6;
        double value = Math.pow(x, lambda) * mul;
        return value;
    }

    public Point getPoint() {
        return this.aPoint;
    }
}
