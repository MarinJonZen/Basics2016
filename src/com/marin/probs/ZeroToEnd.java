package com.marin.probs;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by jmarin on 11/19/16.
 */
public class ZeroToEnd {
    public static void main( String [] args ) {
        int [] nums = {1, 2};
        System.out.println("Nums: "+ Arrays.stream(nums).mapToObj((i) -> ((Integer)i).toString()).collect(Collectors.joining(", ")));
        move( nums );
        System.out.println("MV'd: "+Arrays.stream(nums).mapToObj((i) -> ((Integer)i).toString()).collect(Collectors.joining(", ")));
    }

    private static void move(int[] nums) {
        if( nums != null ) {
            int beg = 0;
            int end = nums.length - 1;

            while ( beg < end ) {
                if( nums[ beg ] == 0) {
                    while(( beg < end ) && (nums[end] == 0)) {
                        end -= 1;
                    }
                    //swap
                    nums[beg] = nums[end];
                    nums[end] = 0;
                    end -= 1;
                }

                beg += 1;
            }
        }
    }
}
