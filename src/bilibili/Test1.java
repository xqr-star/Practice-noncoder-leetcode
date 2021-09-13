package bilibili;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 找寻英文句子中单词包含x为后缀的单词首个字母位置
 *
 * 目前只是不是后缀
 * 83
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine().trim();
        String x = scanner.nextLine().trim();
        if(str.equals("") || x.equals("") ) System.out.println("[]");

        ArrayList<Integer> arrayList = new ArrayList<>();

        int flag = 0;//记录当前的字符所在的第一个字母的位置
        int length = x.length();

        for(int i = 0; i < str.length();i++) {
            if (Character.isLetter(str.charAt(i))) {
                if(i + length-1 <str.length() && str.substring(i, i + length).equals(x)){
                    //判断是不是后缀
                    if(i+length >= str.length()) {
                        arrayList.add(flag);
                        continue;
                    }
                    if(!Character.isLetter(str.charAt(i+length))) {
                        arrayList.add(flag);
                    }
                }

            } else {
                flag = i + 1;
            }
        }

        System.out.print("[");
        for(int i = 0; i< arrayList.size();i++){
            if(i == arrayList.size() - 1) {
                System.out.print(arrayList.get(i));
            }else {
                System.out.print(arrayList.get(i) + ",");
            }
        }

        System.out.print("]");
    }
}
