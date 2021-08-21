package shopee;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(main("Abc123"));
    }
    public static boolean main(String input) {
        // write code here
        //0 表示大写字母
        //1 表示小写字符
        //2 表示数字

        boolean [] flag = new boolean[3];
//        String str = input.substring(1, input.length()-1);

        char[] arr = input.toCharArray();
        for(int i = 0;i < input.length();i++) {
            if (i == 0 && (arr[i] < 'A' || arr[i] > 'Z')) {
                return false;
            }
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                flag[1] = true;
            }else if(arr[i] >='A' && arr[i] <= 'Z'){
                flag [0] = true;
            }else if(arr[i] >='0' &&arr[i] <= '9') {
                flag[2] = true;
            }else {
                return false;
            }
        }

        int count = 0;
        for (boolean b : flag) {
            if (b) count++;
        }
        if(count >= 2) return true;
        return false;
    }
}
