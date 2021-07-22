import java.util.HashSet;
import java.util.Set;

//653. 两数之和 IV - 输入 BST
public class findTarget {
    public boolean findTarget(TreeNode root, int k) {
        //一个集合中判断是否有两个值的和为k
        Set<Integer> set = new HashSet<>();
        if(root == null) return false;
        return preorder(root,set,k);
    }

    private boolean preorder(TreeNode root, Set<Integer> set, int k) {
        if(root == null) return false;
        if(set.contains(k-root.val)){
           return true;
        }
        set.add(root.val);
        return  preorder(root.left,set,k) || preorder(root.right,set,k);
    }
}
