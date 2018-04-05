/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.threads;

/**
 *
 * @author Mateus
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FrameThread f = new FrameThread();
        f.setVisible(true);
    }
    
}
