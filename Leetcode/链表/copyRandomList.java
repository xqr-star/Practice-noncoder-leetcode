import java.util.HashMap;

//剑指 Offer 35. 复杂链表的复制
public class copyRandomList {
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(3);
        Node node3 = new Node(1);
        Node node4 = new Node(0);
        Node node5 = new Node(2);

        node1.next = node2;
        node2.next = node3;
        node3.next =node4;
        node4.next =node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        copyRandomList(node1);
    }
    public  static Node copyRandomList(Node head) {
        //直接复制到老链表上
        Node cur = head;
        while(cur != null){
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }

        //然后进行随机指向的的复制
        cur = head;
        while(cur != null){
            if(cur.random == null){
                cur.next.random = cur.random;
            }else {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        //新老链表拆分
        cur = head;
        Node newHead = cur.next;
        Node temp = newHead;
        //走到倒数第二个结点
        while(cur.next!= null && cur.next.next != null){
            cur.next = cur.next.next;
            temp.next = temp.next.next;
            temp = temp.next;
            cur = cur.next;
        }
        cur.next = null;
        return newHead;
    }
    public static Node copyRandomList1(Node head) {
        if(head == null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        Node prev = new Node(-1);
        Node fakeHead = prev;
        //复制链表和next
        while(cur != null){
            Node temp = new Node(cur.val);
            prev.next = temp;
            prev = temp;
            map.put(cur,temp);
            cur = cur.next;
        }
        cur = head;
        //遍历random
        while(cur != null){
            //分别获取对应的新的结点的映射
            Node temp = map.get(cur);
            temp.random = map.get(cur.random);
            cur = cur.next;
        }
        return fakeHead.next;
    }


 static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
}
