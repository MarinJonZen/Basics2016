package com.marin.probs;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**t
 * Created by jmarin on 11/17/16.
 */
public class PalinProtoLookahead extends PalinProto {


    public static void main(String [] args ) {

        String p = genpalin();
        System.out.println("Ready");
        System.out.println(String.format("Original: %s..", p.substring(0,10)));
        System.out.println(String.format("Palin:    %s..", palin(p).substring(0,10)));

    }

    protected static String palin(String genpalin) {
        System.out.println("PalinProtoLookahead");

        StringReader reader = new StringReader( genpalin );
        StringBuffer sb = new StringBuffer();
        String ret = null;

        HashMap<Character, Integer> stackMap = new HashMap<>();
        int mid = 0;
        while( true ) {

            HashMap<Character, Integer> queueMap = new HashMap<>( stackMap );
            int increment = 1;
            int beg, end;
            for( beg = mid, end = mid+1; beg >= 0; beg -= 1, end += 1) {

                ensureChars( sb, end+1, reader );
                PalinProtoLookahead.removeChars( queueMap, sb.charAt(end) );
                if( sb.charAt(beg) != sb.charAt(end) ) {
                    break;
                }
            }

            if( beg < 0 ) {
                ret = sb.substring(0, mid+1);
                break;
            } else {
                while( queueMap.size() > 0 ) {
                    end += 1;
                    ensureChars( sb, end, reader );
                    PalinProtoLookahead.removeChars( queueMap, sb.charAt(end));
                }

                increment = Math.max((end/2) -mid, 1);
                if( increment <= 0 ) {
                    throw new IllegalStateException();
                } else if ( increment > 1 ) {
                    System.out.print(increment + " ");
                }

                for( int i = mid; i < mid+increment; i += 1) {
                    PalinProtoLookahead.addChars(stackMap, sb.charAt(i));
                }
                mid += increment;
            }
        }

        return ret;
    }


    private static void addChars(HashMap<Character, Integer> charMap, char k) {
        if( charMap.containsKey( k )) {
            charMap.put( k, charMap.get( k ) + 1);
        } else {
            charMap.put( k, 1 );
        }
    }

    private static void removeChars(HashMap<Character, Integer> charMap, char k) {
        if(  charMap.containsKey( k )) {
            int val = charMap.get( k );
            if( val == 1 ) {
                charMap.remove( k );
            } else {
                charMap.put( k , val - 1 );
            }
        }
    }

}
