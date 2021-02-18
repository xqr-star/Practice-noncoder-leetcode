package day13;

import java.util.ArrayList;
import java.util.List;

//78. 子集

/**
 * nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 不规定顺序，解集 不能 包含重复的子集。
 *
 */
public class subsets {

    /**
     * 集合中每个元素的选与不选都可以构成一个慢二叉树的状态
     * 左子树是不选 右子树是选
     *
     * 从根节点、到叶子节点的所有路径，构成了所有子集。
     * 可以有前序、中序、后序的不同写法，结果的顺序不一样。
     * 本质上，其实是比较完整的中序遍历。
     */

    public static List<List<Integer>> solution3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        preOrder(nums,0,subset,res);
        return res;

    }
    public static void preOrder(int[] nums,int index, List<Integer> subset,List<List<Integer>> res){
        //表示当前以及没有元素可以去做出选择了
        if(index >= nums.length) return;

        //到了新的状态，
        //记录新的路径，原来的路径重新拷贝一份
        subset = new ArrayList<>(subset);

        //根--每走到一个跟的时候，其实就已经产生了一个subset，需要加入res
        res.add(subset);

        //这个表示走到没有选择的那个路径--左子树
        preOrder(nums,index+1,subset,res);

        //这个表示走到选择的路径--也就是右子树
        subset.add(nums[index]);
        preOrder(nums,index+1,subset,res);

    }

    /**
     * 递归枚举
     * 需要一个下标来标识当前遍历的是哪一个元素
     * 然后需要传入结果的list
     * 需要传入数组
     *
     * 递归执行的逻辑是什么
     * 取出res 链表里面的元素然后往里面追加
     * 递归的出口是什么 下标如果比数组的size 大就结束返回结果list
     *
     * 但是递归容易超出内存限制
     *
     *
     *
     */
    public static void main(String[] args) {
        int[] num = new int[] {1,2,3};
        solution2(num);

    }
    public static List<List<Integer>> solution2(int[] nums) {
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        recursion(nums,i,res);
        return res;
    }

    //recursion 递归枚举
    //这就是一个递归
    //因为事实上就是整个并没有说当此计算完成后并没有返回给上一次它的调用者
    //这是一个不断向下递归，但是没有返回的过程
    private  static void recursion(int[] arr, int index, List<List<Integer>> res) {
        if(index >= arr.length) return;
        //递归里面做的事情就是取出res 然后往每一个res 里面加入当前的值
        int size = res.size();
        //一定要把当前的size保存下来，因为后面不断添加，不断的会让size变换
        for(int i =0;i < size;i++){
            List<Integer> tempList = new ArrayList<>(res.get(i));
            tempList.add(arr[index]);
            res.add(tempList);
        }
        recursion(arr,index+1,res);
    }

    /**
     * 不使用回溯的算法
     * 思路比较简单，但是就是没有想到
     * 循环枚举
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>()); // 往里面加入一个空的额list也就是空集合
        //然后依次遍历数组中的元素
        //可以看作是 依次往链表中的已有的元素后加入一个当前的n 然后插入链表中
        for(int n: nums){
            //依次往链表中每一个已有的元素中插入 -- 所以需要遍历
            int size = res.size();
            for(int i =0 ;i < size;i++){
                List<Integer> temp = new ArrayList<>(res.get(i));//取出res结果链表中之前的元素所形成的链表构造一个一模一样的然后往里面加入
                temp.add(n);//往里面插入当前遍历到的元素
                res.add(temp);//然后向结果链表里面加入元素
            }
        }
        return res;
    }
}
