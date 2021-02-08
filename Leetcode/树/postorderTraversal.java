package BinaryTree;

import java.util.ArrayList;
import java.util.List;

//145. 二叉树的后序遍历
public class postorderTraversal {
    /**
     * 递归版本
     * @param root
     * @return
     */
    public List<Integer> solution(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        if(root == null){
            return list;
        }
        //先遍历左子树
        List<Integer>leftList = solution(root.left);
        list.addAll(leftList);
        //之后右子树
        List<Integer> rightList = solution(root.right);
        list.addAll(rightList);
        //最后加入根
        list.add(root.val);
        return list;

    }
}
