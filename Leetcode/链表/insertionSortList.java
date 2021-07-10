//147. 对链表进行插入排序
public class insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        //由于头结点可能会改变
        ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode cur = head.next;
        //链表的插排又不能倒着遍历  只能正着写
        //cur 代表当前要进行插排的结点  curNext 保存下一个
        ListNode curNext =  null;
        ListNode sortLast = head;//维护有序链表的最后一个结点
        sortLast.next = null;


        ListNode com =  null;//遍历有序链表的元素
        ListNode prev = null; //上面的前驱
        while(cur != null){
            curNext = cur.next;
            //从头开始遍历
            com = fake.next;
            prev = fake;
            //有序遍历完整
            while(com != null && com.val <= cur.val ){
                prev = com;
                com = com.next;
            }
            //找到了第一个 比 cur 大的值  prev 是前驱
            if(com != null){
                cur.next = com;
                prev.next = cur;
            }else{
                //说明尾插了 尾巴结点就要动
                prev.next = cur;
                sortLast = cur;

                sortLast.next = null;
            }
            cur = curNext; //去下一个要插入的节点去
        }
        return fake.next;
    }
}
