package com.arison.algorithm.sorting;

import java.util.Arrays;

/**
 * 插入排序
 * 整个区间分为有序区间和无序区间，每次拿到无序区间的第一个数去有序区间里找对应的位置。
 *
 * 改进：直接插入排序下的折半查找
 *
 * 稳定性:稳定
 * 空间复杂度：O(1)
 * 平均时间复杂度：O(n的平方)
 * 最优情况时间复杂度：O(n)
 * 最坏情况下时间复杂度：O(n的平方)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int [] arr={100,55,150,56,114,8,456,123,45,66,77,95,114};
        System.out.println("排序前："+ Arrays.toString(arr));
        int [] arrSort= sort(arr);
        System.out.println("排序后："+ Arrays.toString(arrSort));
    }


    public static  int[] sort(int[] sourceArray)  {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
              int j=i;
              int temp=arr[j];//记录需要插入的数据。

              //然后拿这个需要插入的值，依次和左边已经排序的数据比较，然后插入到合适的位置
              while (j>0&&temp<arr[j-1]){
                  arr[j]=arr[j-1];
                  j--;
              }

              if(i!=j){
                  arr[j]= temp;
              }
        }

        return arr;
    }
}
