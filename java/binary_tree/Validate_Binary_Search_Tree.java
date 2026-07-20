//https://leetcode.com/problems/validate-binary-search-tree/

public class Validate_Binary_Search_Tree {
    public static void main(String[] args) {
        
    }
}


class Solution {

    private TreeNode prev = null;


    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        

        // check left subtree
        if(!isValidBST(root.left)){
            return false;
        }

        // check current node, If the previous node is not null and its value is greater than or equal to the current node's value, then it's not a valid BST
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;

        return isValidBST(root.right);
        
    }
}
