import java.util.LinkedList;
import java.util.Queue;

//剑指 Offer 37. 序列化二叉树
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        //对这棵树进行层序遍历进行还原
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size()!= 0){
            TreeNode temp = queue.remove();
            if(temp == null){
                sb.append("null").append(",");
            }else {
                sb.append(temp.val).append(",");
            }
            if(temp != null){
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        //去掉最后一个,
        sb.replace(sb.length()-1,sb.length(),"");
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        TreeNode root = null;
        if(data .equals("[]")) return root;
        //先去掉[] 同时用，分开
        String[] split = data.substring(1,data.length()-1).split(",");
        if(split.length == 0) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        //让root的结点进入队列
        root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);

        //同时指针指向index 为1的数组下标
        int i = 1;
        while (queue.size() != 0){
            TreeNode temp = queue.remove();
            //左孩子串起来 同时进入队列
            if(!split[i].equals("null")) {
                temp.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(temp.left);
            }
            i++;
            if(!split[i].equals("null")) {
                temp.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(temp.right);
            }
            i++;
        }
        return  root;
    }
}
