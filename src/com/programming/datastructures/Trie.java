package com.programming.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the Trie Data Structure
 * 
 * @author Snehil
 */
public class Trie<T> {
    
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    private class TrieNode<T> {
        
        public TrieNode() {
            T                data        = null;
            boolean          isEndOfWord = false;
            Map<T, TrieNode> children    = new HashMap<T, TrieNode>();
        }
        
    }
    
    public void insert(T data) {
        insertUtil(data, root);
    }
    
    private void insertUtil(T data, TrieNode node) throws IllegalArgumentException {
        if (data == null) return;
        
        if (node == null) {
            throw new IllegalArgumentException("TrieNode cannot be null");
        }
    }
    
    public static void main(String[] args) throws Exception {
        Trie<Character> trie = new Trie<Character>();
        
        // Insert
        trie.insert(new Character('a'));
    }
}
