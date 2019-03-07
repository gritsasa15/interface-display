package com.bba.chart.controller;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {19, 6, 12, 17, 10, 4, 0, 77, 8};
//        sort(arr, 0, arr.length - 1);
        sort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void sort(int[] a, int low, int high) {
        if(low>=high)
            return;
        int i = low;
        int j = high;
        int key = a[i];
        while (i < j) {
            while (i < j && a[j] >= key)
                j--;
            a[i++] = a[j];
            while (i < j && a[i] <= key)
                i++;
            a[j--] = a[i];
        }
        a[i] = key;
        sort(a,low,i-1);
        sort(a,i+1,high);
    }

    public static void quickSort(int[] a) {

    }


    public static int[] merge(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[low];
        while (i < j) {
            while (pivot <= arr[j] && i < j) {
                j--;
            }
            while (pivot >= arr[i] && i < j) {
                i++;
            }
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

        }
        arr[pivot] = arr[i];
        arr[i] = pivot;

        merge(arr, low, j - 1);
        merge(arr, j + 1, high);
        return arr;
    }


    // 分段，倒着交换
    private static int[] shell(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int tmp = arr[j];
                while (j - step >= 0 && tmp < arr[j - step]) {
                    arr[j] = arr[j - step];
                    j = j - step;
                }
                arr[j] = tmp;
            }

        }
        return arr;
    }

    // 从第2个开始，往前一位慢慢递推，慢慢后移，找最小的插入
    private static int[] insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
        return arr;
    }

    // 拿1开始，往后找最小的，和前面排序的换位
    private static int[] select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    // 从1和2开始，冒泡对比
    private static int[] bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
        return arr;
    }
}
