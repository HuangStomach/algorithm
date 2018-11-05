import edu.princeton.cs.algs4.*;

class IntervalLookup {
    static ST<Integer, Integer> st;
    public static void main(String[] args) {
        st = new ST();
        st.put(Integer.valueOf(1514768400), Integer.valueOf(1514771400));

        System.out.println(index(Integer.valueOf(1514770200)));
    }

    public static int index(Comparable key) {
        int i = 0;
        for (Integer min: st.keys()) {
            i++;
            Integer max = st.get(min);
            if (key.compareTo(min) >= 0 && key.compareTo(max) <= 0) return i;
        }
        return 0;
    }
}
