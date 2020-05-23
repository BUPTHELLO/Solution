public class Solution_744 {

    public char nextGreatestLetter(char[] letters, char target) {

        int L = 0;
        int R = letters.length;

        while (L<R){
            int mid = L + (R-L>>1);
            if (letters[mid] == target) L = mid + 1;
            else if(letters[mid]<target) L = mid + 1;
            else if (letters[mid]>target) R = mid;
        }


        if (L == letters.length) return letters[0];
        return letters[L];


    }
    public static void main(String[] args) {

    }
}
