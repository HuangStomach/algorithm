/** 
 * 599. 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 */
#include <unordered_map>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> res;
    unordered_map<string, int> m;
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        int min = INT32_MAX;
        for (int i = 0; i < list1.size(); i++) {
            m[list1[i]] = i;
        }
        for (int i = 0; i < list2.size(); i++) {
            if (m.count(list2[i]) <= 0) continue;
            int index = m[list2[i]] + i;
            if (index > min) continue;

            if (index < min) {
                res.clear();
                min = index;
            }
            res.push_back(list2[i]);
        }
        
        return res;
    }
};