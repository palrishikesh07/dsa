//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class Insert_Binary_Search_Tree {
    public static void main(String[] args) {
        
    }


}


class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
             return new TreeNode(val);
        }

        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }
        else{
            root.right = insertIntoBST(root.right, val);
        }

        return root;
        
    }
}



class SolutionNew {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode curr = root;

        while (true) {

            if (val < curr.val) {

                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }

                curr = curr.left;

            } else {

                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }

                curr = curr.right;
            }
        }

        return root;
    }
}