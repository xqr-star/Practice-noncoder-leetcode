package code;

public class T1 {
    public static void main(String[] args) {
        //public boolean contains(CharSequence s)
        // CharSequence是一个interface，所以我们没法直接用它的对象，
        //只能用它的实现类的对象，它有几个实现类String，StringBuilder等
        String s = "abcd";
        //System.out.println(s.contains('a'));
        System.out.println(s.contains("a"));

    }
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        //依次拿出字符串数组里面的每一个元素，然后判定
        boolean [] arr = new boolean[p.length];
        for(int i = 0; i < arr.length;i++){
            arr[i] = s.contains(p[i]);  // contains 里面的参数可以是些什么东西
        }
        return arr;
    }
}
