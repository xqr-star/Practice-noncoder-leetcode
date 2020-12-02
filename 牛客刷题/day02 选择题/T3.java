package select;

class Base {
    Base() {
        System.out.print("Base");
    }
}

public class T3 extends Base {
        public static void main( String[] args ) {
            new T3();
        //调用父类无参的构造方法
            new Base();
        }
    }
