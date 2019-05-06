import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (q.size() > 0) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val + ",");
            q.add(node.left);
            q.add(node.right);
        }

        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() < 3) return null;
        data = data.substring(1);
        data = data.substring(0, data.length() - 1);
        String[] strs = data.split(",");
        if (strs.length == 0) return null;
        TreeNode head = new TreeNode(Integer.parseInt(strs[0]));

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(head);
        int i = 1;
        while (i < strs.length) {
            TreeNode node = q.poll();
            if (strs[i].equals("null")) node.left = null;
            else {
                node.left = new TreeNode(Integer.parseInt(strs[i]));
                q.add(node.left);
            }
            i++;

            if (strs[i].equals("null")) node.right = null;
            else {
                node.right = new TreeNode(Integer.parseInt(strs[i]));
                q.add(node.right);
            }
            i++;
        }
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));