class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    // Constructor
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Push operation
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is overflow");
            return;
        }
        arr[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}

public class StackCustom {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());

        stack.display();
    }

}