package BinaryTree;

/**
 * 236. 二叉树的最近公共祖先
 * 关于最近公共祖先的问题
 * 首先保证这两个结点一定是在这颗树里面题目已经明确说明找到该树中两个指定节点的最近公共祖先。
 * 所以是存在的
 *
 * p 和 q 是否是在当前根结点的同一颗子树中
 * p 和 q在当前根结点相同的子树中（要么都子树/右子树）
 * p 和 q 不在相同的子树中（一个分布在根的左子树，一个分布在跟的右子树）
 *
 * 以当前的根节点去查找，如果分别在左右子树找到了p和q 那么当前结点就返回
 * 如果没有只是在当前结点的一颗子树上找到了，那么就继续返回找到结点
 *
 * 左后发现这个题的本质上其实还是在左前序遍历
 *
 */
public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        //怎么才代表找到了
        if(root ==  p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //表示在当前结点的左右子树找到了，就可以返回当前结点
        if(left != null && right != null){
            return root;
        }

        //如果有一个是null怎么办？
        //如果在它的左子树中两个都都找到，就返回这个左子树
        //等价于（left != null && right == null)
        if(left != null) return left;
        //如果在它的右子树中两个都找到了，就返回右子树
        //if(right == null) return left;
        return right;


    }

}
