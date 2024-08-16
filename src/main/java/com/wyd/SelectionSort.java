package com.wyd;

public class SelectionSort {
    private SelectionSort(){}

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j ++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);

        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int t = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = t;

    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,3,6,5};
        SelectionSort.sort(arr);
        for(int e : arr) {
            System.out.print(e+ " ");
        }
    }
}
