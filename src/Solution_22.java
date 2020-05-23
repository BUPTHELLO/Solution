import java.util.ArrayList;
import java.util.List;

public class Solution_22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0){
            return res;
        }
        backtrack(res,"",0,0,n);
        return res;
    }

    public static void backtrack(List<String> res, String cur, int left, int right, int n){
        if (left == n && right == n){
            res.add(cur);
            return;
        }
        if (right > left) return;
        if (left < n){
            backtrack(res,cur+"(",left+1,right,n);
        }
        if (right<n){
            backtrack(res,cur+")",left,right+1,n);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(0));
    }
}
