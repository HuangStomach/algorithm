// 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
class Trie {
    Node root;

    private class Node {
        Node[] children;
        boolean isEnd;

        Node(boolean isEnd) {
            this.isEnd = isEnd;
            children = new Node[26];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node(false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.length() == 0) return;

        int length = word.length();
        Node node = root;

        for (int i = 0; i < length; i++) {
            int index = word.charAt(i) - 97;
            if (node.children[index] == null) node.children[index] = new Node(false);
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.length() == 0) return true;

        int length = word.length();
        Node node = root;

        for (int i = 0; i < length; i++) {
            int index = word.charAt(i) - 97;
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node != null && node.isEnd == true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) return true;

        int length = prefix.length();
        Node node = root;

        for (int i = 0; i < length; i++) {
            int index = prefix.charAt(i) - 97;
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */