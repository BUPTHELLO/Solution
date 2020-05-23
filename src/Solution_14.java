public class Solution_14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String ans = strs[0];
        for (int i = 1;i<strs.length;i++)
        {
            int j = 0;
            for (;j<Math.min(ans.length(),strs[i].length());j++){
                if (strs[i].charAt(j) != ans.charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
        }
        return ans;
    }

    public static void main(String[] arg) {
        String[] str = {"aaa","aa","aaa"};
        System.out.println(longestCommonPrefix(str));
    }
}
