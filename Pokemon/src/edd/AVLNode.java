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
public class AVLNode {
    Regalo keyprincipal;
    int key;
    int height;
    AVLNode left, right;

    public AVLNode(Regalo value) {
        keyprincipal=value;
        key = value.getCosto();
        height = 1;
    }
}
