package code;

public class Plus {
    /**
     * 出错的原因，就是有进位的问题
     */

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(9);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        a.next = n2;
        n2.next = n3;

        ListNode b = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
       b.next = n4;
       n4.next = n5;

       ListNode node =  plusAB(a,b);
        System.out.println(node);

    }
    public  static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        int sum = 0;
        int nextVal = 0;
        ListNode head = new ListNode(-1);
        ListNode cur  = head ;
        while (a != null && b != null){
            //两个都不为空的时候，都往后走
            sum  = a.val+b.val+nextVal;
            ListNode node  = new ListNode(sum%10);
            nextVal = sum/10;
            cur.next = node;
            cur = cur.next;

            //移动 a b 的位置
            a = a.next;
            b = b.next;
        }
        //最后看谁不为空就头插入进去
        while (a != null){
            sum = nextVal + a.val;
            ListNode node  = new ListNode(sum % 10);
            nextVal = sum/10;
            cur.next = node;
            cur = cur.next;
            a = a.next; // 不要忘记这个要调整
        }
        while ( b !=null){
            sum = nextVal + b.val;
            ListNode node  = new ListNode(sum % 10);
            nextVal = sum/10;
            cur.next = node;
            cur = cur.next;
            b = b.next;
        }
        //有可能两个数的位数相同，但还是会有进制产生
        if(nextVal != 0) {
            ListNode node = new ListNode(nextVal);
            cur .next = node;
        }
        return head.next;
    }
}
