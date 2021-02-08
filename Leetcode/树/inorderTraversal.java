package BinaryTree;

import java.util.ArrayList;
import java.util.List;

//94. 二叉树的中序遍历
public class inorderTraversal {

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
        //然后遍历根
        list.add(root.val);
        //最后得到右子树
        List<Integer> rightList = solution(root.right);
        list.addAll(rightList);

        return list;

    }
}
