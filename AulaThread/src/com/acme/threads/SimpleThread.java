/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.threads;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author felix
 */
public class SimpleThread implements Runnable {

    FrameThread frame;
    int pos;
    static int segundos, minutos, horas;

    public SimpleThread(FrameThread rcv, int cont) {
        this.frame = rcv;
        this.pos = cont;
    }

    @Override
    public void run() {
        while (frame.getContinue()) {
            if (pos == 0) {
                for (Component a : frame.getContentPane().getComponents()) {
                    if (a instanceof JLabel) {
                        if (a.getName().equalsIgnoreCase("segundos")) {
                            try {
                                Thread.sleep(1000);
                                segundos++;
                                if (segundos <= 9) {
                                    ((JLabel) a).setText("0" + String.valueOf(segundos));
                                } else {
                                    ((JLabel) a).setText(String.valueOf(segundos));
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

}
