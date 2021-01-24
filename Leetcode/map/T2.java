package map;

import java.util.Map;
import java.util.TreeMap;

//复制带随机指针的链表
public class T2 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        //老新映射
        Map<Node ,Node> map = new TreeMap<>((o1,o2)->{
            //因为测试用例的3 导致 put都是一样的
            //但我人为不一样啊 -- 因为蛮难找value比较，
            //所以就是会出现这样的情况
            return o1.hashCode() - o2.hashCode();
            //  return o1.val - o2.val;
            //因为我并不进行真的排序，所以怎么排序的我不关心
            //只看它的映射关系
        });
        //因为map进行push操作需要有大小比较的能力
        Node cur = head;
        Node newHead = new Node(-1);
        Node pre = newHead;
        while(cur != null){
            Node node = new Node(cur.val);
            pre.next = node;
            pre = node;
            // 保存新老结点之间的关系
            map.put(cur,node);

            cur = cur.next;
        }
        //处理random 的关系
        cur = head;
        pre = newHead.next;
        while (cur != null){

            //因为cur.random 可能出现空 ，所以会出现空指针异常
            if(cur.random != null){
                pre.random = map.get(cur.random);
            }else{
                pre.random = null;
            }
            //然后往后走
            cur = cur.next;
            pre = pre.next;
        }

        return newHead.next;
    }

    //保存一个映射的关系
    //保存老节点 1  和 新结点1 之间的关系
    public Node copyRandomList1(Node head) {

        //老新映射
        Map<Node ,Node> map = new TreeMap<>((o1,o2)->{
            return o1.val - o2.val;
            //因为我并不进行真的排序，所以怎么排序的我不关心
            //只看它的映射关系
        });
        //因为map进行push操作需要有大小比较的能力
        Node cur = head;
        Node newHead = new Node(-1);
        Node pre = newHead;
        while(cur != null){
            Node node = new Node(cur.val);
            pre.next = node;
            pre = node;
            // 保存新老结点之间的关系
            map.put(cur,node);

            cur = cur.next;
        }
        //处理random 的关系
        cur = head;
        pre = newHead.next;
        while (cur != null){
           pre.random = map.get(cur.random);
           //然后往后走
            cur = cur.next;
            pre = pre.next;
        }

        return newHead.next;

    }


    //普通链表的复制
    public Node copy(Node head) {
        Node cur = head;
        Node newHead = new Node(-1);
        Node pre = newHead;
        while(cur != null){
            Node node = new Node(cur.val);
            pre.next = node;
            pre = node;
            cur = cur.next;
        }
        return newHead.next;
    }
}
