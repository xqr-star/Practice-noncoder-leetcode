package BinaryTree.Practice;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {

    /**
     * 判断一颗树是不是完全二叉树
     * 满二叉树一定是完全二叉树
     * 完全二叉树不一定是满二叉树
     *
     * 利用层序遍历的思想来判断一个树是不是完全二叉树
     * 带着null进行遍历
     * 树的值和 null 一定呈现出泾渭分明的状态
     * 当我第一次遇到null的时候需要停下来，然后判断队列剩余的元素中有没有非null
     * 如果有非null ，那么就不是
     *
     * 是本质是LinkedList 里面可以放null 那队列呢？但是队列是不允许出现null
     * 关于为什么，LInkedList里面放null  其实本质上是把这个对象的值置为null 但是它的prev 和next 指针还是有指向关系的
     * 而队列里面放null 就会出现异常
     */

    public boolean isCompleteTree(TreeNode root){
        if(root == null) return  true;
        Queue<TreeNode> queue = new LinkedList<>();
        //说明根存在
        queue.add(root);
        while (true){
            TreeNode node = queue.remove();
            if(node == null) break;
            queue.add(node.left);
            queue.add(node.right);
        }

        //跳出循环说明找到了第一个为null，然后要继续在队列中找有没有不是null
        while (!queue.isEmpty()){
           TreeNode temp = queue.remove();
           if(temp != null){
               return false;
           }
        }

        //遍历完没有结束，说明都是null
        return true;
    }
    /**
     * 广度优先遍历 -- 层序遍历
     * 需要借助队列来辅助
     * @param root
     */
    public static void solution(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        //说明根存在
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.println(node.val);
            //如果有左孩子--代码中一定不会出现null
            if(node.left != null){
                queue.add(node.left);
            }
            //如果有右孩子在放进去
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
