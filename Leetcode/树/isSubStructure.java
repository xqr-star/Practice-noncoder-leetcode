package BinaryTree;
//剑指 Offer 26. 树的子结构
//注意不是 树的子树！！！

/**
 * 树的子结构
 *    2     2
 *   4    4
 *  8
 *  这样也算
 *
 *     10          10
 *   12  6       12   6
 *  8 3        8
 * 11
 * 这也是一种子结构
 */
public class isSubStructure {
    /**
     * 测试contains
     * @param args
     */
    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(2);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
//        TreeNode node3 = new TreeNode(9);
        rootA.left = node1;
        node1.left = node2;
       // node1.right = node3;

        TreeNode rootB = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        rootB.left = node4;

        System.out.println(isSubStructure(rootA, rootB));

    }

    /**
     * 既然要看A子树里面包不包含B结构
     * 1. 首先找打A子树里面 有没有B子树的根
     * 2.如果找到对应的根之后就去判断A 里面是包含B
     *
     * 错误点：
     * 1. 2 2 3 1 3  和 2 1 3 虽然根结点的值相同，但不能直接返回
     * 如果返回值是false 还要接着去比较
     * @param A
     * @param B
     * @return
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null && B == null) return true;
        if(A == null || B == null) return false;
        if(A.val == B.val) { //就算根的值相等了也不能这么去判断 因为树里面可能出现重复的值
            //所以如果返回值是false 也不能直接去返回 还有接着看树里面有没有其他相等的值
            boolean res = contains(A,B);
            if (res) return res;
        }
        //出来的时候可能有两种情况 一个是根的值不相等，还有一个是跟的值相等但结构不等
        //遍历左子树找B根的值
        return isSubStructure(A.left,B) ||isSubStructure(A.right,B);

    }

    /**
     * 如何判断一颗树里面是否包含子树
     * 判断是否包含的前提是 树的根一定是相等的。
     *  函数将注意力集中在了根节点已经匹配的情况。
     * @param a
     * @param b
     * @return
     */
    private  static boolean contains(TreeNode a, TreeNode b) {
        if(b == null) return true; //说明越过叶子节点了，也就是B已经遍历结束了
        if(a == null) return false; //B还没结束，A越过叶子节点了，很显然A不包含B结构；

        if(a.val != b.val) {
            return false;
        }
        return contains(a.left,b.left) && contains(a.right,b.right);

    }

    /**
     * 这个题是树的子结构，而不是子树懂吧？哈哈哈哈
     * 逻辑bug
     * 1 0 1 -4 -3
     * -1 -4
     * 预期返回的是false
     * 实际返回的是true
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        //特殊处理空树
        if (A == null || B == null) return false;

        //如果根是相同的话，就去同时遍历A和B的左右子树
        if (A.val == B.val) {
            return isSubStructure1(A.left, B.left) || isSubStructure1(A.right, B.right);
        }
        //如果根不相同的话
        //就去看A的左/右子树里面有没有B
        return isSubStructure1(A.left, B) || isSubStructure1(A.right, B);

    }



//        //首先看和根结点是不是相同的
//        boolean root = isSampleTree(A,B);
//        if(root ) return true;
//        //然后判断是不是左子树的子树
//        boolean left = isSubStructure(A.left,B);
//        //然后判断是不是右子树的子树
//        boolean right = isSubStructure(A.right,B);
//        return left || right;

}
