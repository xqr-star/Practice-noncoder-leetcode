package BinaryTree;

//606. 根据二叉树创建字符串

/**
 * 注意的内容：
 * 如果当前的结点只有左孩子，而没有右孩子，那么是需要把右孩子的() 不用出现
 * 如果当前结点只有右孩子，那么左孩子的() 需要出现
 * 如果当前结点左右都没有孩子，那么就不用了
 */
public class tree2str {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();

        if(t == null) return sb.toString(); //这里不能直接return null 有问题，会把一个null 的字符串返回的

        if(t.left == null && t.right == null) return Integer.toString(t.val);

        //先处理根
        sb.append(t.val);

        //处理左子树--如果是空树就return null
        //如果return null 的话 null 会被添加进去的
        //如果是空的就什么都不做就好了
        //不是空树就处理字符串
        if(t.left != null && t.right != null) {
            sb.append("(");
            sb.append(tree2str(t.left));
            sb.append(")");

            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }

        if(t.left != null && t.right == null){
            sb.append("(");
            sb.append(tree2str(t.left));
            sb.append(")");
        }

        if(t.left == null && t.right != null) {
            //先把括号打出来然后在打出来右子树
            sb.append("(");
            sb.append(")");

            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }


        return sb.toString();
    }
}

// if(t.left != null) {
//         sb.append("(");
//         sb.append(tree2str(t.left));
//         sb.append(")");
//         }else {
//            sb.append("(");
//            sb.append(")");
//        }
//
//         if(t.right != null) {
//         sb.append("(");
//         sb.append(tree2str(t.right));
//         sb.append(")");
//         }else {
//            sb.append("(");
//            sb.append(")");
//        }