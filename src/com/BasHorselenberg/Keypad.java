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

    // initialising default values
    private String activeValue;
    private String operator;
    private String storedValue;

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

    // adding counter for continued calculation.
    private int equalsPressed;
    private String continueCalc;

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


        //setting default values
        activeValue = "0";
        storedValue = "0";

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
        equalsPressed = 0;
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
            addCharacter("0");
        } else if (clicked == number1) {
            addCharacter("1");
        } else if (clicked == number2) {
            addCharacter("2");
        } else if (clicked == number3) {
            addCharacter("3");
        } else if (clicked == number4) {
            addCharacter("4");
        } else if (clicked == number5) {
            addCharacter("5");
        } else if (clicked == number6) {
            addCharacter("6");
        } else if (clicked == number7) {
            addCharacter("7");
        } else if (clicked == number8) {
            addCharacter("8");
        } else if (clicked == number9) {
            addCharacter("9");
        } else if (clicked == operatorMinus) {
            addCharacter("-");
            resetActive();
        } else if (clicked == operatorPlus) {
            addCharacter("+");
            resetActive();
        } else if (clicked == operatorDevide) {
            addCharacter("/");
            resetActive();
        } else if (clicked == operatorMultiply) {
            addCharacter("*");
            resetActive();
        } else if (clicked == operatorDot) {
            addCharacter(".");
            resetActive();
        } else if (clicked == operator1DevidedByX) {
            addCharacter("x");
            resetActive();
        } else if (clicked == operatorSquarRoot) {
            addCharacter("√");
            resetActive();
        } else if (clicked == operatorToPercentage) {
            addCharacter("%");
            resetActive();
        } else if (clicked == removeOne) {
            removeLast();
        } else if (clicked == clearCurrent) {
            resetActive();
        } else if (clicked == clearAll) {
            clearAll(false);
        } else if (clicked == result) {
            equalsPressed++;
            if (equalsPressed == 1) {
                startCalc();
            } else {
                continueCalc();
            }

        }
    }

    /**
     * check what the pressed key has been and handle it accordingly.
     *
     * @param input input characters comming from the keypad.
     */
    private void addCharacter(String input) {
        //checking for a number inout with regx1
        String regx1 = "(\\d)?(\\.)?";
        //checking for the operators with regx2
        String regx2 = "(\\+)?(\\-)?(\\*)?(\\/)?";
        if (input.matches(regx1)) {
            if (activeValue.equals("0")) {
                activeValue = input;
                setScreenCurrent(activeValue + " ");
            } else {
                activeValue = activeValue + input;
                setScreenCurrent(activeValue + " ");
            }
        } else if (input.matches(regx2)) {
            operator = input;
            storedValue = activeValue;
            setScreenRemembered(storedValue + " " + operator);
        }
    }

    /**
     * setting the current vaule to active screen.
     *
     * @param incomming value to set to active output.
     */
    private void setScreenCurrent(String incomming) { current.setText(incomming); }

    /**
     * setting the stored value to screen.
     *
     * @param saved value to be shown as stored.
     */
    private void setScreenRemembered(String saved) {
        stored.setText(saved);
    }

    /**
     * set both output fields at the same time.
     *
     * @param incomming String to be shown as the active value slot.
     * @param saved String that will be placed in the stored value slot.
     */
    private void setBothScreens(String incomming, String saved) {
        current.setText(incomming);
        stored.setText(saved);
    }

    /**
     * recieves an array with values to be displayed as the result.
     *
     * @param result array with details to be show.
     */
    public void setScreenResult(String[] result) {
        String calculation = result[0];
        String answer = result[1];
        continueCalc = result[1];
        setBothScreens(answer, calculation);
    }

    /**
     * packs the two different calculation variables and the operator in to an array and sends it over to the controller.
     */
    private void sendData(String activeNumber, String storedNumber, String action) {
        String[] data = new String[3];
        data[0] = activeNumber;
        data[1] = storedNumber;
        data[2] = action;
        keypadListener.listenKey(data);
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
     * removes the last digit from the activeValue.
     */
    private void removeLast() {
        //doesnt work jet.
        if (activeValue != null && activeValue.length() > 0 && activeValue.charAt(activeValue.length() - 1) == 'x') {
            activeValue = activeValue.substring(0, activeValue.length() - 1);
        }
    }

    /**
     * resets the active value for new input.
     */
    private void resetActive() {
        activeValue = "0";
        setScreenCurrent(activeValue);
    }

    /**
     * logic for a continued calculation.
     */
    private void continueCalc() {
        sendData(activeValue, storedValue, operator);



    }

    /**
     * logic for the first calculation.
     */
    private void startCalc(){
        sendData(activeValue, storedValue, operator);
        clearAll(true);
    }

    /**
     * removes all stored values and reprints them on the screen.
     */
    private void clearAll(boolean stringcalc) {
        activeValue = "0";
        storedValue = "0";
        operator = "+";
        if (stringcalc == true){
            //do nothing
        }else{
            equalsPressed = 0;
        }

    }
}
