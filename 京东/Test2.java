package 京东;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 最小战力
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 你在玩一款游戏，在游戏中你不断地打倒敌人，并强化自己的战斗力。这个游戏中没有小怪，只有若干个 boss，你把所有 boss 全部打败即完成游戏。打 boss 的顺序可以自选。为了让你们计算起来更加轻松，我大大简化了每个 boss 的属性，每个 boss 只有两项属性：击败它需要的战斗力数值（大于等于该数值即可击败）、击败它之后，你可以永久获得的战斗力增加数值。在游戏的开始，你可以获得一定的战斗力，且这个战斗力与你花的钱成正比。你当然想尽可能地省钱，因此请你计算出能够通关的的前提下，一开始获得的最小战斗力。
 *
 *
 *
 * 输入描述
 * 第一行整数 n，表示 boss 数量。1 <= n <= 100000
 *
 * 后面 n 行，每行两个空格隔开的整数 x, y，表示击败这个 boss 需要的战斗力数值，击败它之后，你可以永久获得的战斗力增加数值。0 <= x, y <= 1000000000。
 *
 * 输出描述
 * 一个整数，表示能通关的情况下，一开始获得的最小战斗力数值。
 *
 *
 * 样例输入
 * 3
 * 1000 100
 * 100 100
 * 200 700
 * 样例输出
 * 200
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        int fit = 0;
        int profit = 0;
        int[] arr = new int[count];
        for(int i = 0; i < count;i++){
            fit = scanner.nextInt();//击败需要的战斗力值
            profit = scanner.nextInt();//击败可以获得的战斗力值
            scanner.nextLine();
            map.put(fit,profit);
            arr[i] = fit;
        }

        Arrays.sort(arr);

        //设定初始的战斗力是最小的
        int chushi = arr[0];
        int shengyu  = map.get(chushi)+ chushi;

        for(int i = 1; i < arr.length;i++){
            if(shengyu < arr[i]) {
                chushi += arr[i] - shengyu;
                break;
            }
            shengyu += map.get(arr[i]);
        }

        System.out.println(chushi);



    }
}
