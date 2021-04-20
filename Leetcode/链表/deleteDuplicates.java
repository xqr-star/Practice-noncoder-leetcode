package ListNode;

//82. 删除排序链表中的重复元素 II
//83. 删除排序链表中的重复元素
public class deleteDuplicates {



    /**
     * 这既是一套删除链表中重复元素的模板
     * 定义下一个元素
     * 然后看是否存在下一个元素
     * 存在
     *      值不相同 连接
     *      值相同 跳过  像82就是多跳过一个就好了
     *
     * 不存在
     *      连接
     * @param head
     * @return
     */

    //83

    //简便的代码
    public static ListNode deleteDuplicates1(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        ListNode curNext = head.next;
        while (curNext != null){
            if(cur.val != curNext.val){
                cur.next = curNext;
                cur = curNext;
            }
            curNext = curNext.next;
        }
        cur.next = null;
        return head;
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        ListNode cur = head;
        while (cur != null){
            ListNode curNext = cur.next;
            if(curNext != null){
                if(cur.val != curNext.val){
                    prev.next = cur;
                    prev = cur;
                    cur = cur.next;
                }else {
                    while (curNext != null&& cur.val == curNext.val){
                        cur = curNext;
                        curNext = cur.next;
                    }
                }
            }else {
                prev.next =cur;
                prev = cur;
                cur = cur.next;
            }
        }
        prev.next = null;
        return fakeHead.next;
    }
    //82
    public ListNode deleteDuplicatesII(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        ListNode cur = head;
        //因为永远是要看有没有重复的元素
        //所以是它的下一个元素去作比较
        while(cur != null){
            ListNode curNext = cur.next;
            if(curNext != null){
                if(cur.val != curNext.val){
                    prev.next = cur;
                    prev = cur;
                    cur = cur.next;
                }else {
                    //这里的一段逻辑激素是跳过所有的重复元素
                    while (curNext != null && cur.val == curNext.val) {
                        cur = curNext;
                        curNext = cur.next;
                    }
                    cur = cur.next; //让cur往后面多跳出一个
                }
            }else {
                //说明只有一个元素 直接穿上去
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }
        }
        prev.next = null;
        return fakeHead.next;
    }
}
