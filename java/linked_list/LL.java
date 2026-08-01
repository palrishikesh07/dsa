
public class LL {
  
    // Head always points to first node of linked list
    private Node head;


    // Total number of nodes
    private int size = 0;

    // ==========================
    // Node Class
    // ==========================
    
    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    // =====================================================
    // Add Node at Beginning
    // Time Complexity : O(1)
    // =====================================================

    public void addFirst(String data) {
        Node newNode = new Node(data);

        // If list is empty
        if(head == null){
           head = newNode;
           size++;
           return; 
        }

        // New node points to current head, Linking newly created node to current head
        newNode.next = head; 

        // Move head to new node
        head = newNode;

        size++;
    }

    // =====================================================
    // Add Node at End
    // Time Complexity : O(n)
    // =====================================================

    public void addLast(String data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            size++;
            return;
        }

        Node current = head;
        
        //Move till last node
        while (current.next != null) {
            current = current.next;
        }

        // Add actual value
        current.next = newNode;
        size++;
    }
    
    // =====================================================
    // Print Linked List
    // =====================================================

    public void printList(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }


    // =====================================================
    // Return First Value
    // =====================================================

    public String getFirst(){
        if(head == null){
            return null;
        }

        return head.data;
    }

    // =====================================================
    // Return Last Value
    // =====================================================

    public String getLast(){
        if(head == null) return null;

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    // =====================================================
    // Search Element
    // Returns true if found
    // =====================================================

    public boolean search(String value){
        Node current = head;

        while (current != null) {
            if(current.data.equals(value))
                return true;

            current = current.next;
        }

        return false;
    }

    // =====================================================
    // Return Position of Element
    // Returns -1 if not found
    // =====================================================

    public int searchIndex(String value){

        Node current = head;
        int index = 0;
        
        while (current != null) {
            if(current.data.equals(value)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }


    // =====================================================
    // Delete First Node
    // =====================================================

    public void deleteFirst(){
        if(head == null) return;

        head = head.next;
        size--;
    }


    // =====================================================
    // Delete Last Node
    // =====================================================

    public void deleteLast(){
        if(head == null){
            return;
        }
        
        // Only one node
        
        if(head.next == null){
            head= null;
            size--;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    // =====================================================
    // Delete By Value
    // =====================================================

     public void deleteByValue(String value) {
        if (head == null)
            return;

        // First node contains value
        if(head.data.equals(value)){
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;
        }

        // If value not found
        if(current.next == null){
            return;
        }

        current.next = current.next.next;
        size--;

     }



    // =====================================================
    // Insert at Specific Position
    // Position starts from 0
    // =====================================================

    public void insertAtPosition(int position, String data){
        if(position < 0 || position > size){
            System.out.println("Invalid position ");
            return;
        }

        if(position == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        for(int i=0; i<position-1; i++){
            current = current.next;
        }

        newNode.next = current.next; // Assinging current next to new next
        current.next = newNode; // Current node to add new next
        size++;
    }

    // =====================================================
    // Delete Node at Position
    // =====================================================

    public void deleteAtPosition(int position){
        if(position < 0 || position >= size){
            System.out.println("Invalid Position");
            return;
        }

        if(position == 0){
            deleteFirst();
            return;
        }

        Node current = head;

        for(int i =0; i< position - 1; i++){
            current = current.next;
        }
        
        current.next = current.next.next; // Skipt next value
        size--;
    }


    // =====================================================
    // Reverse Linked List
    // =====================================================
    
    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {

            next = current.next; // Store current next value

            current.next = prev; // assing current next to prev

            prev = current; // Move current to prev

            current = next; // Move next to current
        }

        head = prev;
    }

    // =====================================================
    // Check Empty
    // =====================================================
    public boolean isEmpty() {
        return head == null;
    }

    // =====================================================
    // Return Size
    // =====================================================
    public int size() {
        return size;
    }


    // =====================================================
    // Remove All Nodes
    // =====================================================
    public void clear() {
        head = null;
        size = 0;
    }


    public static void main(String[] args) {
         LL list = new LL();

        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        list.addLast("D");
        list.addLast("E");
        
        System.out.println("Original List:");
        list.printList();
           System.out.println("\nFirst Value : " + list.getFirst());
        System.out.println("Last Value : " + list.getLast());

        System.out.println("\nSearch C : " + list.search("C"));
        System.out.println("Index of D : " + list.searchIndex("D"));

        list.deleteFirst();
        System.out.println("\nAfter deleteFirst()");
        list.printList();

        list.deleteLast();
        System.out.println("\nAfter deleteLast()");
        list.printList();

        list.insertAtPosition(1, "X");
        System.out.println("\nAfter insertAtPosition()");
        list.printList();

        list.deleteByValue("X");
        System.out.println("\nAfter deleteByValue()");
        list.printList();

        list.reverse();
        System.out.println("\nAfter Reverse()");
        list.printList();

        System.out.println("\nSize : " + list.size());
    }
}






/*

| Operation          | Time     |
| ------------------ | -------- |
| addFirst()         | **O(1)** |
| addLast()          | **O(n)** |
| deleteFirst()      | **O(1)** |
| deleteLast()       | **O(n)** |
| search()           | **O(n)** |
| searchIndex()      | **O(n)** |
| getFirst()         | **O(1)** |
| getLast()          | **O(n)** |
| insertAtPosition() | **O(n)** |
| deleteAtPosition() | **O(n)** |
| deleteByValue()    | **O(n)** |
| reverse()          | **O(n)** |
| printList()        | **O(n)** |
| size()             | **O(1)** |
| clear()            | **O(1)** |

*/