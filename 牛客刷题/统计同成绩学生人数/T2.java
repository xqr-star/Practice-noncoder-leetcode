package code;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }

            Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                int key = sc.nextInt();
                count = map.getOrDefault(key,0);
                map.put(key,count+1);
            }
            System.out.println(map.getOrDefault(sc.nextInt(),0));
        }

    }
}
