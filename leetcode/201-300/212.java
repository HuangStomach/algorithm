/**
 * 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 */

import java.util.ArrayList;
import java.util.List;

// 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
class Solution {
    ArrayList<String> list = new ArrayList<String>();
    Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0) return list;
        this.trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                this.findWord(board, i, j, "");
            }
        }
        return this.list;
    }

    private void findWord(char[][] board, int i, int j, String str) {
        char c = board[i][j];
        str += c;
        board[i][j] = ' ';

        if (!this.trie.startsWith(str)) {
            board[i][j] = c;
            return;
        }

        if (this.trie.search(str) && !list.contains(str)) {
            this.list.add(str);
        }

        if (i - 1 >= 0 && board[i - 1][j] != ' ') {
            findWord(board, i - 1, j, str);
        }

        if (i + 1 < board.length && board[i + 1][j] != ' ') {
            findWord(board, i + 1, j, str);
        }

        if (j - 1 >= 0 && board[i][j - 1] != ' ') {
            findWord(board, i, j - 1, str);
        }
        
        if (j + 1 < board[0].length && board[i][j + 1] != ' ') {
            findWord(board, i, j + 1, str);
        }

        board[i][j] = c;
    }
}

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
            int index = word.charAt(i) - 'a';
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
            int index = word.charAt(i) - 'a';
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
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) return false;
            node = node.children[index];
        }
        return node != null;
    }
}
