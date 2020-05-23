import java.util.ArrayList;

public class solution {

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0) return res;
        help(str.toCharArray(),0,res);

        return res;
    }

    private static void help(char[] arr,int index,ArrayList<String> res){

        if(index==arr.length){
            String val = String.valueOf(arr);
            if(!res.contains(val)){
                res.add(val);
            }
        }

        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            help(arr,i+1,res);
            swap(arr,i,index);
        }
    }

    private static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Permutation("abc");
    }
}
