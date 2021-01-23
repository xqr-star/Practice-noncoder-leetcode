package day01;

public class T2 {

    /**
     * 优化时间复杂度
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        //数组翻转--写的是一个闭区间的做法
        //先整体反转
        k %= nums.length;//注意判断k的下标
        reverse(nums,0, nums.length-1);
        //前面的反转
        reverse(nums,0,k-1);
        //后面的反转
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] arr,int start,int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }





    //向右移动k 其实就是把最后的k个元素移动到前面来使用
    //使用链表的做法--
    //思想可以不错不错

    public  static void rotate1(int[] nums, int k) {
        //对k 进行判断吗--优化一下
        Node head = null;
        Node cur = head;
        for(int i: nums){
            Node node = new Node(i);
            if(head == null){
                head = node;
                cur = node;
            }
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head; // 先让链表头尾相连
        int temp = nums.length - k;
        cur = head;
        while(temp-1 != 0) {
            cur = cur.next;
            temp --;
        }


        head = cur.next;
        cur.next = null;
    }

    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
