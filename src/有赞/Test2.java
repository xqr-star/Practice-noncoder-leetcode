package 有赞;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的左侧试图


public class Test2 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println(leftSideView(root).toString());

    }
    static class MyTree {
        TreeNode treeNode;
        int flag =0;

        public MyTree(TreeNode treeNode, int flag) {
            this.treeNode = treeNode;
            this.flag = flag;
        }
    }

    public static int[] leftSideView (TreeNode root) {
        if(root == null) return new int[0];
        // write code here
        List<Integer> list = new ArrayList<>();

        //借助队列进行层序遍历
        Queue<MyTree> queue = new LinkedList<>();
        int flag =1;
        queue.add(new MyTree(root,1));
        while (queue.size() != 0){
            int size = queue.size();
            flag = 0;
            for(int i = 0; i< size;i++){
                //从队首拿出元素
                MyTree node = queue.remove();
                TreeNode temp = node.treeNode;
                if(node.flag == 1 ) {
                    list.add(temp.val);
                }

                if(temp.left != null){
                    queue.add(new MyTree(temp.left,++flag));
                }
                if(temp.right != null){
                    queue.add(new MyTree(temp.right,++flag));
                }
            }
        }

        int[] arr = new int[list.size()];
        for(int i = 0; i< list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}

