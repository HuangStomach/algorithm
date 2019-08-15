// 锯齿迭代器
// 给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。
#include <vector>

using std::vector;

class ZigzagIterator {
public:
    vector<int> v;
    int index = 0;

    ZigzagIterator(vector<int> &v1, vector<int> &v2) {
        int i = 0, j = 0;
        while(i < v1.size() || j < v2.size()) {
            if (i < v1.size() && j < v2.size()) {
                v.push_back(v1[i++]);
                v.push_back(v2[j++]);
            }
            else if (i < v1.size()) {
                v.push_back(v1[i++]);
            }
            else if (j < v2.size()) {
                v.push_back(v2[j++]);
            }
        }
    }

    int next() {
        if (!hasNext()) return 0;
        return v[index++];
    }

    bool hasNext() {
        return index < v.size();
    }
};

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i(v1, v2);
 * while (i.hasNext()) cout << i.next();
 */