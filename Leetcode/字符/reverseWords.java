package String;
//剑指 Offer 58 - I. 翻转单词顺序
public class reverseWords {
    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.println(solution1(s));

    }

    /**
     * 将下面的代码进行简化
     * 进行分割+倒序
     */
    public  static String solution2(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = str.length-1; i >= 0;i++){
            if(str[i].equals("")) continue;
            res.append(str[i]).append(" ");
        }
        return res.toString().trim();//因为上面没有对i的下标进行判断，所以最后一字符也添加了空格
        //所以需要对尾字符串也进行去空格的操作
    }
    /**
     * 题目要求，首位不能有空格
     * 分割+交换+添加
     * @param s
     * @return
     */
    public  static String solution1(String s) {
        String[] arr = s.trim().split(" ");//删除首尾空格
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        StringBuilder res = new StringBuilder();
        while(leftIndex < rightIndex){
            String temp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i] .equals("") ){
               continue;//遇到空的字符串就跳过元素
            }else {
                if (i == arr.length - 1) {
                    res.append(arr[i]);
                } else {
                    res.append(arr[i]).append(" ");
                }
            }
        }
        //最后的返回值要求是一个字符
        //构造String  可以使用一个字符数组或者int数组
        //就是不能使用字符数组
        /*String res = new String()*/
        return res.toString();


    }
}
