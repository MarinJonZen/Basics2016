package com.marin;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by jmarin on 11/16/16.
 */
public abstract class Bsearch {
    public void testBsearch() {
        int[] array = new int[Integer.MAX_VALUE/1000];
        for (int i = 0; i < array.length; i += 1) {
            array[i] = i;
        }
        System.out.println(String.format("Initialized array of %d ints", array.length));

        int target = ThreadLocalRandom.current().nextInt( 0, array.length );
        System.out.println(String.format("Target=%d, Found=%d", target, bsearch(array, target)));
        confirmTarget( array, target );

        target = ThreadLocalRandom.current().nextInt( 0, array.length );
        System.out.println(String.format("Target=%d, Found=%d", target, bsearch(array, target)));
        confirmTarget( array, target );

        testExhaustive(array);
    }

    private void testExhaustive(int[] array) {
        for(int i = 0 ; i < array.length ; i+=1 ) {
            if( bsearch( array, i ) == -1 ) {
                System.out.println(String.format("Failed to find %d", i));
                break;
            }
        }
    }

    private void confirmTarget(int[] array, int target) {
        System.out.println(array[target]);
    }

    public abstract int bsearch(int[] array, int target);

}
