package shopee;

//蚂蚁爬杆
//详细描述
//有一个跟27厘米的细木杆，
// 在第3厘米、7厘米、11厘米、17厘米、23厘米这五个位置个有一只蚂蚁。
// 木杆很细，不能同时通过两只蚂蚁。
// 开始时，蚂蚁的头朝左还是朝右是任意的，它们只会朝前或者掉头，但不会后退。
// 当任意两只蚂蚁碰头时，它们会同时掉头朝反方向走。
// 假设蚂蚁们每一秒可以走1厘米的距离。
// 编写程序,求所有蚂蚁都离开木杆的最短时间和最长时间。（异常情况下，请将最短时间和最长时间设置为0，并返回）
public class Test2 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 计算蚂蚁爬杆的最短时间和最长时间
     * @param length int整型 杆的长度
     * @param list_pos double浮点型一维数组 蚂蚁的位置
     * @param ant_num int整型 蚂蚁的数量
     * @param speed double浮点型 蚂蚁的速度
     * @return double浮点型一维数组
     */

    public static void main(String[] args) {
        double[] arr = new double[]{3,9,18};

        double[] res = cal_time(25,arr,3,1.0);
        System.out.println(1);

    }
    public  static double[] cal_time(int length, double[] list_pos, int ant_num, double speed) {
        // write code here
        double[] res = new double[2];
        res[0] = Double.MAX_VALUE;

        //获取每一个蚂蚁所在的位置
        int mid = length/2;
        if(ant_num == 1){
            if(mid > list_pos[0]){
                res[0] = list_pos[0];
                res[1] = length -list_pos[0];
            }else {
                res[0] = length- list_pos[0];
                res[1] = list_pos[0];
            }
        }

        double[] min = new double[list_pos.length];

        for(int i = 0; i < ant_num;i++){
            double distance = list_pos[i];
            if(mid  >= distance){
                min[i] = distance;
            }else {
                min[i] = length- distance;
            }
        }

        for(int i = 0;i  < ant_num;i++){
            res[0] = Math.min(res[0],min[i]);
        }

        //找出离中点最近的蚂蚁

        int i = 0;

        for( i = 0; i < ant_num;i++){
            if(list_pos[i]  >= mid) break;
        }
        i = i-1;

        //表示的是距离
        double left = list_pos[0];
        double right = list_pos[i];
        int count = 0;
        while (left < right){
            left += speed;
            right -= speed;
            count++;
        }

        res[1] = count + (length - left)/speed;
        return res;
    }
}
