package com.BasHorselenberg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bas_Horselenberg
 *         this class will contain all the numbers and other buttons to be shown on the calculator
 */
public class Keypad extends JPanel implements ActionListener {
    // creating output screens
    private JTextField stored;
    private JTextField current;

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
    private JButton operatorDot;
    private JButton operatorSquarRoot;
    private JButton operatorToPercentage;
    private JButton operator1DevidedByX;

    //Activators
    private JButton removeOne;
    private JButton clearCurrent;
    private JButton clearAll;
    private JButton reverse;
    private JButton result;

    //adding custom listener
    private IKeypadListener keypadListener;

    /**
     * Main constructor for Keypad. all buttons and screens are initialised and added to the panel.
     */
    public Keypad() {
        // creating different panels.
        JPanel outputScreen = new JPanel();
        outputScreen.setPreferredSize(new Dimension(500, 150));
        outputScreen.setLayout(new BoxLayout(outputScreen, BoxLayout.PAGE_AXIS));
        outputScreen.setBackground(Color.magenta);
        add(outputScreen);
        JPanel keyboard = new JPanel();
        keyboard.setPreferredSize(new Dimension(500, 150));
        add(keyboard);

        //position Yrows
        int FIRST = 1;
        int SECOND = 2;
        int THIRD = 3;
        int FOURTH = 4;
        int FIFTH = 5;

        //setting up base values for gridbaglayout
        keyboard.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.weighty = 1;

        //setting focus to shit panel
        this.requestFocus();

        //initialising the screen textfields
        stored = new JTextField(5);
        current = new JTextField(5);

        //remove textfield borders
        stored.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        current.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        //disable textinput on textfields
        stored.setEnabled(false);
        current.setEnabled(false);

        //change alignment to right side
        stored.setHorizontalAlignment(SwingConstants.RIGHT);
        current.setHorizontalAlignment(SwingConstants.RIGHT);

        //change text color back to black
        stored.setDisabledTextColor(Color.black);
        current.setDisabledTextColor(Color.black);

        //changing background collor for debug puroposes.
        stored.setBackground(Color.white);
        current.setBackground(Color.WHITE);

        //setting the size of the text pannels.
        stored.setPreferredSize(new Dimension(500, 20));
        current.setPreferredSize(new Dimension(500, 20));

        // adding output screens to panel.
        outputScreen.add(stored, BorderLayout.NORTH);
        outputScreen.add(current, BorderLayout.SOUTH);

        //initializing buttons
        //Utility row
        // <-
        removeOne = new JButton("<---");
        gc.gridx = 0;
        gc.gridy = FIRST;
        gc.weightx = 1;
        keyboard.add(removeOne, gc);
        removeOne.addActionListener(this);
        // CE
        clearAll = new JButton("CE");
        gc.gridx = 1;
        gc.gridy = FIRST;
        keyboard.add(clearAll, gc);
        clearAll.addActionListener(this);
        // C
        clearCurrent = new JButton("C");
        gc.gridx = 1;
        gc.gridy = FIRST;
        keyboard.add(clearCurrent, gc);
        clearCurrent.addActionListener(this);
        // ±
        reverse = new JButton("±");
        gc.gridx = 2;
        gc.gridy = FIRST;
        keyboard.add(reverse, gc);
        reverse.addActionListener(this);
        // √
        operatorSquarRoot = new JButton("√");
        gc.gridx = 3;
        gc.gridy = FIRST;
        keyboard.add(operatorSquarRoot, gc);
        operatorSquarRoot.addActionListener(this);

        //top row
        // 7
        number7 = new JButton("7");
        gc.gridx = 0;
        gc.gridy = SECOND;
        keyboard.add(number7, gc);
        number7.addActionListener(this);
        // 8
        number8 = new JButton("8");
        gc.gridx = 1;
        gc.gridy = SECOND;
        keyboard.add(number8, gc);
        number8.addActionListener(this);
        // 9
        number9 = new JButton("9");
        gc.gridx = 2;
        gc.gridy = SECOND;
        keyboard.add(number9, gc);
        number9.addActionListener(this);
        // /
        operatorDevide = new JButton("/");
        gc.gridx = 3;
        gc.gridy = SECOND;
        keyboard.add(operatorDevide, gc);
        operatorDevide.addActionListener(this);
        // %
        operatorSquarRoot = new JButton("%");
        gc.gridx = 4;
        gc.gridy = SECOND;
        keyboard.add(operatorSquarRoot, gc);
        operatorSquarRoot.addActionListener(this);


        //middle row
        // 4
        number4 = new JButton("4");
        gc.gridx = 0;
        gc.gridy = THIRD;
        keyboard.add(number4, gc);
        number4.addActionListener(this);
        // 5
        number5 = new JButton("5");
        gc.gridx = 1;
        gc.gridy = THIRD;
        keyboard.add(number5, gc);
        number5.addActionListener(this);
        // 6
        number6 = new JButton("6");
        gc.gridx = 2;
        gc.gridy = THIRD;
        keyboard.add(number6, gc);
        number6.addActionListener(this);
        // *
        operatorMultiply = new JButton("*");
        gc.gridx = 3;
        gc.gridy = THIRD;
        keyboard.add(operatorMultiply, gc);
        operatorMultiply.addActionListener(this);
        // 1/x
        operator1DevidedByX = new JButton("1/x");
        gc.gridx = 4;
        gc.gridy = THIRD;
        keyboard.add(operator1DevidedByX, gc);
        operator1DevidedByX.addActionListener(this);

        //3rd row
        // 1
        number1 = new JButton("1");
        gc.gridx = 0;
        gc.gridy = FOURTH;
        keyboard.add(number1, gc);
        number1.addActionListener(this);
        // 2
        number2 = new JButton("2");
        gc.gridx = 1;
        gc.gridy = FOURTH;
        keyboard.add(number2, gc);
        number2.addActionListener(this);
        // 3
        number3 = new JButton("3");
        gc.gridx = 2;
        gc.gridy = FOURTH;
        keyboard.add(number3, gc);
        number3.addActionListener(this);
        // -
        operatorMinus = new JButton("-");
        gc.gridx = 3;
        gc.gridy = FOURTH;
        keyboard.add(operatorMinus, gc);
        operatorMinus.addActionListener(this);
        // =
        result = new JButton("=");
        gc.gridx = 4;
        gc.gridy = FOURTH;
        gc.weighty = 2;
        gc.gridheight = 2;
        gc.ipady = 25;
        keyboard.add(result, gc);
        result.addActionListener(this);


        //bottom row
        // 0
        number0 = new JButton("0");
        gc.gridx = 0;
        gc.weightx = 2;
        gc.gridy = FIFTH;
        gc.weighty = 1;
        gc.gridheight = 1;
        gc.gridwidth = 2;
        gc.ipady = 0;
        keyboard.add(number0, gc);
        number0.addActionListener(this);
        // .
        operatorDot = new JButton(".");
        gc.gridx = 2;
        gc.gridy = FIFTH;
        gc.weightx = 1;
        gc.gridwidth = 1;
        keyboard.add(operatorDot, gc);
        operatorDot.addActionListener(this);
        // +
        operatorPlus = new JButton("+");
        gc.gridx = 3;
        gc.gridy = FIFTH;
        keyboard.add(operatorPlus, gc);
        operatorPlus.addActionListener(this);
    }

    /**
     * main action listener, listens for all actions to be used and handles them accordingly.
     *
     * @param e action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == number0) {
            send("0");
        } else if (clicked == number1) {
            send("1");
        } else if (clicked == number2) {
            send("2");
        } else if (clicked == number3) {
            send("3");
        } else if (clicked == number4) {
            send("4");
        } else if (clicked == number5) {
            send("5");
        } else if (clicked == number6) {
            send("6");
        } else if (clicked == number7) {
            send("7");
        } else if (clicked == number8) {
            send("8");
        } else if (clicked == number9) {
            send("9");
        } else if (clicked == operatorMinus) {
            send("-");
        } else if (clicked == operatorPlus) {
            send("+");
        } else if (clicked == operatorDevide) {
            send("/");
        } else if (clicked == operatorMultiply) {
            send("*");
        } else if (clicked == operatorDot) {
            send(".");
        } else if (clicked == operator1DevidedByX) {
            send("x");
        } else if (clicked == operatorSquarRoot) {
            send("√");
        } else if (clicked == operatorToPercentage) {
            send("%");
        } else if (clicked == removeOne) {
            send("one");
        } else if (clicked == clearCurrent) {
            send("current");
        } else if (clicked == clearAll) {
            send("all");
        } else if (clicked == result) {
            send("=");
        }
    }

    /**
     * setting connection interface.
     *
     * @param listener data to be send to external classes.
     */
    public void setKeypadListener(IKeypadListener listener) {
        this.keypadListener = listener;
    }

    /**
     * sends input out to controler.
     * @param toSend String to be send.
     */
    private void send(String toSend){
        keypadListener.listenKey(toSend);
    }

    public void setScreen(String[] input){
        String saved = input[0];
        String active = input[1];
        current.setText(active);
        stored.setText(saved);
    }
}