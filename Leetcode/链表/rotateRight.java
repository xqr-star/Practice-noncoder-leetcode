//61. 旋转链表
public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fake = new ListNode(-1);
        fake.next  = head;
        //首先对k 和 head 进行校验
        if(head == null) return null;
        //求链表的长度 然后取模 缩小k的范围
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        //注意k的长度判定
        k = k %count;
        if(k == 0) return head;

        //也就是找到倒数的第k个的前一个
        ListNode fast = fake;
        ListNode slow = fake;
        while( k > 0){
            fast = fast.next;
            k--;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = fake.next;
        fake.next = slow.next;
        slow.next = null;
        return fake.next;
    }
}
