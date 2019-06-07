/*
填充每个节点的下一个右侧节点指针 II
给定一个二叉树
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        Node node = null;
        if (root.left != null) {
            node = root.left;
        }
            
        if (root.right != null) {
            if (node != null) {
                node.next = root.right;
            }
            node = root.right;
        }

        if (node != null) {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
                node.next = temp.left != null ? temp.left : (temp.right != null ? temp.right : null);
                if (node.next != null) break;
            }
        }

        connect(root.right);
        connect(root.left);
        return root;
    }
}