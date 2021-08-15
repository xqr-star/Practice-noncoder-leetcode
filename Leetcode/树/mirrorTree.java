//剑指 Offer 27. 二叉树的镜像
public class mirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;

        //保存一下root 的left
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree1(left);
        return root;

    }




    public TreeNode mirrorTree1(TreeNode root) {
        if(root == null) return null;
        return dfs(root);
    }

    public TreeNode dfs(TreeNode a){

        //表示的是当前当前的结点不存在了
        if(a == null) return null;

        //如果是最后一个结点了那么返回即可 表示是叶子结点
        if(a.left == null && a.right == null) return new TreeNode(a.val);

        //new 出当前遍历的结点
        TreeNode node = new TreeNode(a.val);
        //当前的子树关系进行建立
        node.left = dfs(a.right);
        node.right = dfs(a.left);
        return node;
    }
}
