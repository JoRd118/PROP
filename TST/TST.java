import java.util.*;
import java.io.IOException;
/*
 *Class TST
 *
 *Implementation of Ternary Search Tree structure,
 *base on Robert Sedgewick and Kevin Wayne's TST implementation.
 *@author Claudi
 */

public class TST<Value> {
    private int N;       // size
    private Node root;   // root of TST
    
    private String msg_TST_repetit = "Error TST: Aquest 'Valor' ja existeix a l'estructura.";
    private String msg_TST_void_argument = "Error TST: Argument ha de tenir length > 0.";
    
    //Inserts
    public void insert(String s, Value v){
        if(contains(s)){throw new IllegalArgumentException(msg_TST_repetit);}
        else{
            root = put(root, s, v,0);
        }
    }
    
    public void remove(String s){
        if (s == null) throw new NullPointerException();
        if (s.length() == 0) throw new IllegalArgumentException(msg_TST_void_argument);
        put(root, s, null, 0);
        
    
    }
    
    //Obtain
    public Value obtain(String s){
        if (s == null) throw new NullPointerException();
        if (s.length() == 0) throw new IllegalArgumentException(msg_TST_void_argument);
        Node x = get(root, s,  0);
        if (x == null) return null;
        return x.val;
    }
    
    //Check
    public boolean contains(String s){
        return obtain(s) != null;
    }
    
    //Lists
    public Iterable<String> obtainAllTST(){
        LinkedList<String> q = new LinkedList<String>();
        collectTST(root, "", q);
        return q;
    }
    
    public Iterable<String> obtainPatternTST(String pat) {
        LinkedList<String> q = new LinkedList<String>();
        collectTST(root, "", 0, pat, q);
        return q;
    }
    
    
    //Class Node
    private class Node {
        private char c;                 // character
        private Node left, mid, right;  // left, middle, and right subtries
        private Value val;              // value associated with string
    }
    
    //Private methods
    private Node put(Node x, String s, Value val, int d) {
        char c = s.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if      (c < x.c)             x.left  = put(x.left,  s, val, d);
        else if (c > x.c)             x.right = put(x.right, s, val, d);
        else if (d < s.length() - 1)  x.mid   = put(x.mid,   s, val, d+1);
        else                          x.val   = val;
        return x;
    }
    
    private Node get(Node x, String key, int d) {
        if (key == null) throw new NullPointerException();
        if (key.length() == 0) throw new IllegalArgumentException(msg_TST_void_argument);
        if (x == null) return null;
        char c = key.charAt(d);
        if      (c < x.c)              return get(x.left,  key, d);
        else if (c > x.c)              return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid,   key, d+1);
        else                           return x;
    }
    
    private void collectTST(Node x, String prefix, Queue<String> queue) {
        if (x == null) return;
        collectTST(x.left,  prefix,       queue);
        if (x.val != null) queue.add(prefix + x.c);
        collectTST(x.mid,   prefix + x.c, queue);
        collectTST(x.right, prefix,       queue);
    }

    private void collectTST(Node x, String prefix, int i, String pat, Queue<String> q) {
        if (x == null) return;
        char c = pat.charAt(i);
        if (c == '.' || c < x.c) collectTST(x.left, prefix, i, pat, q);
        if (c == '.' || c == x.c) {
            if (i == pat.length() - 1 && x.val != null) q.add(prefix + x.c);
            if (i < pat.length() - 1) collectTST(x.mid, prefix + x.c, i+1, pat, q);
        }
        if (c == '.' || c > x.c) collectTST(x.right, prefix, i, pat, q);
    }
    
}