//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/





class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }




public class Maximum_Depth_Binary_Tree {
    public static void main(String[] args) {
        // int[] root = {3,9,20,null,null,15,7}; // Simple representation of the binary tree
        // TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));


        // int[] root = {1,null,2}; // Simple representation of the binary tree
        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        

        Maximum_Depth_Binary_Tree solution = new Maximum_Depth_Binary_Tree();
        int maxDepth = solution.maxDepth(root);
        System.out.println("Maximum Depth of the Binary Tree: " + maxDepth);

    }

    public int maxDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }

         int leftDept = maxDepth(root.left);
         int rightDept = maxDepth(root.right);

         return Math.max(leftDept, rightDept)+1;

    }   

}



/*
Time & Space Complexity
Time: O(n) — Every node is visited exactly once.
Space: O(h) — Due to the recursion call stack, where h is the height of the tree. In the worst case (a skewed tree), this becomes O(n).

Interview Tip to Remember

Whenever you see a Binary Tree problem involving:

Height
Maximum Depth
Minimum Depth
Diameter
Balanced Tree

think:

"At each node, ask the same question about the left subtree and the right subtree, then combine the answers."

For maximum depth, the combination rule is:

Depth of current node
=
max(Left Depth, Right Depth)
+ 1
*/