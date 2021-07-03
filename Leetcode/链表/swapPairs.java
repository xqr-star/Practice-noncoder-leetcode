//24. 两两交换链表中的节点
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        //不存在头结点 或者 是头结点的下一个结点不存在那么就不需要交换
        if(head == null || head.next == null) return head;
        //说明至少有两个结点
        ListNode prev = new ListNode(-1);
        ListNode fake = prev;
        prev.next = head;
        ListNode cur = head;

        while(cur != null && cur.next != null){
            prev.next =  cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return fake.next;
    }
}
