class Check {
    public static void main(String[] args) {
        int pq[] = new int[15];
        System.out.println(less(pq, 0));
    }

    private static boolean less(int[] pq, int index) {
        if (index > pq.length) return true;
        boolean left = pq[index] < pq[2 * index + 1] && less(pq, 2 * index + 1);
        boolean right = pq[index] < pq[2 * index + 2] && less(pq, 2 * index + 2);
        return left && right;
    }
}