import java.util.Scanner;

public class T2 {
    /**
     * -删除公共字符
     * 为什么思路阻塞
     * 应为想的是删除字符串得到操作，但实际上我只是要求了输出不包含公共字符的字符串，
     * 没说要改变原有的字符串，所以不一定要实现真的删除
     * “是一种假的” 只是控制了输出而已。
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();//这是原始字符
        String str2 = sc.nextLine(); // 这是2需要找的
        char [] arr = str.toCharArray();
        for(int i = 0;i < arr.length;i++){
            //然后第二个字符里面包括了遍历到的这个字符那么这个字符就不打印输出了
            if( !str2.contains(String.valueOf(arr[i]))){   // 将基本数据型态转换成 String 的 static 方法 如果不包含就输出
                System.out.print(arr[i]);
            }
        }

    }
}
