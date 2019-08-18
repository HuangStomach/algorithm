// 你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值
// -1 表示墙或是障碍物
// 0 表示一扇门
// INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
// 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
#include <vector>
#include <queue>

using std::vector;
using std::queue;
using std::pair;
using std::make_pair;

class Solution {
public:
    void wallsAndGates(vector<vector<int>>& rooms) {
        int m = rooms.size();
        if (m == 0) return;
        int n = rooms[0].size();
        if (n == 0) return;

        int d[4][2] = {{-1,0},{1,0},{0,-1},{0,1}};
        queue<pair<int, int>> q;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0) {
                    q.push(make_pair(row, col));
                }
            }
        }

        while (!q.empty()) {
            pair<int, int> point = q.front();
            q.pop();
            for (auto i : d) {
                int x = point.first + i[0];
                int y = point.second + i[1];
                if (x < 0 || y < 0 || x >= m || y >= n || rooms[x][y] != INT_MAX) {
                    continue;
                }
                rooms[x][y] = rooms[point.first][point.second] + 1;
                q.push(make_pair(x, y));
            }
            
        }   
    }
};