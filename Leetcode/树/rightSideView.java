import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//199. 二叉树的右视图
public class rightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        //还是进行树的层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        queue.add(root);
        while (queue.size() != 0){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode temp = queue.remove();
                if(i == size-1){
                    res.add(temp.val);
                }
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        return res;
    }
}
