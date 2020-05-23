import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//        首先对数组进行排序，
//        排序后固定一个数 nums[i]，
//        再使用左右指针指向 nums[i]后面的两端，
//        数字分别为 nums[L]和 nums[R]，
//        计算三个数的和 sum 判断是否满足为0，
//        满足则添加进结果集

public class Solution_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length<3) return ans;
        for (int i = 0;i<nums.length-1;i++){
            int L = i + 1;
            int R = nums.length - 1;
//            降低计算复杂度
            if (nums[i]>0) break;
//            固定项去重
            if (i>0 && nums[i] == nums[i-1]) continue;
            while (L<R){
                if (nums[i]+nums[L]+nums[R] == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
//                    左右边界去重
                    while (L<R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;

                    L++;
                    R--;

                }else if(nums[i]+nums[L]+nums[R] > 0){
                    R--;
                }else {
                    L++;
                }

            }


        }
        return ans;
    }

    public static void main(String[] arg){

        int[] nums = {-2,0,0,2,2};
        System.out.println(threeSum(nums));

    }
}
