package ListNode;

//82. 删除排序链表中的重复元素II
//删除链表中的重复结点
//1233445
//125
public class deleteDuplication {
    /**
     * 正确解法
     */
    public ListNode solution2(ListNode pHead){
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;

        ListNode cur = pHead;
        while (cur != null ){
            if(cur.next != null && cur.val == cur.next.val){
                //把所有相同的都走完
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                //跳出的时候说明当前的cur找到了不相等的结点，但是此时的cur是一个重复结点，需要跳过,这样就跳过了所有重复的结点
                cur = cur.next;
            }else {//这里的else 不仅处理了值不想的情况还处理了 cur.next == null 也就是cur走到最后一个情况
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }
        }
        //这里一定要置为null
        prev.next = null;
        return fakeHead.next;
    }

    /**
     * 这是一个错误的解法
     * 你处理了值相等的，但是没有处理cur.next == null 的情况
     * 如果是最后一个 也是需要串起来的
     */
    public ListNode solution(ListNode pHead){
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        ListNode cur = pHead;
        while (cur != null ){
            //没有考虑cur不空 但是cur next是空的时候怎么办
            //所以写这个if else的时候还是很看顺序的！
            if(cur.next!= null && cur.val != cur.next.val){
                prev.next = cur;
                prev = cur;
                cur = cur.next;
            }else {//cur.val == cur.next.val
                //在进到这个循环的时候，还不能把当找到不相等的时候直接穿上去
                //因为出现多个一样的数字，所以需要一直找，找到第一个不一样的
                while (cur != null && cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                //跳出的时候说明当前的cur找到了不相等的结点，但是此时的cur是一个重复结点，需要跳过,这样就跳过了所有重复的结点
                cur = cur.next;
            }
        }
        prev.next = null;
        return fakeHead.next;
    }



    /**
     * 这个只是做到了删除重复的，但是没有把本身的也删除
     */
    public ListNode solution1(ListNode pHead){
        ListNode fakeHead = new ListNode(-1);
        ListNode low = fakeHead;
        ListNode fast = pHead;
        ListNode cur = fakeHead;//新链表的当前结点
        while(fast != null){
            if(low.val != fast.val){
                low = fast;
                cur.next = low;
                cur = cur.next;
                fast = fast.next;
            }else{//说明值是相等的
                fast = fast.next;
            }
        }
        return fakeHead.next;
    }
}
