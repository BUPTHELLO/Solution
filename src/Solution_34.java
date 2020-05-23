public class Solution_34 {

    /**
     *
     * @param nums
     * @param target
     * @return target左边界的索引值,target不存在返回-1
     */
    public static int LeftSearch(int[] nums,int target){
        int L = 0;
        int R = nums.length;

        while (L<R){
            int mid = L + (R-L>>1);
            if (nums[mid] == target) R = mid;
            else if (nums[mid]>target) R = mid;
            else if (nums[mid]<target) L = mid+1;
        }
        if (L == nums.length) return -1;
        return nums[L] == target?L:-1;
    }

    /**
     *
     * @param nums
     * @param target
     * @return target右边界的索引值,target不存在返回-1
     */
    public static int RightSearch(int[] nums,int target){
        int L = 0;
        int R = nums.length;
        while (L<R){
            int mid = L + (R-L>>1);
            if(nums[mid] == target) L = mid+1;
            else if (nums[mid] > target) R = mid;
            else if (nums[mid] < target) L = mid +1;
        }
        if (L-1<0) return -1;
        return nums[L-1] == target?L-1:-1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int L = LeftSearch(nums,target);
        int R = RightSearch(nums,target);
        return new int[]{L,R};
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(RightSearch(arr,7));
    }
}
