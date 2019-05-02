/**
 * 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 */
import java.util.HashMap;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

class Solution {
    HashMap<Integer, Node> map;
    Node head;

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        this.map = new HashMap<>();
        this.head = copy(head);
        return this.head;
    }

    private Node copy(Node source) {
        Node node = new Node(source.val, null, null);
        this.map.put(node.val, node);
        if (source.next == null) {
            if (source.random != null) node.random = map.get(source.random.val);
            return node;
        }
        node.next = this.copy(source.next);
        if (source.random != null) node.random = map.get(source.random.val);
        return node;
    }
}