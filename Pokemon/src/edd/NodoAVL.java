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
public class NodoAVL {
    Regalo regalo;
    int altura;
    NodoAVL izquierdo;
    NodoAVL derecho;

    public NodoAVL(Regalo value) {
        regalo=value;
        altura = 1;
    }
}
