package com.BasHorselenberg;

import javax.swing.*;
import java.awt.*;

/**
 * @author Bas_Horselenberg
 * this is the main handler class that creates all the pannels and screens and adds them on the main frame.
 */
public class Frame extends JFrame {

    // create main frame variable.
    private JFrame frame;

    // create panels variables.
    private Keypad keypad;
    private CalcLogic calcLogic;

    /**
     * general creating all classes and managing connection between the classes in the constructor.
     */
    public Frame() {
        //initializing main Frame and setting title.
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setLayout(new BorderLayout());
        //setting heigth and width of main screan.
        frame.setSize(500, 330);

        //create the CalcLogic object.
        calcLogic = new CalcLogic();


        //generate the keypad.
        keypad = new Keypad();
        keypad.setPreferredSize(new Dimension(500, 330));
        frame.add(keypad, BorderLayout.SOUTH);

        // connection from keypad to CalcLogic.
        keypad.setKeypadListener(new IKeypadListener(){
            @Override
            public void listenKey(String[] keypadArray) {
                calcLogic.getData(keypadArray);
            }
        });

        // connection from CalcLogic to keypad.
        calcLogic.setLogicListener(new IKeypadListener(){
            @Override
            public void listenKey(String[] keypadArray) {
                keypad.setScreenResult(keypadArray);
            }
        });

        //changing background color of main pannel.
        frame.getContentPane().setBackground(Color.YELLOW);

        //disable window resizing.
        frame.setResizable(false);
        //default close operation for shutting down java program when closed.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set panel to visible.
        frame.setVisible(true);
    }
}
