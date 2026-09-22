//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

public class C_29_Remove_N_Node_From_End {
    public static void main(String[] args) {
        BruteForce solution = new BruteForce();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        head = solution.removeNthFromEnd(head, n);

        // Print the modified list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        
    }
}

/*
First find length.

Then find the node before the target.

Time:  O(n)
Space: O(1)

*/
class BruteForce{
    public ListNode removeNthFromEnd(ListNode head, int n){
        int lenght = 0;
        ListNode curr = head;

        while (curr!= null) {
            lenght++;
            curr = curr.next;
        }

        if(n == lenght){
            return head.next;
        }

        curr = head;

        for(int i=1; i< lenght - n; i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }    
}

class FastSlowOptimal{
     public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Create gap of n nodes
        for(int i = 0; i<n; i++){
            fast = fast.next;
        }

        // Move together

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //Remove target
        slow.next = slow.next.next;

        return dummy.next;

     }
}

/*

Time:  O(n)
Space: O(1)

"I'll use two pointers with an n-node gap. When fast reaches the end, slow will be immediately before the node that needs to be removed."
*/

