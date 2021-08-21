package 一点资讯;

import java.util.ArrayList;

//肝副本 oj
public class countMaxActivity {
    static int count = 0;
    static int length = 0;

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> time = new ArrayList<>();
        ArrayList<String> temp1 = new ArrayList<>();

        temp1.add("10:00");
        temp1.add("12:00");
        time.add(new ArrayList<>(temp1));
        temp1.clear();

        temp1.add("03:00");
        temp1.add("11:30");
        time.add(new ArrayList<>(temp1));
        temp1.clear();

        temp1.add("11:30");
        temp1.add("14:00");
        time.add(new ArrayList<>(temp1));
        temp1.clear();

        System.out.println(countMaxActivity(time));


    }
    static ArrayList<ArrayList<String>> res = new ArrayList<>();
    public  static int countMaxActivity (ArrayList<ArrayList<String>> timeSchedule) {
        length = timeSchedule.size();
        dfs(timeSchedule,0);
        return count;
    }

    //index 表示现在应该枚举第几个
    private static void dfs(ArrayList<ArrayList<String>> timeSchedule,int index) {
        if(index == length-1){ //如果枚举到了结果 那么返回 设置coutn
            if(res.size() > count) count = res.size();
            return;
        }

        for(int i = index ; i< length;i++){
            //由于需要比较 所以首先需要判断之前有没有往res 里面加元素 如果没有就直接加入
            //如果有的话 就拿出最后一个去比较  和当前遍历的这个元素去比较
            if(res.size() > 0){
                i = index+1;
                String temp = res.get(res.size()-1).get(1);
                String str = timeSchedule.get(i).get(0);
                if(temp.compareTo(str) > 0) continue;
            }

            res.add(timeSchedule.get(i));

            dfs(timeSchedule,index+1);
            //回溯 移动最后一个
            res.remove(res.size()-1);
        }

    }
}
