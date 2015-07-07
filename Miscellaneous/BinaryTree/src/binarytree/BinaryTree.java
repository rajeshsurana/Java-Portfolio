/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author Rajesh
 */
public class BinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    //Root node pointer. Will be null for any empty tree.
    private Node root;
    
    /**
    Node class
    Binary tree is built using this nested Node class.
    Each node has one data element, and has left and right 
    sub-tree pointers which may be null. 
    */
    
    private static class Node{
        Node left;
        Node right;
        int data;
        
        Node(int newData){
            left = null;
            right = null;
            data = newData;
        }        
    }
    
    /**
    Creates an empty binary tree. A null root pointer.
    */    
    public void BinaryTree(){
        root = null;
    } 
    
    /*
    Returns true if given given target is in the binary tree.
    Uses a Recursive helper.
    */
    public boolean lookup(int data){
        return (lookup(root, data));
    }
    
    /**
    Recursive lookup. Given a code recur down searching for
    given data.
    */
    private boolean lookup(Node node, int data ){
        if(node == null){
            return false;
        }
        if(node.data == data){
            return true;
        }else if(data < node.data){
            return lookup(node.left, data);
        }else {
            return lookup(node.right, data);
        }
    }
    
    /*
    Insert given data into binary tree.
    Uses a recursive helper.
    */
    public void insert(int data){
        root = insert(root, data);
    }
    
    /**
    Recursive helper- given a node pointer, recur down
    and insert a given data into the tree. Returns the new node pointer.
    */
    private Node insert(Node node, int data){
        if(node == null){
            node = new Node(data);
        }else if(data <= node.data) {
            node.left = insert(node.left, data);
        }else {
            node.right = insert(node.right, data);
        }
        return node; // in any case return new pointer to the caller 
    }
    
    /** 
    Returns the number of nodes in the tree. 
    Uses a recursive helper that recurs 
    down the tree and counts the nodes. 
   */ 
    public int size(){
        return size(root);
    }
    
    private int size(Node node){
        if(node == null){
            return 0;
        }else{
            return (size(node.left) + 1 + size(node.right));
        }
    }
    
    /** 
    Returns the max root-to-leaf depth of the tree. 
    Uses a recursive helper that recurs down to find 
    the max depth. 
   */ 
    public int maxDepth(){
        return maxDepth(root);
    } 
    
    private int maxDepth(Node node){
        if(node == null){
            return 0;
        }else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            // return 1 + larger of both
            return (Math.max(lDepth, rDepth) + 1);
        }
    }
    
    /** 
    Returns the min value in a non-empty binary search tree. 
    Uses a helper method that iterates to the left to find 
    the min value. 
   */ 
    public int minValue(){
        return minValue(root);
    }
    
    private int minValue(Node node){
        if(node.left == null){
            return node.data;
        }else{
            return minValue(node.left);
        }
    }
    
    /** 
    Returns the max value in a non-empty binary search tree. 
    Uses a helper method that iterates to the right to find 
    the max value. 
   */ 
    public int maxValue(){
        return maxValue(root);
    }
    
    private int maxValue(Node node){
        if(node.right == null){
            return node.data;
        }else{
            return maxValue(node.right);
        }
    }
    
    /** 
    Prints the node values in the "inorder" order. 
    Uses a recursive helper to do the traversal. 
   */
    public void printTree(){
        printTree(root);
    }
    
    private void printTree(Node node){
        if (node == null) return;
        else {
            printTree(node.left);
            System.out.println(node.data + " ");
            printTree(node.right);
        }
    }
    
    /** 
    Given a tree and a sum, returns true if there is a path from the root 
    down to a leaf, such that adding up all the values along the path 
    equals the given sum.
    Strategy: subtract the node value from the sum when recurring down, 
    and check to see if the sum is 0 when you run out of tree. 
   */ 
    public boolean hasPathSum(int sum){
        return hasPathSum(root, sum);
    }
    
    private boolean hasPathSum(Node node, int sum){
        if(node == null) return (sum == 0);
        else {
            int subSum = sum - node.data;
            return (hasPathSum(node, subSum) || hasPathSum(node, subSum));
        }
    }
    
    /** 
    Changes the tree into its mirror image. 
    */
    public void mirror(){
        mirror(root);
    }
    private void mirror(Node node){
        if(node != null){
            mirror(node.left);
            mirror(node.right);
            
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
    
    /** 
    Changes the tree by inserting a duplicate node 
    on each nodes' .left. 
    */
    public void doubleTree(){
        doubleTree(root);
    }
    private void doubleTree(Node node){
        if(node == null) return;
        doubleTree(node.left);
        doubleTree(node.right);
        
        Node oldLeft;
        oldLeft = node.left;
        node.left = new Node(node.data);
        node.left.left = oldLeft;
    }
    
    /** 
    Compares the receiver to another tree to 
    see if they are structurally identical. 
   */ 
    public boolean sameTree(BinaryTree other){
        return sameTree(root, other.root);
    }
    private boolean sameTree(Node a, Node b){
        if(a == null && b == null) return true;
        if(a != null && b != null){
            return (a.data == b.data &&
                    sameTree(a.left, b.left) &&
                    sameTree(a.right, b.right));
        }
        return false;
    }
    
    /** 
    Tests if a tree meets the conditions to be a 
    binary search tree (BST). 
   */ 
    public boolean isBST(){
        return isBST(root);
    }
    private boolean isBST(Node node){
        if(node == null) return true;
        if(node.left != null && maxValue(node.left) > node.data) return false;
        if(node.right != null && minValue(node.right) <= node.data) return false;
            return (isBST(node.left) && isBST(node.right));
    }
}
