package 爱奇艺;

import java.util.Scanner;

//湖泊抽水问题 贪心+搜索
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] split1 = sc.nextLine().split("\\[");
        String[] split2 = split1[1].split("\\]");
        String [] split3  = split2[0].split(",");

        //首先我得知道你有几个湖泊
        int maxNUm = 0;
        int i = 0;
        int[] rains = new int[split3.length];
        for(String str : split3){
            if(maxNUm < rains[i]) maxNUm = rains[i];
            rains[i++]  = Integer.parseInt(str);
        }
        int[] memory = new int[maxNUm+1];
        int[] ans = new int[rains.length];
        for(i = 0; i < rains.length;i++){
            int temp = rains[i];
            if(temp != 0) { //开始灌水
                ans[i] = -1;
                memory[temp] = 1;//表示第一个湖泊是满的
            }else {

            }

        }

    }
}
