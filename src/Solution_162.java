public class Solution_162 {

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int L = 0;
        int R = nums.length-1;

        while (L<R){
            int mid = L+(R-L>>1);
            if (nums[mid]<=nums[mid+1]) L = mid+1;
            else if (nums[mid]>nums[mid+1]) R = mid;
        }

        return L;
    }

    public static void main(String[] args) {
        int[] nums= {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
        int[] arr={1,4,54,5,6,23,8,9,2};
        System.out.println(findPeakElement(arr));
    }
}
