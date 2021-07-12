package 数组;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

//350. 两个数组的交集 II
public class intersect {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,2,1};
        int[] arr2 = new int[]{2,2};
        intersect(arr1,arr2);
    }

    public  static int[] intersect(int[] nums1, int[] nums2) {
        HashMap <Integer,Integer> map = new HashMap<>();
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        for(int num : nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int [] arr = new int[nums1.length];
        int i = 0;
        for(int num: nums2){
            if(map.containsKey(num)){
                int val = map.get(num);
                if(val > 0){
                    arr[i++] = num;
                    map.put(num,val-1);
                }
            }
        }
        //是[) 区间
        return Arrays.copyOfRange(arr,0,i);
    }


    //是有一点问题的
    public  static int[] intersect1(int[] nums1, int[] nums2) {
        LinkedList <Integer> list = new LinkedList<Integer>();
        for(int num : nums1){
            list.add(num);
        }

        int len = Math.min(nums1.length,nums2.length);
        int[] arr = new int[len];
        int i = 0;
        for(int num : nums2){
            if(list.contains(num)){
                arr[i++] = num;
            }
        }
        return arr;

    }
}
