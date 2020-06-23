public class Solution_67 {
    public String addBinary(String a, String b) {
        int[] res = new int[Math.max(a.length(), b.length())+1];

        int flag = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        for(int k = res.length - 1; k>=0; k--){

            int ii = (i>=0) ? a.charAt(i) - '0' : 0;
            int jj = (j>=0) ? b.charAt(j) - '0' : 0;

            res[k] = flag + ii + jj;
            flag = res[k] / 2;
            res[k] = res[k] % 2;

            i--;
            j--;
        }


        StringBuffer buff = new StringBuffer();
        i = res[0] == 0 ? 1 : 0;
        while(i<res.length){
            buff.append(res[i]);
            i++;
        }

        return buff.toString();

    }
}
