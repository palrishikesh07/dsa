import java.util.Stack;

public class C_26_Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // BruteForceStack bruteForceStack = new BruteForceStack();
        // ListNode reversedHead = bruteForceStack.reverseList(head);

        OptimalIteration optimalIteration = new OptimalIteration();
        ListNode reversedHead = optimalIteration.reverseList(head);

        // Print the reversed linked list
        ListNode current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

    }
}

class BruteForceStack {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        Stack<ListNode> stack = new Stack<>();

        ListNode current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        ListNode newHead = stack.pop();
        current = newHead;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null; // For tails
        return newHead;

    }
}

/*
Time:  O(n)
Space: O(n)

*/

class OptimalIteration{
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
    
    while(curr!=null){
        ListNode next = curr.next; //// save next

        curr.next = prev;  // reverse link

        prev = curr; // move prev
        curr = next; // move curr

    }
    return prev;
 }
}

/*
Time:  O(n)
Space: O(1)

next = curr.next
curr.next = prev
prev = curr
curr = next

1 → 2 → 3 → null
prev   curr
 ↓      ↓
null    1
*/