/**
 * N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */

import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    
    private void helper(Node root, List<List<Integer>> res, int depth) {
        if (root==null) return;
        if (res.size() - 1 < depth) res.add(new ArrayList<Integer>());
        res.get(depth).add(root.val);
        for (Node child : root.children) {
            helper(child, res, depth + 1);
        }
    } 
}