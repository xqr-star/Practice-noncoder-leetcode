package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

//226. 翻转二叉树
public class mirrorTree {

    /**
     * 使用迭代，使用广度优先遍历
     * 这个思想有点奇妙，确实迭代写的比较少
     * 使用队列辅助遍历到了的每一个元素
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()){
            //每次从队列中拿出一个节点，并交换这个结点的左右子树
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;

            //如果当前队列的左子树或者右子树不为空那么就放入队列一次处理
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        return root;
    }
    //是需要重新构造一个该树的镜像树






    /**
     * 递归的版本
     * 使用的是深度优先遍历
     * df
     * 是需要原地逆置吗？
     * @param root
     * @return
     */


    //原地逆置s
    public TreeNode invertTree2(TreeNode root) {
        //首先考虑如果根是空结点--也就是递归终止的条件
        if(root == null) return null;
        //虽然看起来是交换当前结点的左右结点
        //但实际上是把以左右结点为根的树直接就都交换了
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //然后再去递归当前结点的左子树和右子树
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }

    //非原地逆置的解法，是重新构造了一颗树
    public TreeNode invertTree(TreeNode root) {
        //首先考虑如果根是空结点--也就是递归终止的条件
        if(root == null) return null;
        //如果该树只有一个元素
        TreeNode root2 = new TreeNode(-1);
        root2.val = root.val;

        //得到这个原始树的右子树反转的结果，加到新树的左子树上
        root2.left = invertTree(root.right);
        root2.right = invertTree(root.left);
        return root2;
    }
}
