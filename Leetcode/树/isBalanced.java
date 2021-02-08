package BinaryTree;
//110. 平衡二叉树
public class isBalanced {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        root.left = node1; root.right = node2;
        node1.left = node3; node2.right = node4;
        node3.left = node5;node4.right = node6;
        isBalanced(root);
    }
    /**
     * 最好是在每一个结点只遍历一次，然后去求树的高度
     */
    public static boolean isBalanced (TreeNode root) {
        if(depth(root) != -1 )  return true;
        return false;
    }
    //，如果树的高度差大于1 的话直接让树的高度返回-1
    //如果没有就正常返回树的高度
    //也就是说在求高度的时候，直接就把是不是平衡树求出来
    public static int depth (TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        int leftDepth = depth(root.left);
        if(leftDepth == -1) return -1;//这里的判断是一定要的 如果这里不退出，左右子都是-1 然后后面高度差没有返回直接返回的高度是0
        int rightDepth = depth(root.right);
        if(rightDepth == -1) return -1;

        if(Math.abs(leftDepth-rightDepth) > 1) {
            return  -1;
        }
        return Math.max(leftDepth,rightDepth) +1;
    }



    /**
     * 先写一种前序遍历的思路
     * 这种解法其实大家都能想的到，其实不是一个好的做法
     * 但其实每一个结点都在求高度，会反复的去求
     * 时间复杂度大
     */
    public boolean isBalanced2 (TreeNode root) {
        if(root == null) return true ;//空树也算是平衡二叉树
        if(root.left == null && root.right == null) return true;

        //先判断当前的结点是不是平衡二叉树
        int sub = Math.abs(depth1(root.left) - depth1(root.right));
        if(sub > 1) {
            return false;
        }else {
            //如果是当前的是小于1 的话就去判断左右子树是不是
            return  isBalanced2(root.left) && isBalanced2(root.right);
        }

    }
    public int depth1(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return Math.max(depth1(root.left) ,depth1(root.right)) +1;
    }

    /**
     * 写到一半发现是错误的写法
     * @param root
     * @return
     */

    public boolean isBalanced1 (TreeNode root) {
        if(root == null) return true ;//空树也算是平衡二叉树
        if(root.left == null && root.right == null) return true;
        //然后分别求出当前结点的左右子树的高度
        int leftHigh = depth(root.left);
        int rightHigh= depth(root.right);
        //如果高度差大于1 那么就返回false
        //但是这个不算是每个结点，这个只是计算了当前结点的左右子树的高度差
        if(Math.abs(leftHigh-rightHigh) > 1) {
            return false;
        }
        return true;
    }


}
