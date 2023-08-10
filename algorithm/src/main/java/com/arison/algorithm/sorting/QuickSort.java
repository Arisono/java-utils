package com.arison.algorithm.sorting;

import java.util.Arrays;

/**
 * 快速排序
 *
 * 资料参考：https://juejin.cn/post/7056416599003136014
 *
 * 性能：
 * 不稳定
 * 快速排序是不稳定的。快速排序在最优的情况下，时间复杂度为O( nlogn )，最差情况下为O( n^2 )，平均为O( nlogn )
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] arr={100,55,150,56,114,8,456,123,45,66,77,95,114};
        System.out.println("排序前："+ Arrays.toString(arr));
        //快速排序实现的两种方式
        int [] arrSort= quickSort(arr);//挖坑法
               arrSort= sort(arr);//前后指针法
        System.out.println("排序后："+ Arrays.toString(arrSort));
    }


    /**
     * 快速排序——前后指针法
     * @param sourceArray
     * @return
     */
    public static int[] sort(int[] sourceArray){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 前后指针法
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            System.out.println("-------------left:"+(partitionIndex + 1)+" right:"+right);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private  static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        System.out.println("   基准索引："+pivot+" 基准值："+arr[left]);
        int pre = pivot + 1;
        //pre 为前指针，cur为后指针。
        for (int cur = pre; cur <= right; cur++) {
            if (arr[cur] < arr[pivot]) {
                if(cur!=pre){
                    swap(arr, cur, pre);
                }
                pre++;
            }
        }
        swap(arr, pivot, pre - 1);
        System.out.println("   排序中："+Arrays.toString(arr)+"  pre:"+(pre-1) +" left:"+left+" right:"+right);
        return pre - 1;
    }

    /**
     *
     * 交换位置
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 快速排序——挖坑法
     * @param array
     */
    public static int[] quickSort(int[] array) {
      return  quick(array,0,array.length-1);
    }
    public static int [] quick(int[] array,int left,int right) {
        if(left < right) {
            int index = partition2(array,left,right);
            quick(array,left,index-1);
            quick(array,index+1,right);
        }
        return array;
    }
    public static int partition2(int[] array,int low,int high) {
        int tmp = array[low];
        while(low < high) {
            while(low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while(low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];

        }

        array[low] = tmp;
        return low;
    }

}
