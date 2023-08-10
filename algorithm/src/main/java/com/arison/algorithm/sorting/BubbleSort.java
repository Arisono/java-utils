package com.arison.algorithm.sorting;

import java.util.Arrays;

/**
 * 冒泡排序
 * 算法详解：https://www.runoob.com/w3cnote/bubble-sort.html
 * 冒泡排序的名字很形象，实际实现是相邻两节点进行比较，大的向后移一个，经过第一轮两两比较和移动，最大的元素移动到了最后，第二轮次大的位于倒数第二个，依次进行。这是最基本的冒泡排序，还可以进行一些优化。
 *
 * 空间复杂度：O(1)
 * 平均时间复杂度：O(n的平方)
 * 最优情况时间复杂度：O(n)
 * 最坏情况下时间复杂度：O(n的平方)
 */
public class BubbleSort {

    public static void main(String[] args) {
         int [] arr={100,55,150,56,8,456,123,45,66,77,95,114};
         System.out.println("排序前："+ Arrays.toString(arr));
         // bubbleSort(arr);
         bubbleSort2(arr);
         System.out.println("排序后："+ Arrays.toString(arr));
    }


    //冒泡排序
    public static void bubbleSort(int[] arr) {
        for(int i = 0;i < arr.length-1;i++) {
            for(int j = 0; j < arr.length-i-1;j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }


    public static void bubbleSort2(int[] arr) {
        for(int i = 0;i < arr.length-1;i++) {
            boolean flag = true; // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            for(int j = 0; j < arr.length-i-1;j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag=false;
                }
            }
            if (flag) {
                break;
            }
        }
    }


}
