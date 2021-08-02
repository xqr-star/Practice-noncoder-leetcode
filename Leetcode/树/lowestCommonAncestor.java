//剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
//剑指 Offer 68 - II. 二叉树的最近公共祖先
public class lowestCommonAncestor {


    /**
     * 二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        //说明root的左右结点中不存在
        return preOrder(root,p,q);
    }

    private TreeNode preOrder(TreeNode root, TreeNode p, TreeNode q) {
        //递归的终止条件
        if(root == null) return null;//这里表示先序遍历一直没有找到p或者q
        if(root == p || root == q) return root;

        TreeNode left = preOrder(root.left,p,q);
        TreeNode right = preOrder(root.right,p,q);


        //分析情况
        //如果left 不等于null 并且right ！= null 那么 返回root 说在在它的左和右子树中分别找到了
        //如果left==null  right ！= null  || left == null right != null  也返回不为null

       if(left != null && right != null) return root;
       if(left != null) return left;
       return right;
    }


    /**
     * 二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null){
            if(p.val > root.val && q.val > root.val){ //都在右子树
                root = root.right;
            }else if(p.val < root.val && q.val < root.val){ //都在左子树
                root = root.left;
            }else { //分布在左右子树
               break;
            }
        }
        return root;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return root;
        }
    }
}
