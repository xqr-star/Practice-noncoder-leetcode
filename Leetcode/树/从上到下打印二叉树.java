package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//剑指 Offer 32 - I. 从上到下打印二叉树

/**
 *  广度优先搜索（BFS）。
 */
public class 从上到下打印二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.left = root2;
        root.right = root3;

        levelOrder(root);
    }
    //层序遍历 -- 借助队列来实现
    public  static  int[] levelOrder(TreeNode root) {

        if(root == null) return new int[0];
        LinkedList<Integer> list = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        int[] arr  = new int[list.size()];
        for(int i = 0;i < arr.length;i++){
            arr[i] = list.remove();
        }
        return arr;

    }

}
