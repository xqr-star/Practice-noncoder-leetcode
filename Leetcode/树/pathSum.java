import java.util.LinkedList;
import java.util.List;

//剑指 Offer 34. 二叉树中和为某一值的路径
//DFS
public class pathSum {
    static List<List<Integer>> res ;
    static LinkedList<Integer> path;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        pathSum(root,22);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        preOrder(root,target);
        return res;
    }

    private static void preOrder(TreeNode root, int target) {


        if(root == null) return;

        //先判断当前的元素是否可以加入根
        //但是这样的话没有考虑到负数的情况
        path.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null){
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        //遍历完了但是不满足
        if(root.left == null && root.right == null) {
            path.removeLast();
            return;
        }



        preOrder(root.left,target);
        preOrder(root.right,target);
        //表示当前的这个根左右都处理过了 可以出去了
        path.removeLast();
    }
}
