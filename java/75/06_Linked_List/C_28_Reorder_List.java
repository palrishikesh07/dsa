
//https://leetcode.com/problems/reorder-list/description/

import java.util.ArrayList;
import java.util.List;

class C_28_Reorder_List {
    public static void main(String[] args) {
        BruteForce solution = new BruteForce();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        solution.reorderList(head);

        // Print the reordered list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

/*
 * 
 * Brute Force — ArrayList
 * Store nodes in an array/list.
 * 
 */

class BruteForce {
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        List<ListNode> list = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {

            list.get(left).next = list.get(right);
            left++;

            if (left == right)
                break;

            list.get(right).next = list.get(left);
            right--;
        }

        list.get(left).next = null;

    }

}

/*
 * 
 * Optimal — Three Steps
 * This is one of the most important linked-list interview patterns.
 * Remember:
 * MIDDLE → REVERSE → MERGE
 * 
 * Step 1 — Find middle
 * 
 * Use slow/fast pointers.
 * 
 * Step 2 — Reverse second half
 * Step 3 — Merge two halves
 * 
 */

class OptimalSolution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 1. Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. Reverse second half
        ListNode second = slow.next;
        ListNode prev = null;

        while (second != null) {
            ListNode next = second.next;

            second.next = prev;
            prev = second;
            second = next;
        }
        second = prev;

        // 3. Merge
        ListNode first = head;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next =  second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

    }
}

/*
1 → 2 → 3 | 4 → 5

        ↓ middle

1 → 2 → 3

4 → 5

        ↓ reverse

1 → 2 → 3

5 → 4

        ↓ merge

1 → 5 → 2 → 4 → 3


Time:  O(n)
Space: O(1)

"I'll split the list at the middle using slow/fast pointers, reverse the second half, and then alternately merge nodes from the two halves."
*/


