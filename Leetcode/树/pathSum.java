package BinaryTree;

import java.util.LinkedList;
import java.util.List;

//剑指 Offer 34. 二叉树中和为某一值的路径

/**
 * 前序遍历 + 回溯
 */
public class pathSum {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,7};
        // 创建一个LinkedList，保护Collection中的全部元素。
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return res;
    }

    private void recur(TreeNode root, int target) {
        if(root == null) return;
        list.add(root.val);
        target -= root.val;

        //递归退出的条件
        if(target == 0 && root.left == null && root.right== null){
            res.add(new LinkedList(list));
            //res.addAll 是把后面的那个集合里面的所有元素全部添加到list里面
            //而不是把后面的最为一个整体添加
        }
        //这里都是在不断的进行递归的过程 也就是前序遍历的过程
        recur(root.left,target);
        recur(root.right,target);
        //这里是在回溯 也就是说当前的这个node 结点执行完以后，直接在记录的路径里面删除这个结点
        //回退到没有执行它的过程
        list.removeLast();
    }

    /**
     * 对一颗树进行先序遍历
     */
    public static  void preOrder(TreeNode root){
        if(root == null ) return;
        System.out.println(root.val);
        if(root.left == null && root.right == null)return;
        if(root.left != null){
            preOrder(root.left);
        }
        if(root.right != null){
            preOrder(root.right);
        }
    }
}
