// 稀疏矩阵的乘法
// 给定两个 稀疏矩阵 A 和 B，请你返回 AB。你可以默认 A 的列数等于 B 的行数。
#include <vector>

using std::vector;

class Solution {
public:
    vector<vector<int>> multiply(vector<vector<int>>& A, vector<vector<int>>& B) {
        int m = A.size();
        int n = B[0].size();
        bool zeroRow[m];
        bool zeroCol[n];

        for (int i = 0; i < m; i++) {
            zeroRow[i] = true;
            for (int j = 0; j < A[0].size(); j++) {
                if (A[i][j] != 0) {
                    zeroRow[i] = false;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            zeroCol[i] = true;
            for (int j = 0; j < B.size(); j++) {
                if (B[j][i] != 0) {
                    zeroCol[i] = false;
                    break;
                }
            }
        }
        

        vector<vector<int>> res = vector<vector<int>>(m, vector<int>(n)); 
        for (int i = 0; i < m; i++) {
            if (zeroRow[i]) continue;
            for (int j = 0; j < n; j++) {
                if (zeroCol[j]) continue;
                for (int k = 0; k < B.size(); k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return res;
    }
};