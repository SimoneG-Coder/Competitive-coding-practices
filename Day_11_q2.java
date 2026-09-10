//Min Stack
//Time complexity of stack function

class MinStack {
public:
    MinStack() {
        // Constructor initializes empty stacks
    }
    
    void push(int val) {
        st.push(val);
        // Push the minimum so far into minSt
        if (minSt.empty() || val < minSt.top()) {
            minSt.push(val);
        } else {
            minSt.push(minSt.top());
        }
    }
    
    void pop() {
        st.pop();
        minSt.pop();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return minSt.top();
    }

private:
    stack<int> st;     // Main stack
    stack<int> minSt;  // Stack to track minimums
};
