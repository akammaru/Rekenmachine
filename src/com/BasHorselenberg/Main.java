package com.BasHorselenberg;

import javax.swing.*;

/**
 * This class is the startup class.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frame();
            }
        });
    }
}
