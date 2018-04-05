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

    int segundos, minutos, horas;
    FrameThread frame;
    int pos;

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
                                if (frame.getSegundos() >= 59) {
                                    frame.setSegundos(0);
                                    segundos = 0;
                                }
                                frame.setSegundos(segundos);
                                if (frame.getSegundos() <= 9) {
                                    ((JLabel) a).setText("0" + String.valueOf(frame.getSegundos()));
                                } else {
                                    ((JLabel) a).setText(String.valueOf(frame.getSegundos()));
                                }

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }

            if (pos == 1) {
                for (Component a : frame.getContentPane().getComponents()) {
                    if (a instanceof JLabel) {
                        if (a.getName().equalsIgnoreCase("minutos")) {
                            try {
                                Thread.sleep(60000);
                                minutos++;
                                if (frame.getMinutos() >= 59) {
                                    frame.setMinutos(0);
                                    minutos = 0;
                                }
                                frame.setMinutos(minutos);
                                if (frame.getMinutos() <= 9) {
                                    ((JLabel) a).setText("0" + String.valueOf(frame.getMinutos()));
                                } else {
                                    ((JLabel) a).setText(String.valueOf(frame.getMinutos()));
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }

            if (pos == 2) {
                for (Component a : frame.getContentPane().getComponents()) {
                    if (a instanceof JLabel) {
                        if (a.getName().equalsIgnoreCase("horas")) {
                            try {
                                Thread.sleep(3600000);
                                horas++;
                                if (frame.getHoras() >= 23) {
                                    frame.setHoras(0);
                                    horas = 0;
                                }
                                frame.setHoras(horas);
                                if (frame.getHoras() <= 9) {
                                    ((JLabel) a).setText("0" + String.valueOf(frame.getHoras()));
                                } else {
                                    ((JLabel) a).setText(String.valueOf(frame.getHoras()));
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
