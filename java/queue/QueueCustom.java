class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capcaity;

    public Queue(int size) {
        arr = new int[size];
        capcaity = size;
        front = 0;
        rear = -1;
    }

    // Enqueue operations
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        arr[++rear] = value;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }
        int value = arr[front];
        front = front + 1;
        return value;
        // Or return arr[front++];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return front > rear;
        return size() == 0;
    }

    public boolean isFull() {
        return rear == capcaity - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class QueueCustom {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued element: " + queue.dequeue());

        queue.display();
    }
}


public class ArrayQueue {
    
    private final int arr[];
    private int front;
    private int rear;
    private int size;
    
    public ArrayQueue(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int value) {
        
        if(size == arr.length) {
            throw new RuntimeException("Queue Overflow!");
        }
        
        rear++;
        
        arr[rear] = value;
        
        size++;
    }
    
    public int dequeue() {
        
        if(isEmpty()) {
            throw new RuntimeException("Queue Underflow!");
        }
        
        int value = arr[front];
        
        front++;
        
        size--;
        
        return value;
    }
    
    public int front() {
        
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        
        return arr[front];
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}


