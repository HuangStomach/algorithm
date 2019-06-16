/**
 * 最短单词距离 III
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 * word1 和 word2 是有可能相同的，并且它们将分别表示为列表中两个独立的单词。
 */
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
        boolean equal = word1.equals(word2);

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (equal) {
                    if (left >= 0) min = Math.min(min, i - left);
                    left = i;
                    continue;
                }
                left = i;
                if (left >= 0 && right >= 0) min = Math.min(min, Math.abs(left - right));
            }
            else if (words[i].equals(word2)) {
                right = i;
                if (left >= 0 && right >= 0) min = Math.min(min, Math.abs(left - right));
            }
        }

        return min;
    }
}
