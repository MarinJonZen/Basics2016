package com.marin;

public class Main {

    public static void main(String[] args) {

        Bsearch bsearch = new BsearchRecursive();

        bsearch.testBsearch();

        bsearch = new BsearchNonRecursive();
        bsearch.testBsearch();

    }


}
