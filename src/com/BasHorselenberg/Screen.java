package com.BasHorselenberg;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bas_Horselenberg on 22-5-2017.
 * this class wil be the screen that shows in real time, the inputted values.
 */
public class Screen extends JPanel{

    private JTextField stored;
    private JTextField current;

    private String storedValue;
    private String currentValue;

    public Screen() {
        //initialising the screen textfields.
        stored = new JTextField(5);
        current = new JTextField(5);

        //remove textfield borders.
        stored.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        current.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        //disable textinput on textfields.
        stored.setEnabled(false);
        current.setEnabled(false);

        //change alignment to right side.
        stored.setHorizontalAlignment(SwingConstants.RIGHT);
        current.setHorizontalAlignment(SwingConstants.RIGHT);

        //change text color back to black.
        stored.setDisabledTextColor(Color.black);
        current.setDisabledTextColor(Color.black);

        //initalising defaullt values.
        storedValue = "0";
        currentValue = "0";

        //setting gridbaglayout and creating needed contraints.
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;

        //setting location for stored panel and adding it to the panel.
        gc.gridx = 0;
        gc.gridy = 0;
        add(stored,gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(current,gc);

        setScreenCurrent("0");
        setScreenRemembered();

    }

    /**
     * Set the currently modifyable text to the visible screen.
     * @param incomming incomming string that needs to printed on the screen.
     */
    private void setScreenCurrent(String incomming){

        current.setText(currentValue);
    }

    private void setScreenRemembered(){
        stored.setText(storedValue);
    }

    private void storeValue(){
        storedValue = currentValue;
    }


}
