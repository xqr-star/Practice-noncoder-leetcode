import java.util.Scanner;

//公共字符串
public class longest {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (str2.length() < str1.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int[][] dp = new int[str1.length()+1][str2.length()+1];

        //dp[i][j] 表示字符串1到下标i 和 字符串2 到下标j的公共字串长度
        //转移方程  ch1[i] = ch2[j] dp[i][j] = dp[i-1][j-1] +1
        //如果不相等  dp[i][j] = 0


        int maxCount = 0;
        for(int i = 1; i < str1.length();i++){
            for(int j = 1; j < str2.length();j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                if(dp[i][j] > maxCount){
                    maxCount = dp[i][j];
                }

            }
        }

        System.out.println(maxCount);

    }
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (str2.length() < str1.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int count = 0;
        int maxCount = 0;
        for (int i = 0;i < str1.length();i++){
            for(int j = i;j < str1.length();j++){
                if(str2.contains(str1.substring(i,j+1))){
                    count = j+1-i;
                }else {
                    if(count > maxCount){
                        maxCount = count;
                        count = 0;
                    }
                    break;
                }

            }
        }

        if(str1.equals(str2)) maxCount = str1.length();
        System.out.println(maxCount);

    }
    public static void main2(String[] args) {
        //暴力匹配
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (str2.length() < str1.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        //以字符串短的作为匹配 枚举最长公共字符的起始
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();


        int maxCount = 0;
        for(int i= 0; i< ch1.length;i++){
            for(int j = 0; j < ch2.length;j++){
                //要先找到第一个匹配的然后尽可能长的匹配
                //然后再去找下一个和第一个字符匹配的 尽可能长的匹配

                if(ch1[i] == ch2[j] ){
                    //然后再次循环  再次匹配
                    int count = 1;
                   for(int m = i+1, n = j+1; m < ch1.length && n < ch2.length;m++,n++){
                       if(ch1[m] == ch2[n]){
                           count++;
                       }else{
                           if(count > maxCount){
                               maxCount = count;
                           }
                           break;
                       }
                   }

                }
            }
        }
        if(str1.equals(str2)) maxCount = str1.length();
        System.out.println(maxCount);

    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (str2.length() < str1.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        //判断长的 str2 里面是否有str1
        int i = 0;
        int count = 0;
        int maxCount = 0;
        int start = 0;
        for(i = 0; i < str1.length();i++){
            String temp = str1.substring(start,i+1);
            if(str2.contains(temp)){
                count = temp.length();
            }else{
                if(count > maxCount){
                    maxCount = count;
                    count = 0;
                    start = i+1;
                }
            }
        }
        if(count > maxCount){
            maxCount = count;

        }
        System.out.println(maxCount);

//bcefeagihd
//bcfeagi

//bacefaebcdfabfaadebdaacabbdabcfffbdcebaabecefddfaceeebaeabebbad
//dedcecfbbbecaffedcedbadadbbfaafcafdd

    }
}

