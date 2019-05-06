/**
 * LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 */
import java.util.HashMap;

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> caches;
    private Node first;
    private Node last;
 
    class Node {
        Node next;
        Node pre;
        int key;
        int value;
    }
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        caches = new HashMap<>(capacity);
    }
 
    public void put(int key, int value) {
        Node node = caches.get(key);
        if (node == null){
            if (capacity <= caches.size()) removeLast();
            node = new Node();
            node.key = key;
        }
        node.value = value;
        moveNodeToFirst(node);
        caches.put(key, node);
    }
 
    private void removeLast() {
        if (last == null) return;
        caches.remove(last.key);
        // 最后
        last = last.pre;
        if (last != null) last.next = null;
        else first = null;
    }
 
    private void moveNodeToFirst(Node node) {
        if (node == first || node == null) return;
        if (node.pre != null) node.pre.next = node.next;
        if (node.next != null) node.next.pre = node.pre;
        if (node == last) last = last.pre;
        if (last == null || first == null) {
            last = first = node;
            return;
        }
        node.next = first;
        first.pre = node;
        first = node;
        node.pre = null;
    }
 
    public int get(int key) {
        Node node = caches.get(key);
        if (node == null) return -1;
        moveNodeToFirst(node);
        return node.value;
    }
 
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */