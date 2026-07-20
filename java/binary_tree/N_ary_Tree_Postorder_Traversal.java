//https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

public class N_ary_Tree_Postorder_Traversal {
    public static void main(String[] args) {
        
        
    }

    public List<Integer> postorder(Node root) {
         List<Integer> result = new ArrayList<>();

        dfs(root, result);

        return result;
    }
    
     private void dfs(Node root, List<Integer> result) {
        if(root ==null){
            return;
        }

        for(Node child: root.children){
            dfs(child, result);
        }

        result.add(root.val);
     }
}
