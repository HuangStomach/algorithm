class Solution {
    public String toGoatLatin(String S) {
        String list = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        String[] array = S.split(" ");
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            String a = Character.toString(str.charAt(0));

            if (list.indexOf(a) < 0) str = str.substring(1, str.length()) + a;
            str += "m";

            for (int j = -1; j <= i; j++) {
                str += "a";
            }
            if (i > 0) str = " " + str;

            sb.append(str);
        }
        return sb.toString();
    }
}