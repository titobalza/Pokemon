/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd;

import files.Regalo;

/**
 * The NodoAVL class represents a node in an AVL tree.
 * It contains a Regalo object, height information, and references to left and right child nodes.
 * 
 * @author nelsoncarrillo
 */
public class NodoAVL {
    Regalo regalo;
    int altura;
    NodoAVL izquierdo;
    NodoAVL derecho;

    /**
     * Constructs a new NodoAVL object with the given Regalo object.
     * 
     * @param value The Regalo object to be stored in the node.
     */
    public NodoAVL(Regalo value) {
        regalo = value;
        altura = 1;
    }
}
