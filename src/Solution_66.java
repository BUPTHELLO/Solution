public class Solution_66 {
    public static int[] plusOne(int[] digits) {
        //进位标识符
        boolean flag = true;
        for (int i=digits.length-1;i>=0;i--){
            if (flag){
                digits[i] = digits[i]+1;
                if (digits[i]==10){
                    digits[i] = 0;
                    flag = true;
                }else if (digits[i]<10) flag = false;
            }
        }
        if(flag){
            digits = new int[digits.length+1];
            digits[0] = 1;
        };
        return digits;
    }
    public static void main(String[] args) {
        int[]arr = new int[]{9,9};
        arr=plusOne(arr);


    }
}
