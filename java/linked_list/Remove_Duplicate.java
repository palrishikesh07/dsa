//https://www.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1

class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
}


public class Remove_Duplicate {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        Solution solution = new Solution();
        head = solution.removeDuplicates(head);
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }
    
}

class Solution {
    Node removeDuplicates(Node head) {
        
        Node current = head;

        while (current != null && current.next != null) {
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
        return head;
        
    }
}