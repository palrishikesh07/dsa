//https://leetcode.com/problems/linked-list-cycle/description/

import java.util.HashSet;
import java.util.Set;

public class C_30_Linked_List_Cycle {
    public static void main(String[] args) {
        
        BruteForceHashSet solution1 = new BruteForceHashSet();
        SlowFast solution2 = new SlowFast();

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create a cycle

        System.out.println("Brute Force HashSet: " + solution1.hasCycle(head));
        System.out.println("Slow Fast Pointer: " + solution2.hasCycle(head));
        
    }
}


/*
Brute Force — HashSet

Store every visited node.


Important:

Use the node itself, not node.val.
Two different nodes can have the same value.
Complexity
Time:  O(n)
Space: O(n)

*/


class BruteForceHashSet{
    public boolean hasCycle(ListNode head){
        Set<ListNode> visited = new HashSet<>();

        ListNode curr = head;

        while (curr != null) {
            if(visited.contains(curr)){
                return  true;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return  false;
    }
}

/*
Optimal — Floyd's Cycle Detection
Slow - 1 steps
Fast - 2 steps
*/


class SlowFast{
    
    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast !=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return  true;
            }
        }
        return false;
    }
}

