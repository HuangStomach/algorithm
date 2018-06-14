import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.*;

public class TestInterval1D {
    public static void main(String[] args) {
        int N = 50;
        List<Interval1D> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            Interval1D interval;
            if (x < y) interval = new Interval1D(x, y);
            else interval = new Interval1D(y, x);
            
            if (list.size() > 0) {
                for (int j = 0; j < list.size(); j++) {
                    Interval1D that = list.get(j);
                    if (interval.intersects(that)) {
                        System.out.println(interval + ":" + that);
                    }
                }
            }
            list.add(interval);
        }
    }
}