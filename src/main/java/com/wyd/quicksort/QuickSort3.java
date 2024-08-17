package com.wyd.quicksort;

import java.util.Random;

public class QuickSort3 {
    private QuickSort3(){}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1,random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd) {
        if (l >= r) {
            return;
        }

        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l + 1, lt] < v , arr[lt + 1, i - 1] == v, arr[gt, r] > v
        int lt = l;
        int gt = r + 1;
        int i= l + 1;

        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt ++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt --;
                swap(arr, i, gt);
            } else {
                i ++;
            }
        }

        swap(arr, l, lt);

        sort(arr, l, lt - 1, rnd);
        sort(arr, gt, r, rnd);

    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,4,2,3,6,5};
        QuickSort3.sort(arr);
        for(int e : arr) {
            System.out.print(e+ " ");
        }
    }

}
