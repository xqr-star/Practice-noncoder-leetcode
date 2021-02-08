package BinaryTree;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        //再去判断它的左右子树是不是镜像的树
        //去比较左右子树是不是相同的
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode p,TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q== null) return false;

        //说明两个数的根是存在的
        if(p.val != q.val) return false;
        //根如果相同，比较左右两个
        return isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }
}
