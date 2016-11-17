package com.marin;

public class BsearchRecursive extends Bsearch {

    public int bsearch(int[] array, int target) {
        return bsearch(array, target, 0, array.length - 1);
    }

    private int bsearch(int[] array, int target, int beg, int end) {

        if (beg > end) {
            return -1;
        } else {
            int mid = (end - beg) / 2 + beg;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                return bsearch(array, target, beg, mid - 1);
            } else {
                return bsearch(array, target, mid + 1, end);
            }
        }

    }
}