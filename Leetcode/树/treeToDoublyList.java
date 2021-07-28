

//剑指 Offer 36. 二叉搜索树与双向链表
// Definition for a Node.

public class treeToDoublyList {
    Node head;
    Node prev ;//用来保存遍历到的上一个结点
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        //对树进行中序遍历
        dfs(root);

        //最后只需要对head 头结点和尾结点进行调整即可
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void dfs(Node root) {
        if(root == null) return;
        dfs(root.left);

        //最深的递归root 此时是最后一个结点
        if(prev == null) {
            head = root;//确定head的指向
        }else {
            //当前驱不再是空的时候前驱的right 就可以有指向了
            prev.right = root;
        }
        //将当前的root的左指针指向前驱
        root.left = prev;
        //更改前序指向
        prev = root;

        dfs(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
