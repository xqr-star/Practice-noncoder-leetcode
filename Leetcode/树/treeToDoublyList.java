package BinaryTree;

//剑指 Offer 36. 二叉搜索树与双向链表

public class treeToDoublyList {

    /**
     * 显然是树的前驱用left表示，树的后继用right表示
     * 二叉搜索树的中序遍历是有序的
     * 所以转换成链表应该是使用的中序遍历
     *
     * @param root
     * @return
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node = new TreeNode(1);
        root.left = node;
        treeToDoublyList(root);

    }
    public static TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        //需要拿到这颗树的中序遍历的第一个节点
        TreeNode head = inorder(root);


        //以及中序遍历的最后一个结点
        TreeNode tail= toBUild(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private static TreeNode inorder(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return  root;
        return inorder(root.left);
    }

    private static TreeNode toBUild(TreeNode root) {
        if(root == null) return null;
        if (root.left == null && root.right == null) return root;

        //如果有右子树的话

        //搜索树的左子树
        TreeNode rootLeft = toBUild(root.left);
        rootLeft.right = root;
        root.left = rootLeft;
        //树的右子树
        TreeNode rootRight = toBUild(root.right);
        rootRight.left = root;
        root.right = rootRight;
        //它的右子树里面最大的作为返回值

        //如果只有左子树，那么就返回当前的root
        //就是一定要确保返回的是当前这棵树里面最大的结点


    }
}
