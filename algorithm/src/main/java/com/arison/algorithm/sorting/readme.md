

排序的稳定性和复杂度

      不稳定：

      选择排序（selection sort）— O(n2)

      快速排序（quicksort）— O(nlogn) 平均时间, O(n2) 最坏情况; 对于大的、乱序串列一般认为是最快的已知排序

      堆排序 （heapsort）— O(nlogn)

      希尔排序 （shell sort）— O(nlogn)

      基数排序（radix sort）— O(n·k); 需要 O(n) 额外存储空间 （K为特征个数）

 

      稳定：

      插入排序（insertion sort）— O(n2)

      冒泡排序（bubble sort） — O(n2)

      归并排序 （merge sort）— O(n log n); 需要 O(n) 额外存储空间

      二叉树排序（Binary tree sort） — O(nlogn); 需要 O(n) 额外存储空间

      计数排序  (counting sort) — O(n+k); 需要 O(n+k) 额外存储空间，k为序列中Max-Min+1

      桶排序 （bucket sort）— O(n); 需要 O(k) 额外存储空间


 ![](https://img-blog.csdn.net/20170330103501800?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveGh5eHh4/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)