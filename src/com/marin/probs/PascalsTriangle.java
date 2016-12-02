package com.marin.probs;

/**
 * Created by jmarin on 11/30/16.
 */
public class PascalsTriangle {

    public static void main( String[] args) {
        pascal( 6 );
    }

    private static void pascal(int n) {
        if( n <= 0 ) {
            throw new IllegalArgumentException();
        }

        int[][] tri = new int[n][n];
        for( int r = 0; r < n; r += 1 ) {
            for( int c = 0; c <= r; c += 1 ) {
                if( c == 0 || c == r ) {
                    tri[r][c] = 1;
                } else {
                    tri[r][c] = tri[r-1][c-1] + tri[r-1][c];
                }
                System.out.print(tri[r][c] + " ");
            }
            System.out.println();
        }
    }
}
