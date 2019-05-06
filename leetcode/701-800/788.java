class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        
        for (int i = 1; i <= N; i++) {
            String str = Integer.toString(i);
            boolean is = false;
            for (int j = 0; j < str.length(); j++) {
                char k = str.charAt(j);
                if (k == '3' || k == '4' || k == '7') {
                    is = false;
                    break;
                }
                else if (k == '2' || k == '5' || k == '6' || k == '9') is = true;
            }
            if (is) {
                count++;
                is = false;
            }
        }

        return count;
    }
}
