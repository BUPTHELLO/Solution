import java.util.HashSet;
import java.util.List;

public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {

//        判断0~i-1字符是否被拆分
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);

        for(int i = 1; i<dp.length; i++){
            for (int j=0;j<=i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution_139 solution_139 = new Solution_139();

    }
}
