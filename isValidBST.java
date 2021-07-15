class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

 //98.验证二叉搜索树
public class isValidBST {

    public static void main(String[] args) {

//        Integer num1 = null;
//        //不可以这么做
//        int num = num1;
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        TreeNode node = new TreeNode(Integer.MAX_VALUE);
        root.right = node;
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    /**
     * 判断 root的值是否在界限中
     * 界限是一个闭区间
     * @param root
     * @param min
     * @param val
     * @return
     */
    public static boolean isValidBST(TreeNode root,long min,long max){
        if(root == null) return true;
        if(root.val >= min && root.val <= max) {
            return isValidBST(root.left, min, root.val - 1L) && isValidBST(root.right, root.val + 1L, max);
        }else {
            return false;
        }
    }



    public  static boolean isValidBST1(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null) return true;

        Integer leftNum = leftVal(root.left);
        Integer rightNum = rightVal(root.right);
        System.out.println(leftNum);
        System.out.println(rightNum);




        //这里的逻辑判断 有问题 如果 左子树是null 但是右子树不满足结果就走到了第三个if 空指针异常了
        if(leftNum == null  && root.val < rightNum){
            return isValidBST(root.left) && isValidBST(root.right);
        }else if(rightNum == null && root.val > leftNum){
            return isValidBST(root.left) && isValidBST(root.right);
        }else if(root.val > leftNum &&  root.val < rightNum){
            return isValidBST(root.left) && isValidBST(root.right);
        }else{
            return false;
        }
    }
    public static Integer leftVal (TreeNode root){
        //找出最大的元素
        int max = Integer.MIN_VALUE;
        //然后前序遍历
        if(root == null) return null;
        if(root.left == null && root.right == null) return root.val;
        if(root.val > max) max = root.val;
        max = Math.max(max,leftVal(root.left));
        max = Math.max(max,leftVal(root.right));
        return max;
    }

    public  static Integer rightVal (TreeNode root){
        //找出最小的元素
        int min = Integer.MAX_VALUE;
        if(root == null) return null;
        if(root.left == null && root.right == null ) return Math.min(root.val,min);
        if(root.val  < min ) min = root.val;
        min = Math.min(min,rightVal(root.left));
        min = Math.min(min,rightVal(root.right));
        return min;
    }

}
