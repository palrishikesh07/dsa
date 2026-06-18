1. What is a Heap?

A Heap is a Complete Binary Tree that follows a special property.
Heap is a DS (CBT, Complete Binary Tree), that come with a Heap Order Property

What is CBT
- every level is completely filled except the last level
- nodes always added from the left or lean toward the left



Heap Order Property
- Max Heap (Parent node always have higher value)
- Min Heap (Child node will have lower value)

Max Heap
Parent is always greater than or equal to children.

       100
      /   \
     50    80
    / \   / \
   20 30 40 60
Min Heap

Parent is always smaller than or equal to children.

       10
      /  \
     20   30
    / \   / \
   40 50 60 70

2. Why Heap?

Finding largest element in array:

int[] arr = {5,2,8,1,9};

Without Heap:

Sort → O(n log n)

With Heap:

Insert → O(log n)
Get Max/Min → O(1)
3. Important Interview Theory
Complete Binary Tree

Every level is completely filled except possibly the last level.

      1
     / \
    2   3
   / \
  4   5

Valid Heap Structure.

Heap Operations
Operation	Complexity
Insert	O(log n)
Delete	O(log n)
Peek Top	O(1)
Build Heap	O(n)

Interviewers love asking this table.

4. Heap in Java

Java provides:

PriorityQueue

By default:

PriorityQueue<Integer> pq = new PriorityQueue<>();

This is a Min Heap.




"When should we use Heap?"
Answer:
Use Heap when we need to repeatedly access or remove the minimum/maximum element efficiently. Heap provides O(1) access to the top element and O(log n) insertion/deletion.