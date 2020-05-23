public class Solution_84 {

    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i=0;i<heights.length;i++){
            for (int j = i;j<heights.length;j++){
//                寻找【i，j】区间的最小值
                int height = findMin(heights,i,j);
                res = Math.max(res,height*(j-i+1));
            }
        }
        return res;

    }

    /**
     * 寻找[i,j]区间内的最小值
     * @param num
     * @param i
     * @param j
     * @return
     */
    private static int findMin(int[] num,int i,int j){
        int res = num[i];
        for (;i<=j;i++){
            res = Math.min(res,num[i]);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
