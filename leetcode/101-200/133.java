/**
 * 克隆图
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 */
import java.util.ArrayList;
import java.util.HashMap;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        HashMap<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }

    public Node clone(Node node, HashMap<Integer, Node> map) {
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(newNode.val, newNode);

        for (Node sub: node.neighbors) {
            if (map.containsKey(sub.val)) {
                newNode.neighbors.add(map.get(sub.val));
            }
            else newNode.neighbors.add(clone(sub, map));
        }

        return newNode;
    }
}