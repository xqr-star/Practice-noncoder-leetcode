package BinaryTree;

import java.util.ArrayList;
import java.util.List;

//144. 二叉树的前序遍历
public class preorderTraversal {

    /**
     * 递归算法过于简单，需要尝试使用迭代完成
     */
    public List<Integer> solution(TreeNode root) {
        //这个定义一定要写到最前面，后面返回的时候需要返回一个list
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        //先遍历它的根
        list.add(root.val);
        //然后遍历它的左子树
        List<Integer> leftList = solution(root.left);
        list.addAll(leftList);
        //然后遍历它的右子树
        List<Integer> rightList =  solution(root.right);
        list.addAll(rightList);
        //最后返回这个list
        return list;
    }



}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
