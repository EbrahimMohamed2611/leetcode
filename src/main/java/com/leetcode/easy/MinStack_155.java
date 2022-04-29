package com.leetcode.easy;


import java.util.Stack;

/**
 *
 * Time O(1)
 * Space O(n)
 * Runtime: 5 ms, faster than 78.08% of Java online submissions for Min Stack.
 * Memory Usage: 43.9 MB, less than 94.35% of Java online submissions for Min Stack.
 */
public class MinStack_155 {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> auxiliaryStack = new Stack<>();

    public MinStack_155() {

    }

    public void push(int val) {
        stack.push(val);
        if (auxiliaryStack.isEmpty()) {
            auxiliaryStack.push(val);
        } else {
            Integer currentMinElement = auxiliaryStack.peek();
            if (currentMinElement <= val) {
                auxiliaryStack.push(currentMinElement);
            } else {
                auxiliaryStack.push(val);
            }
        }

    }

    public void pop() {
        auxiliaryStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return auxiliaryStack.peek();
    }

    public static void main(String[] args) {

        MinStack_155 obj = new MinStack_155();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); // return -3
        obj.pop();
        System.out.println(obj.top());    // return 0
        System.out.println(obj.getMin());  // return -2

    }
}
