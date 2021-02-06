package Node;
//24. 反转链表
public class reverseList {
    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode solution(ListNode head) {
        //为了防止错过头结点，那么就先定义一个空结点
        ListNode prev = null;
        ListNode cur = head;
        ListNode curNext = head;
        while(cur != null){
            curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }
}

