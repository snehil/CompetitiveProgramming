package com.programming.datastructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A generic Binary Search Tree implementation
 * Reference: http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 * 
 * @author Snehil
 */
public class BST<T extends Comparable<T>> {
    
    private Node root;
    
    /**
     * Represents a node in the BST
     */
    public class Node<T extends Comparable<T>> {
        public T    data;
        public Node left;
        public Node right;
        
        /**
         * Constructor for type {Node} 
         * 
         * @param item The data to be added to the {BST} Node
         */
        Node(T item) {
            data = item;
            left = right = null;
        }       
    }
    
    /**
     * Inserts the given data into the {BST}
     * Time Complexity = O(n)
     * 
     * @param data Data to be inserted in the {BST}
     */
    public void insert(T data) {
        if (data == null) return;

        root = insertUtil(data, root);
    }
    
    /**
     * Utility function to insert data into the {BST}
     * 
     * @param data Data to be inserted into the {BST}
     * @param node {BST} {Node} into which data is to be inserted 
     * @return A {BST} {Node} into which data has been inserted
     */
    @SuppressWarnings("unchecked")
    private Node insertUtil(T data, Node node) {        
        if (node == null) {
            node = new Node(data);
            return node;
        }
        
        if (data.compareTo((T) node.data) < 0) {
            node.left = insertUtil(data, node.left);
        } else if (data.compareTo((T) node.data) > 0) {
            node.right = insertUtil(data, node.right);
        } 
        
        return node;
    }
    
    /**
     * Searched the given data in the {BST}
     * Time Complexity = O(n)
     * 
     * @param data The data/key to be searched in the {BST}
     * 
     * @return A {BST} {Node} if key exists, null otherwise
     */
    public void search(T data) {
        if (data      == null) return;
        if (root.data == null) return; 
        
        System.out.println("Searching BST for key: " + data.toString());
        Node node = searchUtil(data, root);
        
        if (node != null) {
            System.out.println("Search Result: " + node.data);
        } else {
            System.out.println(String.format("Key '%s' not found in the BST", data.toString()));
        }
    }
    
    private Node searchUtil(T data, Node node) {
        
        if (node == null || node.data.equals(data)) {
            return node;
        }
        
        if (data.compareTo((T) node.data) < 0) { // search in left sub-tree
            return searchUtil(data, node.left);
        } else {                                 // search in right sub-tree
            return searchUtil(data, node.right);
        }
    }
    
    /**
     * Pre-Order traversal implementation for the {BST}
     * Time Complexity = O(n)
     */
    public void preOrderTraversal() {
        System.out.println("Pre-Order Traversal:");
        PreOrderTraversalUtil(root);
    }
    
    /**
     * Utility functional for Pre-Order Traversal for the {BST}
     * 
     * @param node {Node} from which to being traversing the {BST}
     */
     private void PreOrderTraversalUtil(Node node) {
        if (node == null) return;
        
        System.out.println("Node: " + node.data.toString());
        PreOrderTraversalUtil(node.left);
        PreOrderTraversalUtil(node.right);
    }

    /**
     * Post-Order traversal implementation for the {BST}
     * Time Complexity = O(n)
     */
    public void postOrderTraversal() {
        System.out.println("Post-Order Traversal:");
        postOrderTraversalUtil(root);
    }

    /**
     * Utility functional for Post-Order Traversal for the {BST}
     * 
     * @param node {Node} from which to being traversing the {BST}
     */
    private void postOrderTraversalUtil(Node node) {
        if (node == null) return;
        
        PreOrderTraversalUtil(node.left);
        PreOrderTraversalUtil(node.right);
        System.out.println("Node: " + node.data.toString());
    }
 
    /**
     * In-Order traversal implementation for the {BST}
     * Time Complexity = O(n)
     */
    public void inOrderTraversal() {
        System.out.println("In-Order Traversal:");
        inOrderTraversalUtil(root);
    }

    /**
     * Utility functional for In-Order Traversal for the {BST}
     * 
     * @param node {Node} from which to being traversing the {BST}
     */
    private void inOrderTraversalUtil(Node node) {
        if (node == null) return;
        
        PreOrderTraversalUtil(node.left);
        System.out.println("Node: " + node.data.toString());
        PreOrderTraversalUtil(node.right);
    }
    
    /**
     * Level-Order traversal implementation for the {BST}
     * Time Complexity  = O(n)
     * Space Complexity = O(n) 
     */
    public void levelOrderTraversal() throws Exception {
        if (root == null) return;
        
        System.out.println("Level-Order Traversal:");
        
        Queue queue = new LinkedList<Node>();
        Iterator it = queue.iterator();
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            Node node = (Node) queue.poll();
            
            System.out.println(node.data);
            
            if (node.left != null) {
                queue.add(node.left);
            }
            
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    
    /**
     * Gets the size of the {BST} (i.e. Number of Nodes in the BST)
     * Time Complexity = O(n)
     * 
     * @return Number of {Node}s in the {BST}
     */
    public int getSize() {
        int size = getSizeUtil(root);
        System.out.println("Size of the BST is: " + size);
        return size;
    }
    
    /**
     * Utility function to get the size of the {BST}
     * 
     * @param node {Node} for which the size is to be calculated
     * @return Size of the {BST}
     */
    private int getSizeUtil(Node node) {        
        if (node == null) return 0;
        
        return getSizeUtil(node.left) + getSizeUtil(node.right) + 1;
    }
    
    /**
     * Gets the height of the {BST}
     * Time Complexity: O(n)
     * 
     * @return Height of the {BST}
     */
    public int getheight() {
        int height = getHeightUtil(root); 
        System.out.println("Height of the BST is: " + height);
        return height;
    }

    /**
     * Utility function to get the height of the {BST}
     * 
     * @param node The {BST} {Node} for which the height is to be calculated
     */
    private int getHeightUtil(Node node) {
        if (node == null) return 0;
        
        return Math.max(getHeightUtil(node.left), getHeightUtil(node.right)) + 1;
    }
    
    /**
     * Finds the minimum value in a BST 
     * Time Complexity = O(n)
     */
    public void findMin() {
        System.out.println("Finding Minimum value in the BST:");
        findMinUtil(root);
    }
    
    /**
     * Utility function to find Minimum value in the BST
     * 
     * @param node {Node} or root of the {BST} from which to find the min value
     */
    private void findMinUtil(Node node) {
        if (node == null) return;
        
        if (node.left == null) {
            System.out.println("Minimum Node has the value: " + node.data);
            return;
        } else {
            findMinUtil(node.left);
        }
    }
    
    /**
     * Finds the maximum value in a BST 
     * Time Complexity = O(n)
     */
    public void findMax() {
        System.out.println("Finding Maximum value in the BST:");
        findMaxUtil(root);
    }
    
    /**
     * Utility function to find Maximum value in the BST
     * 
     * @param node {Node} or root of the {BST} from which to find the max value
     */
    private void findMaxUtil(Node node) {
        if (node == null) return;
        
        if (node.right == null) {
            System.out.println("Maximum Node has the value: " + node.data);
            return;
        } else {
            findMaxUtil(node.right);
        }
    }
    
    /**
     * Finds the sum of all elements in the BST (in case of {Integer})
     * 
     * @return Sum of all the values. -1 in case of an empty {BST}
     */
    public int findSum() throws UnsupportedOperationException {
        int sum = findSumUtil(root);
        System.out.println("Sum of all keys in BST is: " + sum);
        return sum;
    }
    
    /**
     * Utility to help find sum of all values in the {BST}. Only works if the
     * keys of the {BST} are of type {Integer}
     * 
     * @param node root node of the {BST}
     * @return Sum of all values for this {BST}
     */
    private Integer findSumUtil(Node node) throws UnsupportedOperationException {
        if (node == null) {
            return new Integer(0);
        }
        
        if (!node.data.getClass().getSimpleName().equals("Integer")) {
            throw new UnsupportedOperationException("BST keys must be of type Integer");
        } 
        
        Integer sum = findSumUtil(node.left) + findSumUtil(node.right) + (Integer)node.data;
        return sum;
    }
    
    /**
     * Finds the average of all keys in the {BST}
     * Time Complexity = O(n+n) = O(2n) = O(n)
     */
    public float findAverage() throws UnsupportedOperationException {
        int sum   = findSum();
        int size  = getSize();
        float avg = 0;
        
        if (size == 0) {
            return avg; 
        }
        
        avg = sum/size;
        System.out.println("Average of all keys in BST: " + avg);
        return avg;
    }
    
    /**
     * Prints the {BST} key values that lie in the given range 
     * Time Complexity = O(n)
     * 
     * @param start Lower bound of the range
     * @param end   Upper bound of the range
     */
    public void findInRange(T start, T end) throws NullPointerException {
        System.out.println(String.format("Find in range %s:%s", start.toString(), end.toString()));
        findInRangeUtil(start, end, root);
    }
    
    /**
     * Utility function to print the {BST} key values that lie in the given range
     * 
     * @param start Lower bound of the range
     * @param end   Upper bound of the range
     * @param node  The {Node} that is being evaluated for range statistics 
     */
    private void findInRangeUtil(T start, T end, Node node) throws NullPointerException {
        if (start == null || end == null) {
            throw new NullPointerException("range values cannot be null");
        }
        
        if (node == null) {
            return;
        }
        
        if (node.data.compareTo(start) > 0) {           // Find in right subtree
            findInRangeUtil(start, end, node.left);
        } 
        
        if (node.data.compareTo(end) < 0) {
            findInRangeUtil(start, end, node.right);    // Find in left subtree
        } 
        
        if (start.compareTo((T) node.data) <= 0 
                && end.compareTo((T) node.data) >= 0) { // Data is in range
            System.out.println(node.data);
        }
    }
    
    /**
     * Validates in the tree built is a valid {BST}
     * 
     * @return true in case of a valid {BST}, false otherwise
     */
    public boolean isBST(Integer min, Integer max) throws NullPointerException {
        if (!min.getClass().getSimpleName().equals("Integer") 
           || !max.getClass().getSimpleName().equals("Integer")) {
            throw new UnsupportedOperationException("min/max must be of type Integer");
        } 
        
        boolean isBST = isBSTUtil(root, min, max);
        System.out.println("IsBST? = " + isBST);
        return isBST;
    }
    
    /**
     * Utility function to validate if the tree is a valid {BST} 
     * 
     * @param node The root {Node} of the Tree to be evaluated
     * @param min  The min value for the intended datatype
     * @param max  The max value for the intended datatype
     * @return     true if a valid BST, false otherwise
     * @throws NullPointerException if the provided {Node} instance is null
     */
    private boolean isBSTUtil(Node node, Integer min, Integer max) throws NullPointerException {
        if (min == null || max == null) {
            throw new NullPointerException("min/max cannot be null");
        }
        
        if (node == null) {
            return true;
        }
        
        if (node.data.compareTo(min) < 0 && node.data.compareTo(max) > 0) {
            return false;
        }
        
        return isBSTUtil(node.left, min, (Integer) node.data-1) 
            && isBSTUtil(node.right, (Integer) node.data+1, max);
    }
    
    /**
     * Checks if the {BST} is height balanced
     * Time Complexity = O(n)
     * 
     * @return true if the {BST} is height balanced, false otherwise
     */
    public boolean isBalanced() {
        boolean isBalanced = checkHeightUtil(root) != Integer.MIN_VALUE;
        System.out.println("IsBalanced = " + isBalanced);
        return isBalanced;
    }
    
    /**
     * Utility function to determine if the {BST} is height balanced. 
     * 
     * @param node Current {BST} node
     * @return Height of the {Node}. {Integer}.MIN_VALUE in case the height is not balanced
     */
    private Integer checkHeightUtil(Node node) {
        if(node==null) {
            return 0;
        }
        
        Integer leftNodeHeight  = checkHeightUtil(node.left);
        Integer rightNodeHeight = checkHeightUtil(node.right);

        if (leftNodeHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
                
        if (rightNodeHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        Integer heightDifference = leftNodeHeight - rightNodeHeight;
        
        if (Math.abs(heightDifference) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return leftNodeHeight + rightNodeHeight + 1;
        }
    }
    
    public static void main(String[] args) throws Exception {        
        BST<Integer> bst = new BST<Integer>();
        
        // Insert
        bst.insert(new Integer(5));
        bst.insert(new Integer(3));
        bst.insert(new Integer(2));
        bst.insert(new Integer(4));
        bst.insert(new Integer(7));
        bst.insert(new Integer(6));
        bst.insert(new Integer(8));
        
        // Traversals
        bst.preOrderTraversal();
        bst.inOrderTraversal();
        bst.postOrderTraversal();
        bst.levelOrderTraversal();
        
        // Search
        bst.search(new Integer(0));
        
        // Size
        bst.getSize();
        
        // Height
        bst.getheight();
        
        // Min/Max
        bst.findMin();
        bst.findMax();
        
        // Sum
        bst.findSum();
        
        // Average
        bst.findAverage();
        
        // Range statistics
        bst.findInRange(new Integer(2), new Integer(7));
        
        // Is BST?
        bst.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        // Is Height Balanced?
        bst.isBalanced();
    }
}
