public class Solution_29 {

    public static int divide(int dividend, int divisor) {
//        符号标志位 true代表负，false代表正数
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) divisor = -divisor;
        while(dividend <= divisor) {
            int result_temp = -1;
//            新被除数 = 除数 * 遍历可行的商
//            可行商从1开始，因此新被除数初始值是除数
            int divisor_temp = divisor;
            while (dividend <= (divisor_temp<<1)){
                if(divisor_temp <= (Integer.MIN_VALUE >> 1))break;
//                遍历商
                result_temp = result_temp<<1;
//                除数固定，商左移，故新被除数左移
                divisor_temp = divisor_temp <<1;
            }

            dividend = dividend - divisor_temp;
            result = result + result_temp;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;

    }




//    用除数反复和被除数相减，相减的次数是商
    public static int divide_force(int dividend, int divisor) {
        int res = 0;
        boolean negative = (dividend ^ divisor)<0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend-divisor>=0){
            res++;
            dividend = dividend-divisor;
        }
        return negative?-res:res;
    }



    public static void main(String[] args) {
        System.out.println(divide_force(5,2));
        System.out.println(divide(5,2));
    }
}
