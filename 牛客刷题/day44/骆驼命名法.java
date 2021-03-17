package day44;

import java.util.Scanner;

public class 骆驼命名法 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String  str = sc.nextLine();
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for(char ch :str.toCharArray()){
                if(ch == '_'){
                    flag = true;
                    continue;
                }
                if(flag == false){
                    sb.append(ch);
                }else{
                    ch = Character.toUpperCase(ch);
                    sb.append(ch);
                    flag = false;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
