import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C_27_Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        // BruteFoce solution = new BruteFoce();
        TwoPointerOptimal solution = new TwoPointerOptimal();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode mergedList = solution.mergeNode(l1, l2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        
    }
}


/*
Brute Force = Store + Sort
Put everything into an array, sort it, and create a linked list.
*/

class BruteFoce {
    public ListNode mergeNode(ListNode l1, ListNode l2){
        List<Integer> values= new ArrayList<>();

        while (l1 != null) {
            values.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            values.add(l2.val);
            l2 = l2.next;
        }
        
        Collections.sort(values);

        ListNode head = new ListNode(0);
        ListNode curr = head;

        for(int value: values){
            curr.next = new ListNode(value);
            curr = curr.next;
        }

        return  head.next;
    }
}

/*
Optimal — Two Pointers
Because both lists are already sorted, don't sort again.

Compare l1/l2
      ↓
Connect smaller
      ↓
Move that pointer

Time:  O(n + m)
Space: O(1)
*/

class TwoPointerOptimal{
    public ListNode mergeNode(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null){
            curr.next = l1;
        }
        else{
            curr.next = l2;
        }

        return  head.next;
    }
}


