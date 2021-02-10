package BinaryTree.Practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class buildBinaryTree {
    /**
     * 从中序与后序遍历序列构造二叉树
     */

    //由于涉及到中序遍历中去获取元素为了提高查找的效率使用map
    Map<Integer,Integer> map = new HashMap<>();
    //由于需要使用到数组，为了不想多次传递数组，所以数组设置从一个成员属性
    int[] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //把中序序列放到map中去
        for(int i=0;i < inorder.length;i++){
            map.put(inorder[i] ,i);
        }
        this.inorder = inorder;
        this.postorder = postorder;
        int inLength = inorder.length-1;
        int postLength =postorder.length-1;
        return tobuildTree(0,inLength,0,postLength);
    }
    public TreeNode tobuildTree(int i,int inLength,int j, int postLength) {
        if (i > inLength && j > postLength) return null;

        //根据后续遍历的最后一个结点拿到一个根的值
        int rootVal = postorder[postLength];
        TreeNode root = new TreeNode(rootVal);

        //在map中查找对应的元素的下标
        int rootIndex = map.get(rootVal);

        //重新分割区间然后递归
        int size = rootIndex - 1 - i;
        root.left = tobuildTree(i, rootIndex - 1, j, size + j);
        root.right = tobuildTree(rootIndex + 1, inLength, size + j + 1, postLength - 1);
        return root;
    }



    /**前序与中序遍历序列构造二叉树
     * 考虑使用数组下标本身的解法
     * 使用指针
     * @param preorder
     * @param inorder
     * @return
     */
//    Map<Integer,Integer> map = new HashMap<>();
//    private int[] preorder;
//    private int[] inorder;
//    public TreeNode solution2(int[] preorder, int[] inorder) {
//
//        //由根据下标是需要下标不断的变化去递归所以重新去写一个方法
//        if(preorder.length == 0 ) return null;
//
//        //为了方便寻找位置，使用一个哈希表来存储
//        //这个j就是根节点在中序遍历的位置
//        int j =0;
//        for( ;j < inorder.length;j++){
//            map.put(inorder[j] ,j);
//        }
//        int preLength = preorder.length-1;
//        int inLength = inorder.length-1;
//        this.preorder = preorder;
//        this.inorder = inorder;
//
//        TreeNode root = toBuildTree2(0,preLength,0,inLength);
//        return root;
//
//    }
//
//    /**
//     *
//     * @param i
//     * @param preLength
//     * i  - preLength 待查找的前序区间
//     * @param j
//     * @param inLength
//     * j - inlength 待查找的中序区间
//     * @return
//     */
//
//    private TreeNode toBuildTree2(int i, int preLength, int j, int inLength) {
//        //递归的终止条件
//        if(i > preLength && j > inLength) return null;
//
//        int rootVal = preorder[i];
//        TreeNode root = new TreeNode(rootVal);
//        int index = map.get(rootVal);
//
//        //终须区间待遍历的个数 == 前序区间待遍历的个数
//        int size = index - j;
//        //preLength - i+1 = index -1 - 0 中序区间的下标是确定出来的 前序是推算出来的
//        root.left = toBuildTree2(i+1,i+size,j,index-1);
//        root.right = toBuildTree2(i+size+1,preLength,index+1,inLength);
//        return root;
//    }


    public TreeNode solution(int[] preorder, int[] inorder) {
        List<Integer> preList = new LinkedList<>();
        for(int i : preorder){
            preList.add(i);
        }
        List<Integer> inList = new LinkedList<>();
        for(int i : inorder){
            inList.add(i);
        }
        if(preList.size() ==0) return null;
        TreeNode root = toBuildTree1(preList,inList);
        return root;
    }

    /**
     * 但总体来说 是在不断的构造list
     * 时间和空间复杂的十分不佳
     * @param preList
     * @param inList
     * @return
     */
    private TreeNode toBuildTree1(List<Integer> preList ,List<Integer> inList) {
        //首先得先确保这两个数组的大小是相同并且不为0，否则返回null

        //这个判断条件很重要 --会控制下面一定不会因为找不到而返回-1
        //preList大小为0 表示整棵树构建完毕 而 inlistsize 等于0 表示当前结点的左右子树构建完毕
        if(preList.size() == 0 || inList.size()==0)  return null;

        int num = preList.remove(0);
        TreeNode root = new TreeNode(num);

        //然后在中序遍历里面找到num 这个值的下标--方法是indexOf
        int index = inList.indexOf(num);
        //这个index 是会返回-1 不存在的

        //subList方法
        //怎么把一个object数组强制转换为整型数组呢？--转换不了
        //if(index != -1){
            root.left = toBuildTree1(preList,inList.subList(0,index));
            root.right = toBuildTree1(preList,inList.subList(index+1,inList.size()));
        //}else {
        //  return null;//表示当前结点已经构建完成 不存在左右子树了
        //}

        return root;
    }
}
