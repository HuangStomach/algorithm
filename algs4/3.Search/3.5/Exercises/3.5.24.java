import edu.princeton.cs.algs4.*;

class IntervalLookup {
    static ST<Integer, Integer> st;
    public static void main(String[] args) {
        st = new ST();
        st.put(Integer.valueOf(1643), Integer.valueOf(2033));
        st.put(Integer.valueOf(5532), Integer.valueOf(7643));
        st.put(Integer.valueOf(8999), Integer.valueOf(10332));
        st.put(Integer.valueOf(5666653), Integer.valueOf(5669321));

        System.out.println(index(Integer.valueOf(9122)));
        System.out.println(index(Integer.valueOf(8122)));
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
