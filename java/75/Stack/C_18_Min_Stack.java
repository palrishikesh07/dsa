/*

push()
pop()
top()
getMin()

*/

import java.util.Stack;

class C_18_Min_Stack {
    public static void main(String[] args) {
        BruteForceSolution minStack = new BruteForceSolution();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-100);
        System.out.println(minStack.getMin()); // return -3

    }
}

class BruteForceSolution {
    Stack<Integer> stack = new Stack<>();

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int value : stack) {
            min = Math.min(value, min);
        }
        return min;
    }

}

class OptimalTwoStacks {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val){
        // Simply store the value int to stack
        stack.push(val);

        // Compare the value from minStack and store the min value into minStack
        if(minStack.isEmpty()){
            minStack.push(val);
        }
        else{
            int minStackPeek = minStack.peek();
            int minValue = Math.min(minStackPeek, val);
            minStack.push(minValue);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}

/*
Why do we need the second stack?
Answer:
"Because finding the minimum by scanning the main stack takes O(n). The auxiliary stack stores the minimum value corresponding to every stack state, allowing getMin() in O(1)."

*/