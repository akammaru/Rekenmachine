package com.BasHorselenberg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bas_Horselenberg on 22-5-2017.
 * this is the main handler class that creates all the pannels and screens and adds them on the main frame.
 */
public class Frame extends JFrame {

    private JFrame frame;

    private Screen screen;
    private Keypad keypad;
    private CalcLogic calcLogic;

    public Frame() {
        //initializing main Frame and setting title.
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setLayout(new BorderLayout());

        //generate the complete GUI.
        generateUI();

        //create the CalcLogic object.
        calcLogic = new CalcLogic();

        keypad.setIKeypadListener(new IKeypadListener(){
            @Override
            public void listenKey(String keypadString){calcLogic.addCharacter(keypadString);}
        });

        //changing background color of main pannel.
        frame.getContentPane().setBackground(Color.YELLOW);
        //setting heigth and width of main screan.
        frame.setSize(500, 300);
        //disable window resizing.
        frame.setResizable(false);
        //default close operation for shutting down java program when closed.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set panel to visible.
        frame.setVisible(true);
    }

    private void generateUI(){
        //generate the calculator screen.
        screen = new Screen();
        frame.add(screen, BorderLayout.CENTER);
        screen.setBackground(Color.WHITE);
//        screen.setBounds(0,0,800,150);


        //generate the keypad.
        keypad = new Keypad();
        frame.add(keypad, BorderLayout.SOUTH);
//        keypad.setBounds(0,0,800,350);
    }
}
