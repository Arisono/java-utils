package com.arison.algorithm.sorting;

import java.util.Arrays;

/**
 * 归并排序
 * 参考资料：https://www.cnblogs.com/chengxiao/p/6194356.html
 *
 * 最差复杂性： n*log(n)
 * 平均复杂性： n*log(n)
 * 最优复杂性： n*log(n)
 * 空间复杂性： n
 * 方法： Merging
 * 稳定： Yes
 */
public class MergeSort {
    public static void main(String[] args) {
        int [] arr={100,55,150,56,114,8,456,123,45,66,77,95,114};
        System.out.println("排序前："+ Arrays.toString(arr));
        int [] arrSort= sort(arr);
        System.out.println("排序后："+ Arrays.toString(arrSort));
    }

    public static int[] sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
        return arr;
    }
    private static int[] sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }

        return arr;
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
