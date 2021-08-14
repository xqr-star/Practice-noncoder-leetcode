//剑指 Offer 22. 链表中倒数第k个节点
public class getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        //让fast 先走key-1步
        ListNode fast = head;
        while(k - 1 > 0){
            fast = fast.next;
            k--;
        }
        while(fast.next != null){
            cur = cur.next;
            fast = fast.next;
        }

        return cur;

    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

