/*
建立四叉树
我们想要使用一棵四叉树来储存一个 N x N 的布尔值网络。网络中每一格的值只会是真或假。树的根结点代表整个网络。对于每个结点, 它将被分等成四个孩子结点直到这个区域内的值都是相同的.
每个结点还有另外两个布尔变量: isLeaf 和 val。isLeaf 当这个节点是一个叶子结点时为真。val 变量储存叶子结点所代表的区域的值。
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return split(grid, 0, 0, grid.length);
    }

    public Node split(int[][] grid, int x, int y, int offset) {
        if (offset <= 0) return null;

        for (int i = x; i < x + offset; i++) {
            for (int j = y; j < y + offset; j++) {
                if (grid[i][j] != grid[x][y]){
                    return new Node(false, false,
                        split(grid, x, y, offset / 2),
                        split(grid, x, y + offset / 2, offset / 2),
                        split(grid, x + offset / 2, y, offset / 2),
                        split(grid, x + offset / 2, y + offset / 2, offset / 2)
                    );
                }
            }
        }
        return new Node(grid[x][y] == 1, true, null, null, null, null);
    }
}
