//19. 删除链表的倒数第 N 个结点
//Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //首先对n进行合法性的校验-- 题目已说是合法的

        //要得到倒数第n个结点使用快慢指针来做
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode slow = prev;
        ListNode fast = prev;
        while(n>0){
            fast = fast.next;
            n--;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        // slow 指向的是要删除的结点的前一个 所以不会出现空指针异常的
        slow.next = slow.next.next;
        //要返回虚拟头节点的下一个结点，头节点可能被删掉
        return prev.next;

    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //首先对n进行合法性的校验-- 题目已说是合法的

        //要得到倒数第n个结点使用快慢指针来做

        ListNode slow = head;
        ListNode prev = null;
        ListNode fast = head;
        while(n-1 >0){
            fast = fast.next;
            n--;
        }
        while(fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // slow 指向的是要删除的结点
        if(prev == null) return head.next; ////说明根本就没有动 要删除的是头节点
        prev.next = slow.next;
        return head;
    }
}
