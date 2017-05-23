package com.BasHorselenberg;

import javax.swing.*;

/**
 * Created by Bas_Horselenberg on 22-5-2017.
 * this class will contain all the numbers and other buttons to be shown on the calculator
 */
public class Keypad extends JPanel{
    // buttons 0 - 9
    private JButton number0;
    private JButton number1;
    private JButton number2;
    private JButton number3;
    private JButton number4;
    private JButton number5;
    private JButton number6;
    private JButton number7;
    private JButton number8;
    private JButton number9;

    //button Operators
    private JButton operatorMinus;
    private JButton operatorPlus;
    private JButton operatorMultiply;
    private JButton operatorDevide;

    /**
     * Main constructor for Keypad. all buttons will be initialised as well as the pannel.
     */
    public Keypad(){


    }

    private void generateKeypad(){
        //initializing buttons
        number0 = new JButton();
        number1 = new JButton();
        number2 = new JButton();
        number3 = new JButton();
        number4 = new JButton();
        number5 = new JButton();
        number6 = new JButton();
        number7 = new JButton();
        number8 = new JButton();
        number9 = new JButton();
    }
}
