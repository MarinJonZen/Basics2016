package com.marin;

import java.util.HashMap;

/**
 * Created by jmarin on 11/18/16.
 */
public class HashMapTest {

    public static void main( String [] args ) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for( char ch = 'a'; ch <= 'z'; ch += 1 ) {
            hm.put(ch, 1);
        }
        System.out.println("HashMap has: "+hm.size());
        for( char ch = 'a'; ch <= 'z'; ch += 1 ) {
            hm.remove(ch);
        }
        System.out.println("HashMap has: "+hm.size());
    }
}
