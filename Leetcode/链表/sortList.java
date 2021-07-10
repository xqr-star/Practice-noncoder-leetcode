
//148. 排序链表

public class sortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode c2 = new ListNode(5);
        head.next = c;
        c.next = c2;
        sortList(head);
    }


    /**
     * 自底向上的归并的思路
     *
     * 
     */


    public  static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        //头节点可能会被换掉
        ListNode fake = new ListNode(-1);
        ListNode prev = fake;
        prev.next = head;
        ListNode cur =head;
        int length = 0;

        //求链表长度
        while (cur != null){
            length++;
            cur = cur.next;
        }
        cur = head;
        //第一次使用长度1 分割链表 然后两两合并  然后继续使得cur 往后走
        //merge 传递的是两个链表的头节点

        // //每一次分割的长度 i
        for(int i = 1 ; i< length ;i *= 2) {
            //每一次都需要从头再次开始
            prev = fake;
            cur = fake.next;
            while (cur != null) {
                ListNode leftHead = cur;
                //找到分割的最后一个
                for (int j = 1; j < i && cur.next != null; j++) {
                    cur = cur.next;
                }
                //此时 cur 是 最后一个结点 这里的rightHead 就是第一段最后一个结点的下一个
                ListNode rightHead = cur.next;
                cur.next = null; //分割部分的链表也需要断开
                cur = rightHead;
                ListNode curNext = null;
                if (rightHead != null) { //找到当前这一部分的截止结点
                    for (int k = 1; k < i && cur.next != null; k++) {
                        cur = cur.next;
                    }
                    //要断开和下一部分的关系
                    curNext = cur.next;
                    cur.next = null;
                }


                //先进行一个两两的合并 需要把合并的结果串回到链表上
                ListNode mergHead = merge(leftHead, rightHead);
                prev.next = mergHead;
                //然后 prev 需要进行继续往后走
                //走的就是当前的链表的合并数字 但是如果是奇数的链表可能会出问题
                while (prev.next != null) {
                    prev = prev.next;
                }
                //这里结束的时候 就找到了下一次要串上去的prev
                cur = curNext;
                //然后继续往前进行一个合并
            }
        }
        return fake.next;

    }

    //合并链表
    private static ListNode merge(ListNode leftHead, ListNode rightHead) {
        if(leftHead == null) return rightHead;
        if(rightHead == null) return leftHead;
        ListNode fake = new ListNode(-1);
        ListNode prev = fake;
        ListNode cur1 = leftHead;
        ListNode cur2 = rightHead;

        while (cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                prev.next = cur1;
                prev = cur1;
                cur1 = cur1.next;
            }else{
                prev.next = cur2;
                prev = cur2;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null){
            prev.next = cur1;
        }
        if (cur2 != null){
            prev.next = cur2;
        }

        return fake.next;
    }

    /**
     * 使用快排的思路对链表排序
     * @param head
     * @return
     */
    public  static ListNode sortList1(ListNode head) {
        if(head == null || head.next == null) return head;
        return quickSort(head);
    }






    public  static  ListNode quickSort(ListNode head){
        //如果当前的链表只有一个 或者没有元素说明快排结束了
        if(head == null || head.next == null) return head;

        ListNode lessHeadPrev = new ListNode(-1);
        ListNode morehead = new ListNode(-1);
        //利用heah 把链表划分为两个部分
        quickPart(head,lessHeadPrev);
        //再分别进行一个递归
        ListNode lessHead = null;
        lessHead = quickSort(lessHeadPrev.next); //这里可能是null
        morehead = quickSort(head.next);

        head.next = morehead;
        //最后再走到less 的最后一个 然后串起来
        ListNode cur = lessHead;
        if(cur == null){
            return head;
        }
        //如何不是null 走到最后一个然后传=串起来
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = head;
        return lessHead ;

    }


    //把一个链表划分为比 头结点大和小的两部分
    public static void quickPart(ListNode head,ListNode lessHead){
        int key = head.val;
        ListNode prevLess = lessHead;
        ListNode prevMore = head;
        ListNode cur = head.next;
        head.next = null;

        ListNode curNext = null;
        while(cur != null){
            curNext = cur.next;
            if(cur.val < key){
                prevLess.next = cur;
                prevLess = cur;
                cur.next = null;
            }else{
                prevMore.next = cur;
                prevMore = cur;
                cur.next = null;
            }
            cur = curNext;
        }
    }

}
