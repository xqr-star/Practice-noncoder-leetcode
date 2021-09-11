package 同城58;

import java.util.HashMap;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(solution("asdasdasfdswefsd"));
    }
    public  static int solution (String psw) {
        // write code here

        HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',11);
        map.put('w',12);
        map.put('f',13);

        map.put('d',21);
        map.put('z',22);
        map.put('c',23);

        map.put('g',31);
        map.put('q',32);
        map.put('l',33);


        map.put('j',41);
        map.put('t',42);
        map.put('i',43);

        map.put('m',51);
        map.put('k',52);
        map.put('r',53);

        map.put('p',61);
        map.put('o',62);
        map.put('n',63);

        map.put('s',71);
        map.put('h',72);
        map.put('x',73);

        map.put('v',81);
        map.put('e',82);
        map.put('b',83);

        map.put('y',91);
        map.put('u',92);

        int time = 0;
        char[] arr = psw.toCharArray();
        for(int i = 0;i < psw.length();i++){
            int temp = map.get(arr[i]);
            if(temp % 10 == 3) time += 3;
            if(temp % 10 == 2) time += 2;
            if(temp % 10 == 1) time += 1;

            if(i > 0){
                int last = map.get(arr[i-1]);
                //判断当前的和上一个是否属于同一个按钮
                if(last /10 == temp /10){
                    time += 2;
                }
            }

        }
        return time;
    }
}
