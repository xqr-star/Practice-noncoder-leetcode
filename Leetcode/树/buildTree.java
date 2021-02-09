package Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//用带空结点的前序遍历构建一颗二叉树
//不带空结点的前序遍历无法还原出一个二叉树
public class buildTree {
    static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x){
            val = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Character> in = new LinkedList<>();

        //打印输出程序结果
        //in.forEach(System.out::println);
        for(char ch :str.toCharArray()){
            in.add(ch);
        }
        List<Character> out = new LinkedList<>();
        TreeNode root = buildTree(in,out);
        inorderTraversal(root);

    }
    public static  void inorderTraversal(TreeNode root){
        if(root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val+" ");
        inorderTraversal(root.right);
    }
    /**
     *
     * @param in 输入的带空结点的前序遍历序列
     * @param out 作为输出使用，out本身是一个空的list，构建完成树之后，把out中填充号剩余的序列
     * @return 把已经利用的序列构建好的树返回给我
     */
    public static TreeNode buildTree(List<Character> in ,List<Character> out){
        if(in.isEmpty()){
            //没有序列，只能是空树
            return null;
        }
        //in 不是空的
        char rootVal = in.remove(0);
        //对char 进行判断 说明构造出来的是一个空树
        if(rootVal == '#'){
            out.addAll(in);
            return null;
        }

        //rootVal 不是#
        TreeNode root = new TreeNode(rootVal);
        //这里的in 已经变过过了
        //构建root 的左子树
        List<Character> rightOut = new LinkedList<>();
        TreeNode left  = buildTree(in,rightOut);

        //构建右子树
        TreeNode right = buildTree(rightOut,out);

        root.left = left;
        root.right = right;

        return root;


//        if(rootVal == '#') {
//            return null;
//        }
//        TreeNode root = new TreeNode(rootVal);
//        out = in;
//        root.left = buildTree(in,out);
        //还是栈帧理解不够深刻 事实上在你不断构建左子树的时候，in 里面已经用掉了，可是你下一次构建右子树的时候
        //还是用的当前的in序列，当然不对 也就是说你没有把那个剩下的in 带出来
//        root.right = buildTree(in,out);
//        return root;
    }
}
