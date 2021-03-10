package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102. 二叉树的层序遍历

/**
 * 实现的是一个带层级的层序遍历
 */
public class levelOrder2 {

    /**
     * 这里的规律是队列中的初始结点个数 是每一个内部列表里面需要添加的个数
     * 一开始我就new 内部列表 只是通过规律来确定里面到底放多少元素
     */

    //对于每次的队列的遍历，队列的所有元素就是第i的层的元素
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> innerList = new LinkedList<>();
            int size = queue.size();
            //size 记录的是初始的队列中的元素
            //表示的是放到innerList的元素个数 其实就是队列的元素
            for(int i = 0;i <size;i++){
                TreeNode cur = queue.poll();
                innerList.add(cur.val);
                //然后把它的孩子拖动进来--如果它的孩子是存在的
                if(cur.left !=null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            res.add(innerList);
        }
        return res;
    }


    //自定义了一个带层级的类
    //这个val表示的是当前遍历的是第几层
    class NT{
        TreeNode node;
        int val;

        public NT(TreeNode node, int val) {
            this.node = node;
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        //建立一个队列辅助完成二叉树的层序遍历
        Queue<NT> queue = new LinkedList<>();
        if(root == null) return res;
        queue.add(new NT(root,0));
        while(!queue.isEmpty()){
            NT cur = queue.poll();
            int level = cur.val;
            TreeNode  node = cur.node;
            if(level == res.size()){
                //在总的结果中添加list
                res.add(new ArrayList<>());
            }
            //拿到对应的内层的list
            List<Integer> innerList = res.get(level);
            innerList.add(node.val);
            //把它的两个孩子拖动进来
            if(node.left != null){
                queue.add(new NT(node.left,level+1));
            }
            if(node.right != null){
                queue.add(new NT(node.right,level+1));
            }
        }
        return res;
    }
}
