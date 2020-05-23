/*
常见的数组排序：冒泡排序
数组结果升序排列
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ArraySort {
    /**
     * 冒泡排序
     * 稳定排序，时间复杂度O(n^2)，空间复杂度O(1)
     * @param arr
     */
    public static void BubbleSort(int[] arr){
        for (int i = 0;i < arr.length;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]) swap(arr,j,j+1);
            }
        }
    }

    /**
     * 选择排序
     * 不稳定排序，时间复杂度O(n^2)，空间复杂度O(1)
     * 思路：
     * 从arr[0]~arr[n-1]中找到最小元素，与arr[0]交换
     * 从arr[1]~arr[n-1]中找到最小元素，与arr[1]交换
     * ...
     * @param arr
     */
    public static void SelectSort(int[] arr){
        for (int i = 0;i < arr.length;i++){
            int min = i;
            for (int j = i;j<arr.length;j++){
                if (arr[min]>arr[j]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
    }

    /**
     * 插入排序
     * 稳定排序，时间复杂度O(n^2)，空闲复杂度O(1)
     * @param arr
     */
    public static void InsertSort(int[] arr){
        if (arr.length == 1) return;
        for (int i = 1;i<arr.length;i++){
            for (int j = i;j>0;j--){
                if (arr[j]<arr[j-1]) swap(arr,j,j-1);
                else break;
            }
        }
    }

    /**
     * 快速排序
     * 不稳定排序
     * 最优情况：时间复杂度O(logn)，空间复杂度O(logn)
     * 最差情况：时间复杂度O(n^2)，空间复杂度O(n)
     * 平均情况：时间复杂度O(nlogn)，空间复杂度log(n)
     *
     * @param arr
     * @param begin
     * @param end
     */
    public static void QuickSort(int[] arr,int begin,int end){
        if (begin>=end){
            return;
        }
        int index = partition(arr,begin,end);
        QuickSort(arr,begin,index-1);
        QuickSort(arr,index+1,end);
    }

    /**
     * arr[begin]=pilot
     *
     * @param arr
     * @param begin
     * @param end
     * @return 返回数组索引index,有arr[0]~arr[index]所有元素<=pilot,arr[index+1]~arr[end]>pilot
     */

    private static int partition(int[] arr,int begin,int end){
        int pivot = arr[begin];
        int L = begin;
        int R = end;
        while (L<R){
            while (L<R && arr[R]>pivot) R--;
            while (L<R && arr[L]<=pivot) L++;
            if (L<R) swap(arr,L,R);
        }

        arr[begin] = arr[L];
        arr[L] = pivot;
        return L;
    }

    public static void MergeSort(int[] nums,int L,int R){
        if (L>=R) return;

        int mid = L + (R-L>>1);
        MergeSort(nums,L,mid);
        MergeSort(nums,mid+1,R);
        Merge(nums,L,mid,R);

    }

    /**
     * [L,mid]有序，[mid+1,R]有序，实现[L,R]有序
     * @param nums
     * @param L
     * @param mid
     * @param R
     */
    private static void Merge(int[] nums,int L,int mid,int R){
        int[] temp = new int[R-L+1];
        int p = L;
        int q = mid + 1;
//        temp数组的索引
        int i = 0;
        while (p<=mid && q<=R){

//            temp[i++] = nums[p]<=nums[q] ? nums[p++]:nums[q++];
            if (nums[p]<=nums[q]){
                temp[i] = nums[p];
                i++;
                p++;
            }else {
                temp[i] = nums[q];
                i++;
                q++;
            }
        }
        while (p<=mid){
            temp[i] = nums[p];
            p++;
            i++;
        }

        while (q<=R){
            temp[i++] = nums[q++];
        }

        for (int j=0;j<temp.length;j++){
            nums[L+j] = temp[j];
        }
    }


//    堆排序

    public static void heapsort(int[] arr){
        if (arr == null || arr.length <= 1) return;

//        将数组建立成大根堆
        for (int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }

        int size = arr.length;
        swap(arr,0,--size);
        while (size>0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }
    }


    /**
     * 将当前节点元素插入堆中并向上调整
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr,int index){
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    /**
     * headsize代表堆的大小，即：
     * 数组在0~heapsize-1范围内形成堆结构
     *
     * 由于index位置的元素发生变化，需要对堆重新进行调整
     * @param arr
     * @param index
     * @param heapsize
     */
    private static void heapify(int[] arr,int index,int heapsize){
        int left = 2*index+1;
        while (left<heapsize){

//            寻找左右孩子的最大索引
            int largest = (left+1<heapsize) && (arr[left+1]>arr[left]) ? left+1 : left;

//            最大的和当前节点比较
            largest = arr[index] >= arr[largest] ? index : largest;

            if(index == largest) break;

            swap(arr,largest,index);
            index = largest;
            left = 2*index+1;
        }


    }







    /**
     * i，j位置数组元素交换
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {4,3,2,1};
        QuickSort(arr1,0,arr1.length-1);
    }

}
