/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

import files.Regalo;

/**
 *
 * @author nelsoncarrillo
 */
public class AVLTree {
    private AVLNode root;
    
    public AVLTree(){
        this.root=null;
    }
    
    int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }

    public AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    public void insert(AVLNode node, Regalo key2) {
    if (node == null) {
        node = new AVLNode(key2);
        return;
    }

    if (key2.getCosto() < node.keyprincipal.getCosto()) {
        if (node.left == null) {
            node.left = new AVLNode(key2);
        } else {
            insert(node.left, key2);
        }
    } else if (key2.getCosto() > node.keyprincipal.getCosto()) {
        if (node.right == null) {
            node.right = new AVLNode(key2);
        } else {
            insert(node.right, key2);
        }
    }
  
    node.height = 1 + max(height(node.left), height(node.right));

    int balance = getBalance(node);

    if (balance > 1 && key2.getCosto() < node.left.keyprincipal.getCosto()) {
        node = rightRotate(node);
    }

    if (balance < -1 && key2.getCosto() > node.right.keyprincipal.getCosto()) {
        node = leftRotate(node);
    }

    if (balance > 1 && key2.getCosto() > node.left.keyprincipal.getCosto()) {
        node.left = leftRotate(node.left);
        node = rightRotate(node);
    }

    if (balance < -1 && key2.getCosto() < node.right.keyprincipal.getCosto()) {
        node.right = rightRotate(node.right);
        node = leftRotate(node);
    }
}

    public String inOrder(AVLNode node) {
    StringBuilder sb = new StringBuilder();
    inOrderTraversal(node, sb);
    return sb.toString();
}

private void inOrderTraversal(AVLNode node, StringBuilder sb) {
    if (node != null) {
        inOrderTraversal(node.left, sb);
        sb.append(node.key).append(" ");
        inOrderTraversal(node.right, sb);
    }
}

    /**
     * @return the root
     */
    public AVLNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(AVLNode root) {
        this.root = root;
    }

    
}
