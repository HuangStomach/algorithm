/**
 * 课程表
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        int plen = prerequisites.length;
        if (plen == 0) {
            return true;
        }

        int[] marked = new int[numCourses];
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }

        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, marked)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, HashSet<Integer>[] graph, int[] marked) {
        if (marked[i] == 1) {
            // 从正在访问中，到正在访问中，表示遇到了环
            return true;
        }

        if (marked[i] == 2) {
            // 表示在访问的过程中没有遇到环，这个节点访问过了
            return false;
        }
        // 走到这里，是因为初始化呢，此时 marked[i] == 0
        // 表示正在访问中
        marked[i] = 1;
        // 后继结点的集合

        for (Integer successor : graph[i]) {
            if (dfs(successor, graph, marked)) {
                // 层层递归返回 true ，表示图中存在环
                return true;
            }
        }
        // i 的所有后继结点都访问完了，都没有存在环，则这个结点就可以被标记为已经访问结束
        // 状态设置为 2
        marked[i] = 2;
        // false 表示图中不存在环
        return false;
    }
}