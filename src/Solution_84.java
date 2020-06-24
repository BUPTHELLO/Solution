public class Solution_84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i=0; i<heights.length; i++){
            int L = i-1;
            int R = i+1;

            while(L>=0 && heights[L]>=heights[i]) L--;
            while(R<heights.length && heights[R]>=heights[i]) R++;

            res = Math.max(res,heights[i]*(R-L-1));
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
