package com.marin.probs;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by jmarin on 11/22/16.
 */
public class PalinProto {
    private static char [] symbols;

    private static int BUF_SIZE = 200000;
    private static char CHAR_MIN = 'a';
    private static char CHAR_MAX = 'b';


    static {

        StringBuffer sb = new StringBuffer();
        for( char ch = CHAR_MIN; ch <= CHAR_MAX ; ch += 1 ) {
            sb.append( ch );
        }
        symbols = sb.toString().toCharArray();
    }


    protected static String genpalin() {
        char [] buf = new char[BUF_SIZE*2];

        buf[0] = buf[ BUF_SIZE*2-1 ] = symbols[symbols.length - 1];
        for( int i = 1 ; i < BUF_SIZE; i+=1 ) {
            char ch = 'a';
            ch += ThreadLocalRandom.current().nextInt(symbols.length-1);

            buf[i] = buf[(BUF_SIZE*2-1)-i] = ch;
        }
        return new String(buf);
    }

    public static void main(String [] args ) {

        String p = genpalin();
        System.out.println("Ready");
        System.out.println(String.format("Original: %s..", p.substring(0,10)));
        System.out.println(String.format("Palin:    %s..", palin(p).substring(0,10)));

    }

    protected static String palin(String genpalin) {

        StringReader reader = new StringReader( genpalin );
        StringBuffer sb = new StringBuffer();
        String ret = null;

        int mid = 0;
        while( true ) {

            int beg, end;
            for( beg = mid, end = mid+1; beg >= 0; beg -= 1, end += 1) {

                ensureChars( sb, end+1, reader );
                if( sb.charAt(beg) != sb.charAt(end) ) {
                    break;
                }
            }

            if( beg < 0 ) {
                ret = sb.substring(0, mid+1);
                break;
            } else {
                mid += 1;
            }
        }

        return ret;
    }

    protected static void ensureChars(StringBuffer sb, int nchars, StringReader reader) {
        try {
            while( nchars >= sb.length() ) {

                sb.append((char)reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
