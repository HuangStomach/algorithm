/**
 * 以图判树
 * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
 */
#include <vector>

using std::vector;

class Solution {
    vector<int> p;
    
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        vector<int> roots(n, -1);
        for (auto a : edges) {
            int x = find(roots, a[0]);
            int y = find(roots, a[1]);
            if (x == y) return false;
            roots[x] = y;
        }
        return edges.size() == n - 1;
    }

    int find(vector<int> &roots, int i) {
        while (roots[i] != -1) i = roots[i];
        return i;
    }
};