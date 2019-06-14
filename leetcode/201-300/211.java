/**
 * 添加与搜索单词 - 数据结构设计
 * 设计一个支持以下两种操作的数据结构：
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 */
class WordDictionary {
    public Node root;

    public class Node {
        public char c;
        public Node[] next;
        public boolean tail;
        public Node(char c) {
            this.c = c;
            this.tail = false;
            next = new Node[26];
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Node(c);
            }

            node = node.next[index];
        }

        node.tail = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root, 0);
    }

    public boolean search(String word, Node node, int index) {
        if (index == word.length()) return false;
        char c = word.charAt(index);
        if (c == '.') {
            for (Node n : node.next) {
                if (n == null) continue;
                if (word.length() == index + 1 && n.tail) return true;
                if (search(word, n, index + 1)) return true;
            }
            return false;
        }

        Node n = node.next[c - 'a'];
        if (n == null || c != n.c) return false;
        if (word.length() == index + 1 && n.tail) return true;
        if (word.length() > index && search(word, n, index + 1)) return true;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
