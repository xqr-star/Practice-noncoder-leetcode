package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 之字形打印二叉树 {
    /**
     * 使用头插入和尾插入相结合的操作
     * 双端队列可以实现头插入和尾插入
     */

    public static void main(String[] args) {

    }
    private  ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) {
            return res;
        }
        //如果根不为空 就把结点拖动到对立里面
        //记录是第几层的
        int level = 1;
        queue.add(pRoot);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> inner = new ArrayList<>();

            //处理一层的元素
            for(int i = 0; i< size;i++){
                node = queue.remove();
               if(level %2 != 0){ //当前是奇数那么放入内部list就尾插
                  inner.add(node.val);
               }else { //当前是偶数，放入list就头插
                   inner.add(0,node.val);
               }
               //然后拖动子树
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }

            }
            //一层已经结束了 所以层次加1
            level ++;
            //然后要把
            res.add(inner);
        }
        return res;
    }
    /**
     * 思路是 队列+栈
     * 第一行是偶数层
     * 第二行是奇数层
     * 如果是奇数层就放入到栈里面进行颠倒顺序的操作
     * 但是这个就是额外的空间复杂度
     * @param pRoot
     * @return
     */
    //返回时一个链表  每一个链表里面的元素都是一个链表
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        //不自定义类了 直接用一个数字记录层级就好了
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) {
            return res;
        }
        //如果根不为空 就把结点拖动到对立里面
        int level = 1;
        queue.add(pRoot);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> inner = new ArrayList<>();

            //处理一层的元素
            for(int i = 0; i< size;i++){
                node = queue.remove();
                //不断的往内部的list里面加入元素的过程
                if(level %2 != 0){ //如果是奇数就直接添加
                    inner.add(node.val);
                }else {
                    stack.push(node);//暂时先放到栈里面
                }

                //然后往里面拖动元素
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            //一层已经结束了 所以层次加1
            level ++;
            //这里处理逆序的每一行
            while (!stack.isEmpty()){
                inner.add(stack.pop().val);
            }
            res.add(inner);
        }
        return res;
    }
}


