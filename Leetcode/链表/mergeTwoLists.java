//剑指 Offer 25.合并两个排序链表
public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                prev.next =cur1;
                prev = prev.next;
                cur1 =cur1.next;
            }else{
                prev.next = cur2;
                prev = prev.next;
                cur2 = cur2.next;
            }
        }
        while(cur1 != null){
            prev.next =cur1;
            prev = prev.next;
            cur1 =cur1.next;
        }
        while(cur2 != null){
            prev.next = cur2;
            prev = prev.next;
            cur2 = cur2.next;
        }
        return fakeHead.next;
    }
}
