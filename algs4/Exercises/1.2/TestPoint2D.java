import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.*;

public class TestPoint2D {
    public static void main(String[] args) {
        int N = 50;
        double distance = Double.POSITIVE_INFINITY;
        List<Point2D> list = new ArrayList<>();
        Point2D[] couple = new Point2D[2];

        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            Point2D point = new Point2D(x, y);
            point.draw();
            if (list.size() > 0) {
                for (int j = 0; j < list.size(); j++) {
                    double compare = point.distanceTo(list.get(j));
                    if (compare < distance) {
                        distance = compare;
                        couple[0] = point;
                        couple[1] = list.get(j);
                    }
                }
            }
            list.add(point);
        }

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(couple[0].x(), couple[0].y(), couple[1].x(), couple[1].y());
        System.out.println(distance);
    }
}