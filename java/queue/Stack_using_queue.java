//https://leetcode.com/problems/implement-stack-using-queues/description/

public class Stack_using_queue {
    
}




 




class MyStack {

    private Queue <Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void class Traping_Rain_Waterpush(int x) {
        q.add(x);
        for(int i = 0; i < q.size() - 1;i++) {
            q.add(q.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

//https://leetcode.com/problems/number-of-recent-calls/description/

Queue<Integer> q = new LinkedList<>();

    public RecentCounter() {
    }
    
    public int ping(int t) {
        q.offer(t);
        while(q.peek() < t - 3000) q.poll();
        return q.size();
    }scsc