import java.util.HashSet;
import java.util.Stack;

public class Solution_5 {

//    左侧闭合右侧开区间，判断序列是否回文
    public static boolean judge(String str,int start,int end){
        Stack<Character> stack = new Stack<>();
        for (int i = start;i < end;i++){
            stack.push(str.charAt(i));
        }
        while (!stack.empty()){
            if (stack.pop() != str.charAt(start++)){
                return false;
            }
        }
        return true;
    }

//    暴力方案：
//    1、指定区间内判断字符串是否回文
//    2、遍历字符串的所有子串
    public static String longestPalindrome_force(String s) {
        int length = 0;
        String res = "";
        for(int i=0 ; i < s.length();i++){
            for (int j = i+1 ; j <= s.length();j++){
                if (judge(s,i,j) && (j-i)>=length){
                    length = Math.max(length,j-i);
                    res = s.substring(i,j);
                }
            }
        }
        return res;
    }

//    动态规划方案：
//    dp_matrix[i][j] = dp_matrix[i+1][j-1] && (str.charAt(i)==str.charAt(j))
//    其中i表示start，j表示end
//    i<=j
//    注意填表的顺序是按列进行
public static String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp_matrix = new boolean[length+1][length+1];
        for (int i=1;i<=length;i++){
            dp_matrix[i][i] = true;
        }
        return "111";
}



    public static void main(String[] arg) {
        String str = "azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc";
        System.out.println(judge(str,0,str.length()));
        System.out.println(longestPalindrome(str));
    }
}
