//https://www.geeksforgeeks.org/problems/sum-of-k-smallest-elements-in-bst3029/1

import org.w3c.dom.Node;

public class Sum_k_Smallest {
    public static void main(String[] args) {
        
    }
}


class Solution {


    int sum = 0;
    int count = 0;


    int sum(Node root, int k) {
        inOrder(root,k);
        return sum;
    }


    private void inOrder(Node root, int k){
        if(root == null || k == count) {
            return;
        }

        inOrder(root.left, k);

        if(count < k){
            sum +=root.data;
            count++;
        }

        inOrder(root.right, k);
    }
}



class Solution {

    public int sum(Node root, int k) {

        int sum = 0;
        int count = 0;

        Node curr = root;

        while (curr != null) {

            if (curr.left == null) {

                // Visit current node
                sum += curr.data;
                count++;

                if (count == k)
                    return sum;

                curr = curr.right;

            } else {

                Node pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {

                    // Create thread
                    pred.right = curr;
                    curr = curr.left;

                } else {

                    // Remove thread
                    pred.right = null;

                    // Visit current node
                    sum += curr.data;
                    count++;

                    if (count == k)
                        return sum;

                    curr = curr.right;
                }
            }
        }

        return sum;
    }
}