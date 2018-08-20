import edu.princeton.cs.algs4.*;

class Point extends Point2D {
    static int compareX(Point2D a, Point2D b) {
        return a.x.compareTo(b.x);
    }

    static int compareY(Point2D a, Point2D b) {
        return a.y.compareTo(b.y);
    }

    static compareO(Point2D a, Point2D b) {
        Point2D o = new Point2D(0, 0);
        return a.distTo(o).compareTo(b.distTo(o));
    }

    int compareDist(Point2D that, Point2D third) {
        return this.distTo(third).compareTo(that.distTo(third));
    }

    // 幅角咋求？
    int compareTheta(Point2D that, Point2D third) {
        return this.distTo(third).compareTo(that.distTo(third));
    }
}