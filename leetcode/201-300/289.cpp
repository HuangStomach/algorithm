// 生命游戏
// 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
// 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
// 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
// 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。

#include <vector>

using std::vector;

class Solution {
// 2死了等活 3活着等死
public:
    void gameOfLife(vector<vector<int>>& board) {
        if (board.size() == 0) return;
        int m = board.size();
        if (board[0].size() == 0) return;
        int n = board[0].size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = status(i, j, board);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 3) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
private:
    int d[8][2] = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

    int status(int i, int j, vector<vector<int>>& board) {
        int m = board.size();
        int n = board[0].size();

        int live = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + d[k][0];
            int y = j + d[k][1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;

            if (board[x][y] == 1 || board[x][y] == 3) live++;
        }

        int status = board[i][j];
        if (live == 2 || live == 3) {
            if (live == 3 && status == 0) return 2;
            if (status == 0) return 0;
            return 1;
        }
        else {
            return status == 0 ? 0 : 3;
        }
    }
};