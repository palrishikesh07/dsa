

//https://www.geeksforgeeks.org/problems/implement-queue-using-array/1
public class LinkedListQueue {
    
    private static class Node {
        
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    private Node front;
    private Node rear;
    private int size;
    
    public void enqueue(int value) {
        
        Node node = new Node(value);
        
        if(rear == null ) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        
        size++;
        
    }
    
    public void dequeue() {
        
        if(isEmpty()) {
            throw new RuntimeException("Queue Underflow!");
        }
        
        int value = front.data;
        
        front = front.next;
        
        if(front == null) {
            rear = null;
        }
        
        size--;
        
        return value;
    }
    
    public int front() {
        
        if(isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        
        return front.data;
    }
    
    public boolean isEmpty() {
        return size == 0;
        
    }
    
}