public class Solution_69 {

    public static int mySqrt(int x){
        if (x == 0 || x==1) return x;
        int L = 0;
        int R = x;
        int mid = 0;

        while (L<=R){
            mid = L + (R-L>>1);
            if (mid <= x/mid && (mid+1)>x/(mid+1)) return mid;
            else if (mid>x/mid) R = mid -1;
            else if ((mid+1)<=x/(mid+1)) L = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(mySqrt(9));

    }
}
