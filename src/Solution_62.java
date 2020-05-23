public class Solution_62{

    /**
     * Dp[i][j] = Dp[i-1][j] + Dp[i][j-1]
     * Dp[i][j] 代表（0，0）位置到（i，j）位置的路径数量
     * @param m 矩阵的行
     * @param n 矩阵的列
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] Dp = new int[m][n];

        for (int i=0;i<m;i++){
            Dp[i][0] = 1;
        }
        for (int j=0;j<n;j++){
            Dp[0][j] = 1;
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                Dp[i][j] = Dp[i-1][j] + Dp[i][j-1];
            }
        }
        return Dp[m-1][n-1];
    }
    public static void main(String[] args) {

    }
}
