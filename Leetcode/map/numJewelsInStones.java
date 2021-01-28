package map;

import java.util.HashSet;
import java.util.Set;

/*
宝石与石头
就是看你手里的宝石数量是多少
输入: J = "aA", S = "aAAbbbb"
输出: 3
 */
public class numJewelsInStones {


    /**
     * 第三种解法 更快的
     * 把数组当作哈希表
     */
//    public int solution2(String jewels, String stones) {
//
//    }

    /**
     * 自己的思路是把宝石当作一个map 然后键都是宝石的字符 值是0
     * 然后遍历每一个石头  看宝石的map里面是否包含这个石头，包含就val+1
     * 最后返回所有map 的value的和
     * @param jewels
     * @param stones
     * @return
     */

    /*
    是要判断循环遍历自己手里的每一个石头，判断到底在不咋宝石里面
     */
    public int solution(String jewels, String stones) {

        char[] arr = stones.toCharArray();
        int count = 0;
        //将所有宝石放到一个set的数据结构中进行快速遍历
        Set<Character> set = new HashSet<>();
        char[] jewelsArr = jewels.toCharArray();
        for(char ch : jewelsArr){
            set.add(ch);//添加的方法是add
        }
        //每一个石头判断
        for(char ch : arr){
            if(set.contains(ch) ){
                count++;
            }

        }
        return count;

    }
}
