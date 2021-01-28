package map;

import java.util.*;

/**
 * 前K个高频单词
 * 牛逼！！！
 */
public class topKFrequent {



    /**
     * 解法二： 只使用一个list
     * @param words
     * @param k
     * @return
     */
    public  List<String> solution2(String[] words, int k) {

        Map<String, Integer> map = new HashMap();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //相当于是list里面存放的是map 里面的所有key
        //count.keySet(); 返回的是一个set
        List<String>list = new ArrayList(map.keySet());  //new ArrayList 的参数可以放一个set进去

        //因为最后返回的是一个list 所以刚开始就new 一个list

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) > map.get(o2)){//先比较次数
                    return  -1;
                }else if( map.get(o1) < map.get(o2)) {
                    return 1;
                }else {
                    //比较字符串
                    return o1.compareTo(o2);
                }
            }
        });

//        Collections.sort(list, (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
//                w1.compareTo(w2) : map.get(w2) - map.get(w1));

        return list.subList(0, k); // list还可以进行截取操作
    }


    /**
     * 解法- ：自定义类
     * 但是需要用到两个list
     * 一个list里面放自定义类
     * 但是最后返回的list 是String 所以还是需要转换
     */

    //自定义类和比较能力
    class WordNumber  implements Comparable{
        public String str;
        public Integer count;

        public WordNumber(String str, Integer count) {
            this.str = str;
            this.count = count;
        }

        //使这个类具备比较的能力
        @Override
        public int compareTo(Object o) {
            WordNumber o2 = (WordNumber) o;
            //先按照出现的次数排序
            if(this.count > o2.count){
                return  -1;//表示降序
            }else if(this.count < o2.count){
                return 1;
            }else {
                //比较单词的顺序
                return this.str .compareTo(o2.str);
            }

        }
    }
    public List<String> solution(String[] words, int k) {


        //1.统计每一个单词出现的顺序
        Map<String,Integer> map = new TreeMap<>();
        for(String str : words){
            map.put(str,map.getOrDefault(str,0) + 1);
        }


        //2.找到出现次数是前k个的单词  要求的输出方式是按照次数 + 出现的次数排序
        // 拿到【单词 + 出现次数】 的数组 重写数组的排序方法
        // 如果要对两个都实现排序 -- 自定义一个类


        List<WordNumber> list = new ArrayList<>();
        int i =0;

        //拿出map的元素然后进行放入
        for(Map.Entry<String,Integer> mapSet: map.entrySet()){
            WordNumber temp = new WordNumber(mapSet.getKey(),mapSet.getValue());
            list.add(temp);
        }

        //排序 由于类不具备比较的能力
       Collections.sort(list);


        //3.按照指定的格式输出--按照数组的方式输出
        //return list.subList(0,k+1); 原来list可以直接sublist
        List<String> res = new ArrayList<>();
        for(int j =0 ;j < k;j++){
            WordNumber  temp = list.get(j);
            res.add(temp.str);
        }
        return res;
    }


    /**
     * 下面的是错的，但是可以思考以下错误的理由
     * @param words
     * @param k
     */
    public void solution1(String[] words, int k) {

        //1.统计每一个单词出现的次数 map
        //涉及到map排序 重写compareTo  -- 这个做不了因为重写的比较器用不了
        Map<String,Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1;
            }
        });
    }



}
