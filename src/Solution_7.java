public class Solution_7 {

//    数字反转：
//    pop
//    pop = x%10

//    reverse（注意结果溢出的问题）
//    res = res * 10 +pop;
//    x=x/10;
//
    public static int reverse(int x) {
        int res = 0;
        int pop = 0;
        while(x != 0){
            pop = x%10;
            if((res > Integer.MAX_VALUE/10)||((res == Integer.MAX_VALUE/10)&&(pop>7))){
                return 0;
            }
            if((res < Integer.MIN_VALUE/10)||((res == Integer.MIN_VALUE/10)&&(pop<-8))){
                return 0;
            }
            res = res * 10 + pop;
            x = x/10;
        }
    return res;
    }

    public static void main(String[] arg) {

    }
}
