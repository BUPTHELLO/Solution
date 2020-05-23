public class BinarySearch_Template {
//    二分思路参考
//    https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
//    常见的二分题目：
//    https://leetcode-cn.com/explore/learn/card/binary-search/212/template-analysis/847/

//    假定数组从小到大依次排列
//    教科书的二分搜索，在细节的处理非常复杂
    public static int BinarySearch(int[] nums,int target){
        if (nums==null || nums.length==0){
            return -1;
        }

        int L = 0;
        int R = nums.length-1;
        while (L<= R){
            int mid = L + (R-L>>1);
            if (nums[mid]== target) return mid;
            else if (nums[mid] < target) L = mid+1;
            else R = mid-1;
        }
        return -1;
    }

//    二分搜索寻找target的左边界
//    功能：数组中小于target数量
    public static int Binary_Left(int[] nums,int target){
        if (nums == null || nums.length ==0){
            return 0;
        }
        int L = 0;
        int R = nums.length;
        while (L<R){
            int mid = L+(R-L>>1);
            if (nums[mid] == target) R = mid;
            else if (nums[mid] > target) R = mid;
            else if(nums[mid] < target) L = mid+1;
        }
        return L;

////        添加如下部分实现二分搜索
//        if (L == nums.length) return -1;
//
////        if (nums[L] == target) return L;
////        else if(nums[L] != target) return -1;
//        return nums[L] == target?L:-1;
    }

    public static int findmin(int[] nums){
        int res = nums[0];
        for (int i = 0;i<nums.length;i++){
            res = Math.min(res,nums[i]);
        }
        return res;
    }

    public static int find_rotate(int[] num){
        if (num[0] <= num[num.length-1]) return 0;

        int L = 0;
        int R = num.length-1;

        while (L<R){
            int mid = L+(R-L>>1);
            if (num[mid]>num[mid+1]) L = mid+1;
            else if (num[mid]>num[R]) L = mid + 1;
            else if (num[mid]<num[R]) R = mid;
        }
        return L;
    }



    public static void main(String[] args) {
        int[] nums = {8,90,100,1,3,5,7};
        System.out.println(find_rotate(nums));


    }
}
