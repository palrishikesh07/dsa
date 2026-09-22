//https://leetcode.com/problems/merge-k-sorted-lists/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class C_31_Merge_K_Sorted_Lists{
    public static void main(String[] args) {


        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        // CollectSortBruteForce solution = new CollectSortBruteForce();

        SequentialMerging solution = new SequentialMerging();
        ListNode mergedHead = solution.mergeListsBrute(lists);


        // Print the merged list
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " ");
            mergedHead = mergedHead.next;
        }
        
    }
}

/* 
Brute Force — Collect + Sort
Put all values into an array and sort.

Time:  O(N log N)
Space: O(N)

*/
class CollectSortBruteForce{
    public ListNode  mergeListsBrute(ListNode[] lists){
        List<Integer> values = new ArrayList<>();

        for(ListNode head : lists){
            ListNode curr = head;
            while (curr != null) {
                values.add(curr.val);
                curr = curr.next;
            }
        }

        Collections.sort(values);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int value : values){
            curr.next = new ListNode(value);
            curr =curr.next;
        }

        return dummy.next;

    }

}

/*
Better — Sequential Merging

*/


class SequentialMerging{
    public ListNode  mergeListsBrute(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode result = null;

        for(ListNode list : lists){
            result = mergeTwoList(result,list);
        }
    
        return  result;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummmy = new ListNode(0);
        ListNode curr = dummmy;

        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                curr.next = l1;
                l1=l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1:l2;

        return dummmy.next;
    }
}

/*
Optimal — Min Heap
This is the most important solution to know for interviews.
Idea
Put the first node of every list into a min heap.


k = number of linked lists
N = total number of nodes

Time:  O(N log k)
Space: O(k)
*/

class MinHeapOptimal{

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0){
            return  null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));

        //Add first node from every list

        for(ListNode list:lists){
            if(list != null){
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            // Get smallest node
            ListNode node = minHeap.poll();

             // Add it to result
             curr.next = node;
             curr = curr.next;

              // Add next node from same list
              if(node.next !=null){
                minHeap.offer(node.next);
              }
        }
        return dummy.next;

    }
}