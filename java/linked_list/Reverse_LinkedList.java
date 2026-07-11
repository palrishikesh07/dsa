
//https://leetcode.com/problems/reverse-linked-list/


/**
 * 
 * 
 *      ListNode  current = head;
        ListNode  prev = null;
        
        while(current != null){
            ListNode next = current.next; // This is simple to take next value

            current.next = prev; // make next by previous value
            prev = current; // after that my current will become prevous for next iteratin.

            current = next; // This is also simple to travel in next..
        }
        return prev;
 * 
 * 
 * ListNode
 */
class ListNode {

    int val;
    ListNode next;
    

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Reverse_LinkedList {
    public static void main(String[] args) {

         ListNode reversed = reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
         printList(reversed);
        
        
    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr!=null) {
            // Step1 save next node
            ListNode next = curr.next;

            // Step2 Reverse the link List, set curr.next to prev value first it is null then in reverse order it will be set to the previous node
            curr.next = prev;

            // Step3: Move prev, now current will be previous node in next iteration.
            prev = curr;
             
            // Step4 move current to next node, which we saved in step1
            curr = next;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
}
