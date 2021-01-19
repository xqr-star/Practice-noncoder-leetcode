package code;

public class T2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(7);
        ListNode node4= new ListNode(5);
        ListNode node5 = new ListNode(4);
        node.next = node2;
        node2.next = node3;
        node3.next= node4;
        node4.next = node5;
        ListNode current  = node;
        while (current != null){
            System.out.print(current.val);
            current = current.next;
        }

        System.out.println();
        current = partition(node,7);
        while (current != null){
            System.out.print(current.val);
            current = current.next;
        }
    }

    public  static ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode current = pHead;
        //傀儡头结点
        ListNode leftHead = new ListNode(0);
        ListNode left = leftHead;

        ListNode rightHead = new ListNode(0);
        ListNode right = rightHead;
        //遍历整个链表
        while (current != null){
            if(current.val < x) {
              left.next  = current;
              left =left.next;
            }else  { // 如果等于的话怎么处理
                right .next = current;  //不能new 结点 要在原有的链表上操作
                right = right.next;
            }
            current = current.next;
        }
        //出来的时候，left 和right 就已经指向了两个的最末端，直接拼接就好啦
        left.next = rightHead.next;
        right.next = null; //这一步的操作是必须的 ！！!



//        right.next =  new ListNode(x);
//        //拼接两个链表
//        current = leftHead.next;
//        while (current.next != null) {
//            current = current.next;
//        }
//        current.next = rightHead.next;

        //返回傀儡头节点的下一个
        return leftHead.next;
    }
}
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
