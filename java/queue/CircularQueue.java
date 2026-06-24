class ArrayQueue {

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

        if (size == arr.length) {
            throw new RuntimeException("Queue Overflow!");
        }

        rear++;
        int position = size % arr.length;
        arr[position] = value;
        size++;
    }

    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow!");
        }

        int value = arr[front];

        front++;

        size--;

        return value;
    }

    public int front() {

        if (isEmpty()) {
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
public class CircularQueue {
     public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

    }
}




// public void enqueue(int value) {
        
//         if(isFull()) {
//             throw new RuntimeException("Queue Overflow!");
//         }
        
//         rear = (rear+1)%arr.length;
        
//         arr[rear] = value;
        
//         size++;
//     }
    
//     public int dequeue() {
        
//         if(isEmpty()) {
//             throw new RuntimeException("Queue Underflow!");
//         }
        
//         int value = arr[front];
//         front = (front+1)%arr.length;
        
//         size--;
        
//         return value;
//     }