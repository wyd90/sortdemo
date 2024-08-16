package com.wyd;

public class SelectionSort2 {
    private SelectionSort2(){}

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j ++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);

        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int minIndex) {
        E t = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,4,2,3,6,5};
        SelectionSort2.sort(arr);
        for(int e : arr) {
            System.out.print(e+ " ");
        }
    }
}
