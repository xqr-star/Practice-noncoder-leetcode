package 有赞;

/**
 * 两个线程共用一个hello World 实例 一个hello 一个 world 执行n次
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(helloWorld(2));

    }
    public  static String helloWorld (int n) {

        StringBuilder sb = new StringBuilder();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                sb.append("hello");
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                sb.append("world");
            }
        };

        while (n > 0) {
            Thread thread = new Thread(runnable1);
            thread.start();

            Thread thread2 = new Thread(runnable2);
            thread2.start();

            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            n--;
        }

        return sb.toString();
    }
}
