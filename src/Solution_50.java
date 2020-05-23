public class Solution_50 {

    public static double myPow(double x, int n) {
        if (n == 0) { return 1; }
        if (n == 1) { return x; }
        if (n == -1) { return 1 / x; }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return rest * half * half;
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) return true;
        if (num == 3) return false;

        long L = 1;
        long R = num/2;

        while(L<=R){
            long mid = L + (R-L>>1);

            if(mid*mid==num) return true;
            else if(mid*mid>num) R=mid-1;
            else if(mid*mid<num) L=mid+1;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
}
