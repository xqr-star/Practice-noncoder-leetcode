package select;

public class T6 {
    public int aMethod(){
        //static int i = 0;//普通方法里面不能定义
        // 也不能使用静态变量
        /*i++;
        return i;*/
        return 1;
    }
    public static void main(String args[]){
        T6 test = new T6();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
    }
}
