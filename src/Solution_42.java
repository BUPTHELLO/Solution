public class Solution_42 {

//    暴力方案，时间复杂度O(n^2)

    /**
     * 对于第i元素位置，每次计算[0,i]区间最大值和[i,end]的最大值
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if (height==null || height.length ==0) return 0;
        int res = 0;

        for (int i = 0;i<height.length;i++){
            int max_l = 0;
            int max_r = 0;
            for (int j=0;j<=i;j++){
                max_l = Math.max(max_l,height[j]);
            }
            for (int j = i;j<height.length;j++){
                max_r = Math.max(max_r,height[j]);
            }
            res = res + Math.min(max_l,max_r)-height[i];
        }
        return res;
    }

    public static int trap_1(int[] height) {
        if (height==null || height.length == 0) return 0;

        int[] max_l = new int[height.length];
        int[] max_r = new int[height.length];

//        用空间换时间
        max_l[0] = height[0];
        for (int i=1;i<height.length;i++){
            max_l[i] = Math.max(max_l[i-1],height[i]);
        }
        max_r[height.length-1] = height[height.length-1];
        for (int j=height.length-2;j>=0;j--){
            max_r[j] = Math.max(max_r[j+1],height[j]);
        }

        int res = 0;
        for (int i=0;i<height.length;i++){
            res = res + Math.min(max_l[i],max_r[i])-height[i];
        }

        return res;

    }
    public static void main(String[] args) {
        int[] num = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(num));
    }
}
