//剑指 Offer 33. 二叉搜索树的后序遍历序列
public class verifyPostorder {
    /**
     * 数组的最后一个数字是根
     * 并且找到第一个比根大的 那么就是右子树的开始
     * 同时要保证
     * 比根小的所有数字都比根小
     * 比根大的所有数字都比根大
     * @param postorder
     * @return
     */

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,10,6,9,4,3};
        System.out.println(verifyPostorder(arr));
    }
    public static boolean verifyPostorder(int[] postorder) {
        if(postorder == null) return true;
        if(postorder.length == 0 || postorder.length == 1) return true;
        int rootValue = postorder[postorder.length-1];
        //使用的是闭区间
        return judege(postorder,0,postorder.length-1);
    }

    private static boolean judege(int[] postorder, int start, int end) {
        if(start >= end) return true;
        int key = postorder[end];
        int i = 0;
        //说明的是假使找到了左子树
        for(i = start; i < end;i++){
            if(postorder[i]  > key){
                break;
            }
        }
        int j = 0;
        for(j = i;j < end;j++){
            if(postorder[j]  < key){
                return false;
            }
        }
        return judege(postorder,start,i-1) && judege(postorder,i,end-1);
    }


}
