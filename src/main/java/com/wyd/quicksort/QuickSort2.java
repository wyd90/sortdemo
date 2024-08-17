package com.wyd.quicksort;

import com.wyd.selectionsort.SelectionSort2;

import java.util.Random;

public class QuickSort2 {

    private QuickSort2(){}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1,random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r, rnd);
        sort(arr, l, p - 1, rnd);
        sort(arr, p + 1, r, rnd);

    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random rnd) {
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l + 1 ... i - 1] <= v; arr[j + 1 ... r] >= v
        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i ++;
            }

            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;

        }
        swap(arr, l, j);

        return j;
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,4,2,3,6,5};
        QuickSort2.sort(arr);
        for(int e : arr) {
            System.out.print(e+ " ");
        }
    }
}
