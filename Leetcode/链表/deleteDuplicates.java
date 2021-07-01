//83. 删除排序链表中的重复元素
public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next; //一定有重复元素 所以fast 一定不为空

        while (fast != null) {
            if (slow.val == fast.val) {
                fast = fast.next;
            } else {
                slow.next = fast;
                slow = fast;
                fast = fast.next;
            }
        }
        slow.next = null;
        return head;
    }
}
