//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

/*


✅ Invert Binary Tree (226)
✅ Symmetric Tree (101)
✅ Diameter of Binary Tree (543)
✅ Balanced Binary Tree (110)
✅ Binary Tree Maximum Path Sum (124)

*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Binary_Tree_Maximum_Path_Sum {
    public static void main(String[] args) {

    }

}

class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // Ignore negative value
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Maximum path passing through current node
        int currentPath = node.val + left + right;

        // Update global answer
        maxSum = Math.max(maxSum, currentPath);

        // Return one side to parent
        return node.val + Math.max(left, right);
    }
}
