package day43;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 求和 {

    /**
     * 动态规划的背包问题
     * 需要对返回的结果进行字典序的排序
     * 所以结果集一定要具备比较的能力
     */

    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //深度优先遍历
        dfs(1,m,n);
        //打印处理结果集
        for(int i = 0;i < res.size();i++){
            list = res.get(i);
            int j = 0;
            for(; j < list.size()-1;j++){
                System.out.print(list.get(j) +" ");
            }
            System.out.println(list.get(j));
        }
    }

    //核心逻辑就是求n个数字中 和为 m的数的集合
    private static void dfs(int index ,int sum ,int n) {
        //如果这个数字== 0已经不需要在进行深度优先遍历
        if(sum == 0){
           res.add(new ArrayList<>(list));  //为什么add一个进去，这个是用来存放下一个的
        }else { //开始进行不断的动态规划
            //不同的处理逻辑
            for(int i = index;i <= sum && i <= n;i++){
                //结果集里面添加这个元素，后面的总count 递归的值变化
                list.add(i);
                dfs(i+1,sum -i,n);
                //结果集里面如果不添加这个值
                //add默认是尾插 就把最后的那一个删除
                list.remove(list.size()-1);
            }
        }
    }

    /**
     * 你写的这个的限制条件是 只能出现两个数字
     * 但真正要做到的是 动态规划
     * 任意个数字的组合
     * @param args
     */

    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key = sc.nextInt();
        //默认是一定有的
        //为什么要用hashMap的方式-- 一个是为了快速检索 还有一个是为了能够将之前遍历的元素存起来 同时以及它相差的元素
        HashMap<Integer,Integer> map = new HashMap<>();
        int sub = 0;
        for(int i = 1; i <= n;i++){
            sub = key - i;
            //如果用的是get的方法返回值是一个null
            if(!map.isEmpty() && map.getOrDefault(sub,0) != 0 ){
                System.out.println(i+" "+sub);
                map.remove(i,sub);
            }else{
                map.put(i,sub);
            }
        }
    }


}
