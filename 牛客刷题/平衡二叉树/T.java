import javax.swing.tree.TreeNode;

public class T {
    public static void main(String[] args) {

    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 自下而上的处理
     */





    /**、
     * 自上而下的处理方式
     * 但是这样的处理方法就是效率很低，因为一个结点会被遍历次数很多
     * @param root
     * @return
     */
    public boolean isBalance2(TreeNode root) {
        // write code here
        if( root == null) {
            return true;
        }
        //这里得宝成一个循环处理的格式
        //求左右子树的高度

        int leftHigh = high(root.left);
        int rightHigh = high(root.right);
        if(Math.abs(leftHigh-rightHigh) > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);

    }
    private int high2(TreeNode root) {
        if(root == null){
            return  0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return 1+Math.max(high(root.left),high(root.right));

    }



}

