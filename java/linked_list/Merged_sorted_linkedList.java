

//https://leetcode.com/problems/merge-two-sorted-lists/
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Merged_sorted_linkedList {
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // Solution solution = new Solution();
        SolutionCustom solution = new SolutionCustom();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        printList(mergedList);
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

// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

//         ListNode dummy = new ListNode(0);
//         ListNode node = dummy;

//         while (list1 != null && list2 != null) {

//             if (list1.val < list2.val) {
//                 node.next = list1;
//                 list1 = list1.next;
//             } else {
//                 node.next = list2;
//                 list2 = list2.next;
//             }

//             node = node.next;
//         }

//         if (list1 != null) {
//             node.next = list1;
//         } else {
//             node.next = list2;
//         }

//         return dummy.next;
//     }
// }

class SolutionCustom {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                node.next = list1; // store list 1 in Node of result
                list1 = list1.next; // next iteration
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next; // move node to next
        }

        if (list1 != null) {
            node.next = list1; // put all remaining list 1
        } else {
            node.next = list2; // put all list 2
        }

        return dummy.next; // Ignoring the first value that added as Zero
    }
}