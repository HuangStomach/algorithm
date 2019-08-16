// 顶端迭代器
// 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
#include <vector>

using std::vector;

// Below is the interface for Iterator, which is already defined for you.
// **DO NOT** modify the interface for Iterator.

class Iterator {
    struct Data;
	Data* data;
public:
	Iterator(const vector<int>& nums);
	Iterator(const Iterator& iter);
	virtual ~Iterator();
	// Returns the next element in the iteration.
	int next();
	// Returns true if the iteration has more elements.
	bool hasNext() const;
};


class PeekingIterator : public Iterator {
private:
    Iterator* it;
    bool hasPeeked = false;
    int peekedElement = 0;
public:
	PeekingIterator(const vector<int>& nums) : Iterator(nums) {
        it = new Iterator(nums);
	}

    // Returns the next element in the iteration without advancing the iterator.
	int peek() {
        if (!hasPeeked) {
            peekedElement = it->next();
            hasPeeked = true;
        }
        return peekedElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	int next() {
        if (!hasPeeked) return it->next();
        hasPeeked = false;
        return peekedElement;
	}

	bool hasNext() const {
	    return hasPeeked || it->hasNext();
	}
};