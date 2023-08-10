package com.arison.algorithm.sorting;

import java.util.Arrays;

/**
 * 希尔排序
 * 资料参考：https://juejin.cn/post/6973862597737054244
 * 希尔排序就是按照一定的gap值，不断地对数组进行插入排序。不一样的希尔排序算法可能采用不一样的gap值。经典希尔算法的gap值为N/2, N/4, ...... 直到gap值为1，这里的N为数组的长度。
 *
 * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位；
 * 希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
 *
 * 性能：
 * 不稳定
 *
 *
 *
 */
public class HillSort {
    public static void main(String[] args) {
        int [] arr={100,55,150,56,114,8,456,123,45,66,77,95,114};
        System.out.println("排序前："+ Arrays.toString(arr));
        int [] arrSort= sort(arr);
        System.out.println("排序后："+ Arrays.toString(arrSort));
    }


    public static int[] sort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }

        return arr;
    }
}
