//实现前缀树,leetcode 208

import java.util.ArrayList;
import java.util.List;

public class Trie {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> res = new ArrayList<>();

        MergeSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            res.add(nums[i]);
        }

        return res;
    }

    public void MergeSort(int[] nums, int L, int R){
        if(L >= R) return;

        int mid = (L+R)/2;
        MergeSort(nums,L,mid);
        MergeSort(nums,mid+1,R);
        Merge(nums,L,mid,R);
    }

    public void Merge(int[] nums, int L,int mid,int R){
        int[] temp = new int[R-L+1];

        int i = L;
        int j = mid +1;
        int k = 0;

        while(i<=mid && j<=R){
            if(nums[i]<=nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i<=mid){
            temp[k++] = nums[i++];
        }

        while(j<=R){
            temp[k++] = nums[j++];
        }

        for(int ii=0;ii<temp.length;ii++){
            nums[ii+L] = temp[ii];
        }
    }

    public static void main(String[] args) {
        Trie a = new Trie();
        a.sortArray(new int[]{5,2,3,1});
    }
}
