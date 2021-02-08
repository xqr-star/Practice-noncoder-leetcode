package BinaryTree;

//100. 相同的树
public class isSameTree {
    /**
     * 这是精简版的
     */
    public boolean solution(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val)  return false;
        return solution(p.left, q.left) && solution(p.right, q.right);
    }

    /**
     * 这是刚开始第一次写的
     * 遇到问题时觉得刚开始不能直接比较根，因为如果根相等就直接返回，后面的没法比
     * 但是没有想到，刚刚开始判断根不相等的时候，直接返回false，就可以后面的都不用比较
     * @param p
     * @param q
     * @return
     */
    public boolean solution1(TreeNode p, TreeNode q) {
        //处理特殊情况
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        //两个数都不是null
        //比较左子树是否相同
        boolean left = solution1(p.left,q.left);
        //比较右子树是否相同
        boolean right = solution1(p.right,q.right);
        //比较根是否相同
        boolean root = p.val == q.val;

        return left && right && root;
    }
}
