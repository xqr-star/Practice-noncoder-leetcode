//NC68 跳台阶
public class jumpFloor {

    //使用递归
    public int jumpFloor1(int target) {
        if(target == 0) return 1;
        if(target == 1) return 1;
        return jumpFloor1(target-1)+jumpFloor1(target-2);
    }

    //使用迭代
    //发现其实就是斐波那契数列的变形
    public int jumpFloor2(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int a = 1;
        int b = 2;
        int c = 0;
        while (target - 2  >0){
            c = a+b;
            a = b;
            b = c;
            target--;
        }
        return c;
    }
}
