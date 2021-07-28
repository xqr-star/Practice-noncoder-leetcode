import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;




//剑指 Offer 32 - II. 从上到下打印二叉树 II
//剑指 Offer 32 - III. 从上到下打印二叉树 III
public class levelOrder {


    //泛型方法的返回值
    public List<Integer> levelOrder3(TreeNode root) {
        LinkedList <Integer> list = new LinkedList<>();
        list.add(1);
        return list;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            level++;
            //加入队列中去
            for(int i =0 ;i < size;i++){
                TreeNode node = queue.remove();
                temp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(level % 2 ==0){
                Collections.reverse(temp);
            }
            //加入结果中
            res.add(temp);
        }
        return res;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            for(int i =0 ;i < size;i++){
                TreeNode node = queue.remove();
                temp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
