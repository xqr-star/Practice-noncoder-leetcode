package ListNode;

import java.util.HashSet;
import java.util.Set;

//141. 环形链表--判断一个链表是否有环
public class hasCycle {

    /**
     * 定义快慢指针，一个走一步，一个走两步，如果链表有环，那么他们一定会相遇
     * 如果链表没有环，快指针走的尾部以后，结束循环，返回false即可。
     * 注意区分链表相遇 其实是区分为 恰好相遇和擦肩而过，和在操场跑步还有一些不一样的！
     *
     * 问：为什么是一个一步一个两步的去走？
     * 答： 我们假设一个一步，一个两步 那么经过时间T时候的差值是  2T- T = T
     *      两个指针相遇的时候，一定相差的是n倍环的长度（l） nl
     *      为了让他们两个最快相遇，减少在环里面的来回转圈圈
     *      要找以一个差值T  使得  T / l  为整数，且这个整数尽可能的小
     *      在同样的情况下 如果T / l 已经可以满足是一个整数了
     *      那么  如果一个三步 一个一步  差值是2T     2T/l   那么这个整数会更大，反而转的去圈圈会更多相遇的时间会更长。
     */
    public boolean solution(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow ){
                return true;
            }
        }
        return false;
    }

    /**
     * 使用set 把经过的每一个链表保存起来，如果发现set里面出现了，那么就表示有环
     * 如果没有出现，并且已经走到了链表的尾部，说明就是没有环
     * 但是这个解法时间复杂度和空间复杂度都是o(n)
     * @param head
     * @return
     */
    public boolean solution1(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while(cur != null){
            if(!set.contains(cur)){
                set.add(cur);
                cur = cur.next;
            }else{
                return true;
            }
        }
        return false;
    }
}
