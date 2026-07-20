
public class Path_Sum{
    public static void main(String[] args) {
        
    }
}


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //No Node
        if(root == null){
            return false;
        }

        // Leaf node (Comparing leaf node value with target sum if matching return true or false)
        if(root.left == null && root.right == null){
            // Checking last leaf value with reamining targetsum value
            return targetSum == root.val;
        }
        
        // Check left OR right subtree

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
