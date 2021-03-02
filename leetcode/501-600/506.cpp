/** 
 * 506. 相对名次
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 */
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        vector<int> array;
        vector<string> result(score.size());
        for(int i = 0; i < score.size(); i++) array.push_back(i);
        sort(array.begin(), array.end(), [&score](const int& a, const int& b) { 
            return score[a] > score[b]; 
        });

        int j = 1;
        for (int i = 0; i < array.size(); i++) {
            if (j == 1) result[array[i]] = "Gold Medal";
            else if (j == 2) result[array[i]] = "Silver Medal";
            else if (j == 3) result[array[i]] = "Bronze Medal";
            else result[array[i]] = to_string(j);
            j++;
        }

        return result;
    }
};
