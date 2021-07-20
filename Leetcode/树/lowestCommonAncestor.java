//235. 二叉搜索树的最近公共祖先
public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            } else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }else {
                //说明在当前root的左右两侧
                break;
            }
        }
        return root;
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }
}
