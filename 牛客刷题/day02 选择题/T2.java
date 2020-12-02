package select;

public class T2 {
    public static class SystemUtil{
        public static boolean isAdmin(String userId){
            //return userId.toLowerCase()=="admin";
            return userId.toLowerCase().equals("admin");
            //return userId =="admin";
            //return userId .equals("admin");
        }
        public static void main(String[] args){
            System.out.println(isAdmin("Admin"));
            //System.out.println(isAdmin("admin"));//这种方式不是通过new 来获取到
            //所以和  userId =="admin"; 是一个变量时true
        }
    }
}
