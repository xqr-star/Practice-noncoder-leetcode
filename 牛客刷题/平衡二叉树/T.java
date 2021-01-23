import static java.lang.Math.abs;
import static java.lang.Math.max;

public class T {
/*平衡二叉树
 */

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

    public boolean isBalance(TreeNode root) {

        return  high(root) != -1;
        // write code here
       /* if(root == null) {
            return true; // 空树也是一个平衡二叉树
        }
        int leftHigh = high(root.left);//这里会出问题的
        int rightHigh = high(root.right);
        //因为你少判断了一步如果两个都是正常的求出树的高度
        //那这里还是哟啊判断一次差值
        //简单来说就是忽略了以root 为根的是不是

        if(leftHigh == -1 || rightHigh == -1) { //如果树的高度返回的是-1 就不是平衡二叉树
            return false;
        }
        return true;*/
    }

    //采用后续遍历的思想
    //求树的高度 + 判断是不是平衡二叉树
    //-1 代表两个意思 一个是不平衡 还有一个就是这个树的高度

    //最后判断树的高度 是-1 就是不平衡了

    private int high(TreeNode root) {
       if(root == null) {
           return 0;
       }

       int left = high(root.left);
       if(left == -1) return -1; // 一直向上返回，没有必要去计算深度
       int right = high(root.right);
       if(right == -1) return -1;//这里返回的是树的高度  就是如果不平衡那么这个结点的树的高度也是要告诉我的啊


       //这里返回的是平衡的结果
        if(abs(left-right) >1 ){
            return -1;
        }
        //还是正常计算树的高度
       return 1 +  max(left,right);

    }


    //下面的做法只是返回了一次 事实上需要的是两次返回
    //一次返回的是是不是平衡二叉树 另一次返回的是树的高度
    //最后计算的是树的高度

    private int high3(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null || root.right == null) {
            return 1;
        }

        //求这个树的左右子树的高度差
        int sub =  high3(root.right) - high3(root.left);

        //只是说加上了如果一个树的左右子树的结点差值大于1的话就直接返回-1 ，就不要
        if(Math.abs(sub) >1){
            return  -1;
        }

        //还是正常计算树的高度
        return 1 +  Math.max(high3(root.left),high3(root.right));

    }





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

        int leftHigh = high2(root.left);
        int rightHigh = high2(root.right);
        if(abs(leftHigh-rightHigh) > 1) {
            return false;
        }
        return isBalance2(root.left) && isBalance2(root.right);

    }
    private int high2(TreeNode root) {
        if(root == null){
            return  0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return 1+Math.max(high2(root.left),high2(root.right));

    }



}

