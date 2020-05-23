package daily;

public class daily_11 {

//    暴力法：时间复杂度O(N^2)，空间复杂度O(1)
    public static boolean canThreePartsEqualSum(int[] A) {

        int sum = 0;
        for(int k=0;k<A.length;k++){
            sum = sum + A[k];
        }

        for(int i=0;i<=A.length-3;i++){
            for(int j=i+1;j<=A.length-2;j++){

                int left = 0;
                for(int k=0;k<=i;k++){
                    left = left+A[k];
                }
                int middle = 0;
                for(int k=i+1;k<=j;k++){
                    middle = middle + A[k];
                }
                if(left == middle && middle == sum-left-middle){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canThreePartsEqualSum1(int[] A) {
        int sum = 0;
        for(int k=0;k<A.length;k++){
            sum = sum + A[k];
        }

        if (sum % 3 != 0) return false;
        int count = 0;
        int temp = 0;
        for (int i=0;i<A.length;i++){
            temp = temp+A[i];
            if (temp == sum/3){
                count++;
                temp = 0;
            }
        }
//        特殊情况：[-10,10,-10,10,-10,10,-10,10]
        if (count >= 3) return true;
        return false;


    }
    public static void main(String[] args) {
        canThreePartsEqualSum(new int[]{18,12,-18,18,-19,-1,10,10});
    }
}
