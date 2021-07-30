
//剑指 Offer 55 - II. 平衡二叉树
public class isBalanced {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        isBalanced(root);

    }
    public static boolean isBalanced(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return true;
        return dfs(root) != -1;
    }
    public static int dfs(TreeNode root){
        if(root == null) return 0;
        int leftHigh = dfs(root.left);
        int rightHigh =  dfs(root.right);

        if(leftHigh == -1 || rightHigh == -1 || Math.abs(leftHigh-rightHigh) >1){
            return -1;
        }else {
            return Math.max(leftHigh,rightHigh)+1;
        }

//        if(leftHigh == rightHigh)  return 1+leftHigh;
//        if(leftHigh - rightHigh == 1) return 1+leftHigh;
//        if(leftHigh - rightHigh == -1) return 1+rightHigh;
//        return 2;

    }
}
