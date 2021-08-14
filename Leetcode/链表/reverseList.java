//剑指 Offer 24. 反转链表
public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode cur = head;
        if(head == null || head.next == null) return head;
        ListNode curNext = null;
        while(cur != null){
            curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        head.next = null;
        return prev;
    }
}
