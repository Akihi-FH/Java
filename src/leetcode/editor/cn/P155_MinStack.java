//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 732 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P155_MinStack {
    public static void main(String[] args) {
        MinStack solution = new P155_MinStack().new MinStack();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * LinkedList实现Deque 当作栈
     * 优先使用Deque
     * 栈和辅助站同步存储
     */
    /*class MinStack {

        Deque<Integer> data;
        Deque<Integer> minStack;

        public MinStack() {
            data = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            data.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            data.pop();
            minStack.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }*/

    /**
     * 栈和辅助栈不同步
     */
    class MinStack {

        Deque<Integer> data;
        Deque<Integer> minStack;

        public MinStack() {
            data = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            data.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            int d = data.pop();
            if (d == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }


    /**
     * 栈和辅助栈
     */
    /*class MinStack {

        Stack<Integer> data;
        Stack<Integer> minStack;

        *//**
     * initialize your data structure here.
     *//*
        public MinStack() {
            data = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            data.pop();
            minStack.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}

