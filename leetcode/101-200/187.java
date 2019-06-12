/**
 * 重复的DNA序列
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeat = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String curr = s.substring(i, i + 10);
            if (!seen.add(curr)) repeat.add(curr);
        }

        return new ArrayList<>(repeat);
    }
}