public class Solution_28 {
    public static int strStr(String haystack, String needle) {
        if (haystack.length()<needle.length()) return -1;
        if (haystack.equals(needle)) return 0;
        int index = 0;
        while (index+needle.length()-1 < haystack.length()){
            if (haystack.substring(index,index+needle.length()).equals(needle)) return index;
            index ++;
        }
        return -1;

    };

    public static int forceStr(String haystack, String needle){
        if (haystack.length()<needle.length()) return -1;
        if (haystack.equals(needle)) return 0;

        for (int i = 0;i+needle.length()<=haystack.length();i++){
            int j;
            for (j=0;j<needle.length();j++){
                if (haystack.charAt(i+j)!= needle.charAt(j)) {
                    break;
                }
            }
            if (j==needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "is";
        System.out.println(strStr(s1,s2));
        System.out.println(forceStr(s1,s2));


    }
}
