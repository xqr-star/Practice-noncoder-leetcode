package day05.code;

public class isLongPressedName {
    public static void main(String[] args) {
        System.out.println(solution("alexd","ale"));
    }

    public static boolean solution(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 &&  typed.charAt(j) == typed.charAt(j-1)) {
                j++;
            } else {
                //处理的可能是第一个进来就不相等，因为如果走上面的elseif逻辑会越界
                //处理name走完了 typed没走完 但是它不等于右边的
                //alex  alexed
                return false;
            }
        }
        //ale alex
        //处理可能j走完但是 i没有走完的情况
        return i == name.length();

    }



        public static boolean solution1(String name, String typed) {

//        int left = 0;
//        int right = 0;
//        //name 是待匹配字符
//        //如果待匹配字符都走完了，就说明是全部匹配到了
//        if(typed.length() ==1){
//            return name.equals(typed);
//        }
//        while (left < name.length()){
//            if(name.charAt(left)  == typed.charAt(right)) {
//                left++;
//                right++;
//            }else if(typed.charAt(right-1) == typed.charAt(right)){//说明左右两个相等了 //考虑越界问题
//                right++;
//            }else {
//                return false; //如果它和它前面不不相等，和left的位置也不相等，那么就返回false；
//            }
//        }
        int right = 0;
        int left = 0;
        while (left < name.length()){
            //第一个必须相等 哟啊特殊处理不然会会走到越界的逻辑
            if(left == 0){
                boolean flag =  name.charAt(left)==typed.charAt(right);
                if(flag == false){
                    return false;
                }
            }

            if(name.charAt(left)  == typed.charAt(right) ) {
                left++;
                right++;
            }else if(typed.charAt(right-1) == typed.charAt(right)){//说明左右两个相等了 //考虑越界问题
                right++;
            }else {
                return false; //如果它和它前面不不相等，和left的位置也不相等，那么就返回false；
            }
        }
        //最后出来的时候看以下right 的指向
        while (right < typed.length()) {
            if(typed.charAt(right) != typed.charAt(right-1))
                return false;
            right++;
        }

        //最后出来，说明所有要匹配的都匹配到了
        return true;
    }
}
