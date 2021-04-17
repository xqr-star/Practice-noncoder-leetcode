package BinaryTree;

//剑指 Offer 33. 二叉搜索树的后序遍历序列
public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        System.out.println(verifyPostOrder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));
    }
    /**
     * 二叉搜索树的中序遍历是有序的
     * 如果是后序遍历的话 那么最后一个数字一定是根
     *
     * 二叉搜素树 满足的条件是 左子树的所有值 》 根 》 右子树的所有值
     * @param postorder
     * @return
     */



    public static boolean verifyPostOrder2(int[] postorder) {
        if(postorder == null) return false;
        if(postorder.length == 0) return true;

         return  solution(postorder, 0, postorder.length - 1);

    }

    //闭区间

    /**
     * 这个思想有一个很大的提升就是
     * 遍历数组 找到第一个比根值大的元素 然后记录下标
     * 然后从这个数字开始 判断之后的值是不是都比根的值大
     * 最后比较在哪里跳出了或者条件
     * 如果最后的下标是等于最后一个数组下标的 那么说明是满足 二叉搜索树的特性的
     * 如果最后跳出的下标 不是最后一个下标 说明在第一个比根值大数字后出现了比根小的数字不满足定义
     * 所以是否结束递归 就要看这个最后跳出的下标是不是最后一个
     * @param postorder
     * @param i
     * @param j
     * @return
     */
    private static boolean solution(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int temp = i;
        //找到不比根的值小的下标
        while (postorder[temp] < postorder[j]) temp++;
        int m = temp;//记录第一个不比根小的值 之后的值如果都比根的值大 那么说明这个树的正确性
        while (postorder[temp] > postorder[j]) temp++;
        if(temp == j){
            return solution(postorder,i,m-1) && solution(postorder,m,j-1);
        }else {
            return false;
        }
    }


    /**
     * 采用递归的做法
     * @param postorder
     * @return
     */
    public static boolean verifyPostOrder(int[] postorder) {
        //数组的最后一个数字就是根节点
        if(postorder == null) return false;
        if(postorder.length == 0) return true;

        return help(postorder,0,postorder.length-1);
    }

    // 表示从left 到 right 是否是一个二叉搜素树
    private  static boolean help(int[] postorder,int left ,int right) {
        //递归的出口是数组里面没有元素 或者只有一个元素
        if(left >= right) return true;

        //这个下标界定范围内的数组的最后一个就是根的值
        int rootValue = postorder[right];
        //然后找到第一个比根的值大的元素当作分割的基准
        //不能赋值成-1 有可能出现根本没有比根的值大的
        int partIndex  = -1;
        for(int i = left; i <= right-1;i++){
            if(postorder[i] > rootValue) {
                partIndex = i;
                break;
            }
        }
        //如果是 -1 并且里面的值是单调递增的 那么就可以   好像这里的逻辑是错误的，无语啊无语！
        if(partIndex == -1) {
            for(int i = left;i < right-1;i++){
                if(postorder[i] >=  postorder[i+1]) return false;
            }
            return true;
        }

        //判断分界点之前的数字是不是比根的值小
        for(int i = left;i <= partIndex-1;i++){
            if(postorder[i] > rootValue){
                return false;
            }
        }

        //判断分界点之后的数字是不是比根的值大
        for(int  i= partIndex;i <= right-1;i++){
            if(postorder[i] < rootValue){
                return false;
            }
        }

        return help(postorder, left,partIndex-1) &&  help(postorder,partIndex,right-1);
    }


}
