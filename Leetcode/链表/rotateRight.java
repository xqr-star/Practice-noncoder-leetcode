package ListNode;

//61. 旋转链表
public class rotateRight {
    /**
     * 方法二 ： 采用快慢指针的做法
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null|| k == 0) return head;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        //第一步求出链表的长度
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        //第二步判断对应的index
        int key = k % length;
        if(key == 0) return fakeHead.next;
        //采用快慢指针的做法
        //让快指针先走k步 然后和慢指针 一个一步的走 直到快指针走到最后一个
        ListNode fast = head;
        while (key >0){
            fast = fast.next;
            key--;
        }
        ListNode low = head;
        while (fast != null && fast.next != null){
            fast = fast.next;
            low = low.next;
        }
        //快指针指向的是最后一个
        //慢指针和它的的下一个都是需要更改指向的
        fakeHead.next = low.next;
        low.next = null;
        fast.next = head;
        return fakeHead.next;
    }

    /**
     * 普通的思想 就是找到对应的位置 然后只用进行下标的更改就可以了
     * 不用一个一个的链表进行翻转
     * @param head
     * @param k
     * @return
     */

    public ListNode rotateRight1(ListNode head, int k) {
        if(head == null|| k == 0) return head;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        //第一步求出链表的长度
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        //第二步判断对应的index
        int key = k % length;
        if(key == 0) return fakeHead.next;

        //需要移动的次数
        int move = (length - key);
        //第三步走到需要移动的第一个结点
        cur = head;
        ListNode pre = fakeHead;
        while(move >0){
            pre = cur;
            cur = cur.next;
            move--;
        }
        pre.next = null;
        fakeHead.next = cur;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = head;
        return fakeHead.next;
    }
}
