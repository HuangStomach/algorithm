import edu.princeton.cs.algs4.*;

class Point2D {
    private double x;
    private double y;

    public int hashCode() {
        return (Double.valueOf(x).hashCode() + Double.valueOf(y).hashCode()) % 997;
    }
}

// ... 后面的不写了