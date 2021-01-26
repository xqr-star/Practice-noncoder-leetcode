package day04;

public class merge {

    /*
    直接在原有的基础上做出改变
    从num1 的末端开始写入数据 不需要额外的空间
    让俩个下标都指向最后，然后额外下标指向数组1的最后，谁大谁放进去
     */
    public void solution2(int[] nums1, int m, int[] nums2, int n) {
        int left =m-1;
        int right = n-1;
        int p = nums1.length-1;//指向数组1的最后一个位置
        while (left >= 0 &&right>= 0){
            if(nums1[left] >=  nums2[right]){
                nums1[p--] = nums1[left];
                left--;
            }else {
                nums1[p--] = nums2[right];
                right--;
            }
        }
        //下面的这个可以直接不写
//        while (left >=0){
//            //那就可以不用动了就放里面就好了
//            break;
//        }
        while (right >=0){
            nums1[p--] = nums2[right];
            right--;
        }




    }



    /*
    采用额外的数组空间 然后搬回去 但是这样的空间复杂度就是m+n
    不如只保存num1的数量拷贝一份 然后把nums1 当作那个新的数组放进去
     */
    public void solution1(int[] nums1, int m, int[] nums2, int n) {
        int[] temp =   new int[m];
        System.arraycopy(nums1,0,temp,0,m);
        //src - 源数组。srcPos - 源数组中的起始位置
        // 。dest - 目标数组。destPos - 目标数据中的起始位置。
        // length - 要复制的数组元素的数量
        int left = 0;
        int right = 0;
        int i =0;
        while (left < temp.length && right < nums2.length){
            //谁小谁往新数组里面放，然后往后移动下标
            if(temp[left] <= nums2[right]){
                nums1[i++] = temp[left];
                left++;
            }else {
                nums1[i++] = nums2[right];
                right++;
            }
        }
        //出来的时候看谁没放完
        while (left < temp.length){
            nums1[i++] = temp[left];
            left++;
        }
        while (right < nums2.length){
            nums1[i++] = nums2[right];
            right++;
        }

    }

}
