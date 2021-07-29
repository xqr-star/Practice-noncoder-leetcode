import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//剑指 Offer 38. 字符串的排列
public class permutation {
    static String[] str ;
    static List<String> list = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(permutation("suvyls"));
    }
    public static String[] permutation(String s) {
        if(s == null) return str;
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int length = arr.length;
        dfs(arr,0,length);
        str = new String[list.size()];
        int i = 0;
        for(String string : list){
           str[i++] = string;
        }
        return str;


    }

    //枚举每一个字符出现的位置

    //需要一个变量来记忆哪一个字符被枚举过了
    static  StringBuilder sb = new StringBuilder();

    private static void dfs(char[] arr, int index, int length) {
        if(index == length){
            list.add(sb.toString());
            return;
        }

        // 枚举index的位置 去 遍历每一个字符
        for(int i = 0; i< length;i++){
            if(arr[i] == '.' ||( i >0 && arr[i]== arr[i-1] && arr[i-1]!= '.')) continue;
            //这样来表示枚举过了
            char ch =arr[i];
            sb.append(ch);
            arr[i] = '.';
            dfs(arr,index+1,length);

            //还原回去
            arr[i] = ch;
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
