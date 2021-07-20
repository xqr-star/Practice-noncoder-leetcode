public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root,targetSum);
    }
    public boolean dfs(TreeNode root,int targetSum){
        //如果根结点不存在 但是 tar == 0
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == targetSum ){
            return true;//路径走完了并且sun ==0
        }
        //为什么不能有这个语句  -2 null -3 target = -5 直接这里就给我推出了
        if(root.val >= targetSum || root.left == null && root.right == null){
            return false;
        }

        return dfs(root.left,targetSum-root.val) || dfs(root.right,targetSum-root.val);

    }
}
