public class Solution_8 {
    public static int myAtoi(String str) {
        int temp = 1;
        int res = 0;
        int pop;
        for (int i = 0; i<str.length();i++){
            if (str.charAt(i)==' ') continue;
            if (str.charAt(i) == '-') {
                temp = -1;
                continue;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <='9'){
                pop = (int)(str.charAt(i)-'0');
                if ((res > Integer.MAX_VALUE/10) && temp == 1) return Integer.MAX_VALUE;
                if ((res > Integer.MAX_VALUE/10) && temp == -1) return Integer.MIN_VALUE;

                res = res * 10 + pop;
            }else break;
        }
        return temp*res;

    }
    public static void main(String[] arg){
        String s = "   -42";
        System.out.println(myAtoi(s));

    }
}
