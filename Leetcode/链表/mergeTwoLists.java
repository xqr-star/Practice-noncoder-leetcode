package ListNode;

//21. 合并两个有序链表
public class mergeTwoLists {
    /**
     * 通过定义一个傀儡结点，然后把链表串起来
     */
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val) {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        if(cur1 != null){
            cur.next = cur1;
        }
        if(cur2 != null){
            cur.next = cur2;
        }
        return fakeHead.next;

    }
}
