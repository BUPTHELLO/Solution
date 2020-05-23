public class Solution_75 {
    public void sortColors(int[] nums) {
        int L = -1;
        int R = nums.length;

        int Cur = 0;

        while(Cur<R){
            if (nums[Cur] == 1) Cur++;
            else if (nums[Cur]<1) swap(nums,++L,Cur++);
            else if (nums[Cur]>1) swap(nums,--R,Cur);
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static void main(String[] args) {

    }
}
