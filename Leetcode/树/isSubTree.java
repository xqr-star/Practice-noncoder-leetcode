package BinaryTree;

//572. 另一个树的子树
public class isSubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        //其实是在判断isSameTree
        //先判断和当前根结点的树是不是相同的树
        if(isSameTree(s,t) == true ) return true;


        //在判断是不是左结点的子树，或者时右结点的子树
        //而不是说左结点的子树和跟的左边
        //return isSubtree(s.left,t.left) || isSubtree(s.right,t.right);
        return isSubtree(s.left,t) || isSubtree(s.right,t);


    }



    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val)return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
