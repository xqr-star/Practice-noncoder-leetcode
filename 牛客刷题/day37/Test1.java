package day37;

import java.util.*;

public class Test1 {
    /**
     * 字节跳动笔试题
     * operate 代表的是增加或者删除木棒
     * 判断几条棍子能否组成面积大于0的简单多边形只需要满足一个条件
     * 木棒中最长的一个 的长度 max-Len
     * 出来这一根的长度，其他的长度和记作Len
     * 必须满足 Len > max-Len
     *
     * 木棒的总长度是TLen
     * 依据的原理就是两边之和大于第三边
     * 要想保证这个定理成立，这个第三边一定要是最长的边才可以。
     * 只有当TLen - max-Len > max-Len 的时候，才能组成面积大于0的简单多边形
     * @param args
     */

    /**
     * 区别就是改动了以下sort的方式
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operateCount = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        int count = 1;
        while (count <= operateCount){
            int operate = sc.nextInt();
            int operateNum = sc.nextInt();
            if(operate == 1){ //如果操作数字是1就执行插入的操作
                list.add(operateNum);
                sum += operateNum;
            }else { //如果操作是2 就要在链表中删除对应的元素
                //首先要在链表中找到这个元素
                if(list.contains(operateNum)){
                    list.remove(list.indexOf(operateNum));
                    //list.remove((Integer) operateNum); // 获取这个数字的下标然后将它删除
                    sum -= operateNum;
                }
                //如果要删除的元素，之前没有添加过怎么处理
                //如果不包含就不用处理了
            }

            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });

            int max =0 ;
            if(list.size() >0){ //要确保list里面有添加的元素才可以害怕出现数组下标的越界异常
                max = list.get(list.size()-1); //获取最后一个 一定是最大的
            }
            if(sum - max > max){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
            count++;
        }

    }
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operateCount = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        int count = 1;
        while (count <= operateCount){
            int operate = sc.nextInt();
            int operateNum = sc.nextInt();
            if(operate == 1){ //如果操作数字是1就执行插入的操作
                list.add(operateNum);
                sum += operateNum;
            }else { //如果操作是2 就要在链表中删除对应的元素
                //首先要在链表中找到这个元素
                if(list.contains(operateNum)){
                    list.remove(list.indexOf(operateNum));
                    //list.remove((Integer) operateNum); // 获取这个数字的下标然后将它删除
                    sum -= operateNum;
                }
                //如果要删除的元素，之前没有添加过怎么处理
                //如果不包含就不用处理了
            }
            Collections.sort(list); //找到list中最大的一个
            int max =0 ;
            if(list.size() >0){ //要确保list里面有添加的元素才可以害怕出现数组下标的越界异常
                max = list.get(list.size()-1); //获取最后一个 一定是最大的
            }
            if(sum - max > max){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
            count++;
        }


    }

    /**
     * 不知道为什么会用sc.hasNextLine()会爆出异常的问题
     * 请检查是否存在数组越界等非法访问情况
     * Exception in thread "main" java.util.NoSuchElementException
     * 就是因为读取行和读取特定类型的值进行了混用两
     * @param args
     */
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){
            int operate = sc.nextInt();
            int operateNum = sc.nextInt();
            System.out.println(operate);
        }
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen = 1;
        String temp = sc.nextLine();
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(" "); //f分割出来的结果是一个字符串
            int operate = Integer.parseInt(str[0]);
            int operateNum = Integer.parseInt(str[1]);

            int num = map.getOrDefault(1,0);
            if(operate == 1){
                map.put(1,num+operateNum);
                //如果比max-Len的长度大，就更新
                if(operateNum > maxLen){
                    maxLen = operateNum;
                }
            }else{
                map.put(1,num-operateNum);
            }
            if(map.get(1) >= 3){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
