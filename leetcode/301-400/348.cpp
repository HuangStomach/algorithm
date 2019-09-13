// 判定井字棋胜负
// 请在 n × n 的棋盘上，实现一个判定井字棋（Tic-Tac-Toe）胜负的神器，判断每一次玩家落子后，是否有胜出的玩家。
// 在这个井字棋游戏中，会有 2 名玩家，他们将轮流在棋盘上放置自己的棋子。
// 在实现这个判定器的过程中，你可以假设以下这些规则一定成立：
//       1. 每一步棋都是在棋盘内的，并且只能被放置在一个空的格子里；
//       2. 一旦游戏中有一名玩家胜出的话，游戏将不能再继续；
//       3. 一个玩家如果在同一行、同一列或者同一斜对角线上都放置了自己的棋子，那么他便获得胜利。

#include <vector>

using std::vector;
using std::pair;

class TicTacToe {
public:
    int n;
    vector<vector<int>> map;
    vector<vector<int>> col;
    vector<vector<int>> row;
    vector<vector<int>> cross;
    /** Initialize your data structure here. */
    TicTacToe(int n) {
        this->n = n;
        map = vector(n, vector(n, 0));
        col = vector(n, vector(3, 0));
        row = vector(n, vector(3, 0));
        cross = vector(2, vector(3, 0));
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    int move(int row, int col, int player) {
        if (map[row][col] != 0) return 0;
        map[row][col] = player;
        
        if (++this->col[col][player] == n) return player;
        if (++this->row[row][player] == n) return player;
        if (row == col) {
            if (++this->cross[0][player] == n) return player;
        }
        if (row + col == n - 1) {
            if (++this->cross[1][player] == n) return player;
        }
        return 0;
    }
};

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe* obj = new TicTacToe(n);
 * int param_1 = obj->move(row,col,player);
 */