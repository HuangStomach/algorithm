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
    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> postorder(Node root) {
        if (root == null) return list;
        
        int size = root.children.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                postorder(root.children.get(i));
            }
        }
        list.add(root.val);
        return list;
    }
}
