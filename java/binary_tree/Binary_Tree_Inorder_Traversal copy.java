//https://leetcode.com/problems/binary-tree-inorder-traversal/
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Binary_Tree_Inorder_Traversal {
    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        inOrder(root, result);

        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {

        if(root == null){
        
            return;
        }

        inorder(node.left);
        inorder(root.left, result);
        result.add(node.val);
        inorder(node.right);
    }

}



class Solution {
    private List <Integer> answer;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        answer = new ArrayList<>();
        inorder(root);
        return answer;
    }

    public void inorder(TreeNode node) {

        if(node == null) {
            return;
        }
        
        inorder(node.left);
        answer.add(node.val);
        inorder(node.right);

    }
}


class SolutionIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (!stack.isEmpty() || curr != null) {
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result; 
    }
}
