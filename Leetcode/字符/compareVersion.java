//165. 比较版本号
public class compareVersion {
    public static void main(String[] args) {
        String s = "1.0.1";

        String s2 =  "1";
        System.out.println(compareVersion(s, s2));
    }

    public  static int compareVersion(String version1, String version2) {

        //每一个字符串开始的指针
        int i = 0;
        int j = 0;
        while ( i < version1.length() ||  j < version2.length()){
            //每一个字符串结束的指针
            int x = i ;
            int y = j;
            while ( x< version1.length() && version1.charAt(x) != '.'){
                 x++;
            }

            while (y < version2.length() && version2.charAt(y) != '.'){
                y++;
            }

            //如果相等的话，就说明走完了  需要截取的 [i,x)
            int num1 = x == i ? 0: getNum(version1,i,x);
            int num2 = y == j ? 0:getNum(version2,j,y);

            int cmp = Integer.compare(num1,num2);
            if(cmp != 0){
                return cmp;
            }

            //指针需要往后移动  当前的xy 都是指向 .
            i = x+1;
            j = y+1;
        }
        return 0;
    }

    private static int getNum(String s, int i, int x) {
        int num = 0;
        String  sub = s.substring(i,x);
        num = Integer.parseInt(sub);
        return num;
    }


    public  static int compareVersion1(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        //首先按照数组的长度进行遍历
        int i =0;
        int j = 0;
        int num1 = 0;
        int num2 = 0;
        for(; i < arr1.length && j < arr2.length; i++,j++){
            num1 = Integer.parseInt(arr1[i]);
            num2 = Integer.parseInt(arr2[i]);
            int cmp = Integer.compare(num1,num2);
            if(cmp != 0){
                return cmp;
            }
        }

        //最后谁还有长度返回 并且里面的数字不是0 就返回谁的值，否则返回0
        while (i < arr1.length ){
            num1 = Integer.parseInt(arr1[i]);
            if(num1 > 0) return 1;
            if(num1 < 0) return -1;
            i++;
        }

        while (j < arr2.length ){
            num2 = Integer.parseInt(arr2[j]);
            if(num2 > 0) return -1;
            if(num2 < 0) return 1;
            j++;
        }

        return 0;

    }
}
