public class Solution_44 {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        //三个初始条件
        dp[0][0] = true;

        for (int j=1;j<=p.length();j++){
            dp[0][j] = dp[0][j-1] && p.charAt(j-1)=='*';
        }
//      boolean数组默认是false。
        for(int i = 1;i<=s.length();i++){
            dp[i][0] = false;
        }

        for (int i = 1;i<=s.length();i++){
            for (int j = 1;j<=p.length();j++){
                if (s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j-1];

//                    或者这么写，下面这个好理解，和上面的等效
//                    boolean temp = false;
//                    for (int k = 0;k<i;k++){
//                        temp = temp || dp[k][j-1];
//                    }
//                    dp[i][j] = dp[i][j-1] || temp;
                }

            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {

        System.out.println(isMatch("aa","a"));

    }
}
