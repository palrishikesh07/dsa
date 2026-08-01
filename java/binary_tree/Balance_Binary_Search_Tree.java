//https://chatgpt.com/c/6a649ae6-c634-83e8-b169-8988dec5aa1e

import java.util.ArrayList;
import java.util.List;

public class Balance_Binary_Search_Tree {
    public static void main(String[] args) {
        
    }


}


class Solution {

    List<TreeNode> inorder =  new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {

        inorderTraversal(root);

        return buildTree(0, inorder.size()-1);
        
    }


    private void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        inorder.add(root);
        inorderTraversal(root.right);
    }

    private TreeNode buildTree(int left, int right){
        if(left > right){
            return null;
        }

        int mid = left + (right - left)/2;

        TreeNode  root = inorder.get(mid);

        right.left = buildTree(left, mid-1);
        root.right = buildTree(m+1,  right);

        return root;
    }

}



/**
 *  SoluationExampleByUSer
 */
public class  SoluationExampleByUSer {

    var balanceBST = function(root) {
    const nodes = [];

    function dfs(node) {
        if (!node) return;

        dfs(node.left);
        nodes.push(node);
        dfs(node.right);
    }

    dfs(root);

    function build(left, right) {
        if (left > right) return null;

        const mid = Math.floor((left + right) / 2);
        const root = nodes[mid];

        root.left = build(left, mid - 1);
        root.right = build(mid + 1, right);

        return root;
    }

    return build(0, nodes.length - 1);
};
}