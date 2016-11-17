package com.marin;

/**
 * Created by jmarin on 11/16/16.
 */
public class BsearchNonRecursive extends Bsearch {
    @Override
    public int bsearch(int[] array, int target) {


        int beg = 0;
        int end = array.length - 1;
        int ret = -1;
        while( beg <= end ) {
            int mid = beg + (end-beg)/2;
            if( array[mid] == target ) {
                return mid;
            } else if( array[mid] > target ) {
                end = mid-1;
            } else {
                beg = mid+1;
            }
        }
        return ret;
    }
}
