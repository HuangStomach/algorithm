class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int c = (int)str.charAt(i);
            if (c <= 90 && c >= 65) sb.append((char)(c + 32));
            else sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}