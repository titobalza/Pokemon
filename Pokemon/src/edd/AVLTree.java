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
    private NodoAVL raiz;

    public void insertar(Regalo regalo) {
        raiz = insertarNodo(raiz, regalo);
    }

    private NodoAVL insertarNodo(NodoAVL nodo, Regalo regalo) {
        if (nodo == null) {
            return new NodoAVL(regalo);
        }

        if (regalo.costo<nodo.regalo.costo) {
            nodo.izquierdo = insertarNodo(nodo.izquierdo, regalo);
        } else if (regalo.costo>nodo.regalo.costo) {
            nodo.derecho = insertarNodo(nodo.derecho, regalo);
        } else {
            // Duplicado, no se permiten regalos repetidos
            return nodo;
        }

        nodo.altura = 1 + Math.max(obtenerAltura(nodo.izquierdo), obtenerAltura(nodo.derecho));

        int balance = obtenerBalance(nodo);

        if (balance > 1 && regalo.costo<nodo.regalo.costo) {
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && regalo.costo>nodo.regalo.costo) {
            return rotacionIzquierda(nodo);
        }

        if (balance > 1 && regalo.costo>nodo.regalo.costo) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && regalo.costo<nodo.regalo.costo) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL rotacionDerecha(NodoAVL z) {
        NodoAVL y = z.izquierdo;
        NodoAVL T3 = y.derecho;

        y.derecho = z;
        z.izquierdo = T3;

        z.altura = 1 + Math.max(obtenerAltura(z.izquierdo), obtenerAltura(z.derecho));
        y.altura = 1 + Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho));

        return y;
    }

    private NodoAVL rotacionIzquierda(NodoAVL z) {
        NodoAVL y = z.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = z;
        z.derecho = T2;

        z.altura = 1 + Math.max(obtenerAltura(z.izquierdo), obtenerAltura(z.derecho));
        y.altura = 1 + Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho));

        return y;
    }

    private int obtenerAltura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    private int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return obtenerAltura(nodo.izquierdo) - obtenerAltura(nodo.derecho);
    }
    
    public NodoAVL getRoot(){
        return this.raiz;
    }
    
    public String recorridoInorden() {
        StringBuilder sb = new StringBuilder();
        recorridoInorden(raiz, sb);
        return sb.toString();
    }

    private void recorridoInorden(NodoAVL nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierdo, sb);
            sb.append(nodo.regalo.getNombre()+"\n");
            recorridoInorden(nodo.derecho, sb);
        }
    }


    
}
