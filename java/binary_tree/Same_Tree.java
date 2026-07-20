public class Same_Tree {
    public static void main(String[] args) {
        
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: Both nodes are null
        if(p == null && q == null){
            return true;
        }

         // Case 2: One node is null
         if(p == null || q == null){
            return false;
         }

         // Case 3: Values are different
         if(p.val != q.val){
            return false;
         }

         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}
