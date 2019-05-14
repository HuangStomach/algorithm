/**
 * 最小高度树
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 */
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    private boolean[][] graph;
    private boolean[] visited;
    private int[] e;
    private Queue<Integer> queue;
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        graph = new boolean[n][n];
        visited = new boolean[n];
        e = new int[n];
        queue = new LinkedList<>();

        //初始化构建图
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph[a][b] = true;
            graph[b][a] = true;
            e[a]++;
            e[b]++;
            
        }

        //去除最外层的节点
        while (n > 2){
            //遍历图,找到最外层节点
            for (int i = 0; i < e.length; i++) {
                if (e[i] == 1) queue.add(i);
            }

            while (!queue.isEmpty()) {
                int v = queue.poll();
                e[v]--;
                n--;
                visited[v] = true;
                for (int i = 0; i < graph[v].length; i++){
                    if (graph[v][i]) {
                        e[i]--;
                        graph[v][i] = false;
                        graph[i][v] = false;
                    }
                }
            }            
        } 

        List<Integer> rt = new ArrayList<>();
        for (int i = 0;i < visited.length; i++) {
            if (!visited[i]) rt.add(i);
        }
        return rt;
    }
}
