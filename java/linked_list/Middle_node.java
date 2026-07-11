
//https://leetcode.com/problems/middle-of-the-linked-list/submissions/

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

public class Middle_node {
    public static void main(String[] args) {

    ListNode middleNode = middleNode(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    
    System.out.println("Middle node value: " + middleNode.val);
    }

    public static ListNode middleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
