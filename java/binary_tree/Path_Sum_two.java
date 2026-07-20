import java.util.ArrayList;
import java.util.List;

public class Path_Sum_two {
    public static void main(String[] args) {
        
    }
}


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root,targetSum,new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> result){
        if(node == null){
            return;
        }

         // Add current node to path
         path.add(node.val);

           // Check if it's a leaf and target is reached
        if(node.left == null && node.right == null && target == node.val){
            result.add(new ArrayList<>(path));
        }

         // Explore left subtree

         dfs(node.left, target - node.val, path, result);

          // Explore right subtree

         dfs(node.right, target - node.val, path, result);

         //Backtrack
         path.remove(path.size() - 1);

    }
}
