// 重新安排行程
// 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
#include <vector>
#include <string>
#include <map>

using std::string;
using std::map;
using std::vector;

class Solution {
public:
    map <string, map<string, int>> G;
    bool find = false;
    vector <string> answer;
    vector <string> result;
    
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        for (auto &t : tickets) {
            string &from = t[0];
            string &to = t[1];
            G[from][to] += 1;
        }
        
        answer.push_back("JFK");
        dfs(tickets.size(), 0, "JFK");
        return result;
        
    }
    
    void dfs(const int n, int i, string from) {
        if (find) return;

        if (i == n) {
            result = answer;
            find = true;
            return;
        }
        
        for (auto &it : G[from]) {
            if (it.second == 0) continue;
            answer.push_back(it.first);
            it.second -= 1;
            dfs(n, i + 1, it.first);
            it.second += 1;
            answer.pop_back();
        }
    }
};