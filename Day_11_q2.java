//Min Stack
//Time complexity of stack functions
//Top of monotinic decreasing stacks will be minimum value and top od monotonic increasing stack will always be max
import java.util.Stack;

class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);

        // Push the minimum so far into minSt
        if (minSt.empty() || val < minSt.peek()) {
            minSt.push(val);
        } else {
            minSt.push(minSt.peek());
        }
    }

    public void pop() {
        st.pop();
        minSt.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
