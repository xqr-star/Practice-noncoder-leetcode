//443. 压缩字符串
public class compress {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','b', 'b', 'b', 'b'}));
    }
    public  static int compress(char[] chars) {
        int slow = 0;
        int fast = 0;
        int memory = 0;
        while(fast < chars.length) {
            int count = 0;
            while (fast < chars.length && chars[fast] == chars[slow]) {
                count++;
                fast++;
            }
            chars[memory++] = chars[slow];
            if(count > 1) {
                String c = Integer.toString(count);
                for (int i = 0; i < c.length() && memory < chars.length; i++) {
                    chars[memory++] = c.charAt(i);
                }
            }
            slow = fast;
        }
        return memory;
    }
}
