package com.marin.probs;

/**
 * Created by jmarin on 11/30/16.
 */
public class NextTreeNode {
    public static class Node {
        private Node parent;
        private Node left;
        private Node right;
        private char val;
        public Node(char v) { this.val = v;}
    }

    public static void main( String [] args ) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');

        a.left = b;
        b.parent = a;

        a.right = c;
        c.parent = a;

        b.right = d;
        d.parent = b;

        c.left = e;
        e.parent = c;


        Node next = b;
        while( next != null ) {
            System.out.println(String.format("==> %c", next.val));
            next = nextNode( next );
        }


    }

    private static Node nextNode(Node loc) {
        if( loc == null || ( loc.parent == null && loc.right == null ) ) {
            return null;
        } else if( loc.right != null ) {
            return leftmost( loc.right );
        } else {
            return rightmost( loc );
        }
    }

    private static Node leftmost(Node loc) {
        while( loc.left != null ) {
            loc = loc.left;
        }

        return loc;
    }

    private static Node rightmost( Node loc ) {
        while( loc.parent != null && (loc.parent.right == loc )) {
            loc = loc.parent;
        }

        return loc.parent;
    }


}
