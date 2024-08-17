package com.wyd.quicksort;

import java.util.Random;

public class QuickSort {
    private QuickSort(){}

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
        // arr[l+1...j] < v; arr[j+1...i] >= v

        int p = l + rnd.nextInt(r - l + 1);

        swap(arr, l , p);

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j ++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
