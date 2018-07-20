
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean flag[] = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (flag[i] == false) {
                count++;
                for (int j = 1; j * i < n ; j++) {
                    flag[j * i] = true;
                }
            }
        }
        return count;
    }
}
