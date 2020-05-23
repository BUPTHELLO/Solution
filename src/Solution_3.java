import java.util.HashSet;

public class Solution_3 {

    //如果子字符串中的字符都是唯一的，它会返回 true，否则会返回 false,左闭右开区间。
//    注意编程过程中的左闭右开的思路
//    时间复杂度O(n^3)

    public static boolean allunique(String s,int start,int end){
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = start;i < end;i++){
            if (hashSet.contains(s.charAt(i))){
                return false;
            }
            hashSet.add(s.charAt(i));
        }
        return true;
    }


    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
        int length = 0;
        for (int i = 0; i < s.length() ; i++){
            for (int j = i+1 ;j <= s.length();j++){
//                左闭右开区间
                if (allunique(s,i,j)){
                    length = Math.max(length,j-i);
                }
            }
        }
        return length;

    }

//    使用滑动窗口进行分析
//    时间复杂度O(n)
    public static int lengthOfLongestSubstring_1(String str){
        HashSet<Character> hashSet = new HashSet<>();
        int start = 0;
        int end = 0;
        int length = 0;

        while (start < str.length() && end < str.length()){
            if (!hashSet.contains(str.charAt(end))){
                hashSet.add(str.charAt(end));
                end = end + 1;
                length = Math.max(length,end-start);
            }else {
                hashSet.remove(str.charAt(start));
                start = start + 1;
            }
        }
        return length;
    }



    public static void main(String[] arg){
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
//        System.out.println(lengthOfLongestSubstring(s1));
//        System.out.println(lengthOfLongestSubstring(s2));
//        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring_1(s1));
        System.out.println(lengthOfLongestSubstring_1(s2));
        System.out.println(lengthOfLongestSubstring_1(s3));

    }
}
