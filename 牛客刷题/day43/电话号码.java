package day43;

import java.util.*;

public class 电话号码 {
    public static void main(String[] args) {

        //一种数据结构把数字和对应的字母放起来
        //借助字符串来当作一个hash表，完成快速的字符到数字的转换操作
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number = "22233344455566677778889999";

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int count = sc.nextInt();
            LinkedList<String> linkedList =new LinkedList<>();
            sc.nextLine();//注意这里跳下一行
            while (count > 0){
                String str = sc.nextLine();
                //首先将字符串所有的- 进行处理-- 基于正则表达式的替换
                str = str.replaceAll("-","");
                //然后判断每一个字符是数字还是字母
                StringBuilder sb =new StringBuilder();
                for(char ch:str.toCharArray()){
                    if(Character.isLetter(ch)){//如果是字母就进行转换的操作从保存的数据结构中获取
                        int index = letter.indexOf(ch);
                        ch = number.charAt(index);
                    }
                    sb.append(ch);
                }
                //输出的时候在第三个和第三个之间加上一个-
                sb.insert(3,'-');
                String sbString = sb.toString();
                if(!linkedList.contains(sbString)){
                  linkedList.add(sbString);
                }

                count -- ;
            }
            //然后将list进行按照字典序进行排序的操作

            //Collections.sort(linkedList);
            //但是不能直接输出，还需要按照字典序进行排序的操作
            linkedList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            //最后输出
            //使用迭代器
//            Iterator<String> iterator = linkedList.iterator();
//            while (iterator.hasNext()){
//                System.out.println(iterator.next());
//            }
            //或者使用流式操作
           linkedList.forEach(System.out::println);
            System.out.println();
        }

    }
}
