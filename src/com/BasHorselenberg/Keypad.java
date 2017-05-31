package com.BasHorselenberg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bas_Horselenberg on 22-5-2017.
 * this class will contain all the numbers and other buttons to be shown on the calculator
 */
public class Keypad extends JPanel implements ActionListener {

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
    private IKeypadListener IKeypadListener;

    /**
     * Main constructor for Keypad. all buttons will be initialised as well as the pannel.
     */
    public Keypad() {
        //position Yrows.
        int FIRST = 0;
        int SECOND = 1;
        int THIRD = 2;
        int FOURTH = 3;
        int FIFTH = 4;

        //setting up base values for gridbaglayout.
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.weighty = 1;

        //setting focus to shit panel.
        this.requestFocus();

        //initializing buttons
        //Utility row
        removeOne = new JButton("<---");
        gc.gridx = 0;
        gc.gridy = FIRST;
        add(removeOne, gc);
        removeOne.addActionListener(this);
        clearAll = new JButton("CE");
        gc.gridx = 1;
        gc.gridy = FIRST;
        add(clearAll, gc);
        clearAll.addActionListener(this);
        clearCurrent = new JButton("C");
        gc.gridx = 1;
        gc.gridy = FIRST;
        add(clearCurrent, gc);
        clearCurrent.addActionListener(this);
        reverse = new JButton("±");
        gc.gridx = 2;
        gc.gridy = FIRST;
        add(reverse, gc);
        reverse.addActionListener(this);
        operatorSquarRoot = new JButton("√");
        gc.gridx = 3;
        gc.gridy = FIRST;
        add(operatorSquarRoot, gc);
        operatorSquarRoot.addActionListener(this);

        //top row
        number7 = new JButton("7");
        gc.gridx = 0;
        gc.gridy = SECOND;
        add(number7, gc);
        number7.addActionListener(this);
        number8 = new JButton("8");
        gc.gridx = 1;
        gc.gridy = SECOND;
        add(number8, gc);
        number8.addActionListener(this);
        number9 = new JButton("9");
        gc.gridx = 2;
        gc.gridy = SECOND;
        add(number9, gc);
        number9.addActionListener(this);
        operatorDevide = new JButton("/");
        gc.gridx = 3;
        gc.gridy = SECOND;
        add(operatorDevide, gc);
        operatorDevide.addActionListener(this);
        operatorSquarRoot = new JButton("%");
        gc.gridx = 4;
        gc.gridy = SECOND;
        add(operatorSquarRoot, gc);
        operatorSquarRoot.addActionListener(this);


        //middle row
        number4 = new JButton("4");
        gc.gridx = 0;
        gc.gridy = THIRD;
        add(number4, gc);
        number4.addActionListener(this);
        number5 = new JButton("5");
        gc.gridx = 1;
        gc.gridy = THIRD;
        add(number5, gc);
        number5.addActionListener(this);
        number6 = new JButton("6");
        gc.gridx = 2;
        gc.gridy = THIRD;
        add(number6, gc);
        number6.addActionListener(this);
        operatorMultiply = new JButton("*");
        gc.gridx = 3;
        gc.gridy = THIRD;
        add(operatorMultiply, gc);
        operatorMultiply.addActionListener(this);
        operator1DevidedByX = new JButton("1/x");
        gc.gridx = 4;
        gc.gridy = THIRD;
        add(operator1DevidedByX, gc);
        operator1DevidedByX.addActionListener(this);

        //3rd row.
        number1 = new JButton("1");
        gc.gridx = 0;
        gc.gridy = FOURTH;
        add(number1, gc);
        number1.addActionListener(this);
        number2 = new JButton("2");
        gc.gridx = 1;
        gc.gridy = FOURTH;
        add(number2, gc);
        number2.addActionListener(this);
        number3 = new JButton("3");
        gc.gridx = 2;
        gc.gridy = FOURTH;
        add(number3, gc);
        number3.addActionListener(this);
        operatorMinus = new JButton("-");
        gc.gridx = 3;
        gc.gridy = FOURTH;
        add(operatorMinus, gc);
        operatorMinus.addActionListener(this);
        result = new JButton("=");
        gc.gridx = 4;
        gc.gridy = FOURTH;
        gc.weighty = 2;
        gc.gridheight = 2;
        gc.ipady = 25;
        add(result, gc);
        result.addActionListener(this);


        //bottom row.
        number0 = new JButton("0");
        gc.gridx = 0;
        gc.weightx = 2;
        gc.gridy = FIFTH;
        gc.weighty = 1;
        gc.gridheight = 1;
        gc.gridwidth = 2;
        gc.ipady = 0;
        add(number0, gc);
        number0.addActionListener(this);
        operatorDot = new JButton(".");
        gc.gridx = 2;
        gc.gridy = FIFTH;
        gc.weightx = 1;
        gc.gridwidth = 1;
        add(operatorDot, gc);
        operatorDot.addActionListener(this);
        operatorPlus = new JButton("+");
        gc.gridx = 3;
        gc.gridy = FIFTH;
        add(operatorPlus, gc);
        operatorPlus.addActionListener(this);
    }

    public void setIKeypadListener(IKeypadListener listener){
        this.IKeypadListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if(clicked == number0){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("0");
            }
        }else if(clicked == number1){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("1");
            }
        }else if(clicked == number2){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("2");
            }
        }else if(clicked == number3){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("3");
            }
        }else if(clicked == number4){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("4");
            }
        }else if(clicked == number5){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("5");
            }
        }else if(clicked == number6){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("6");
            }
        }else if(clicked == number7){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("7");
            }
        }else if(clicked == number8){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("8");
            }
        }else if(clicked == number9){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("9");
            }
        }else if(clicked == operatorMinus){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("-");
            }
        }else if(clicked == operatorPlus){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("+");
            }
        }else if(clicked == operatorDevide){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("/");
            }
        }else if(clicked == operatorMultiply){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("*");
            }
        }else if(clicked == operatorDot){
            if(IKeypadListener != null){
                IKeypadListener.listenKey(".");
            }
        }else if(clicked == operator1DevidedByX){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("x");
            }
        }else if(clicked == operatorSquarRoot){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("√");
            }
        }else if(clicked == operatorToPercentage){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("%");
            }
        }else if(clicked == removeOne){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("del1");
            }
        }else if(clicked == clearCurrent){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("clrCur");
            }
        }else if(clicked == clearAll){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("clrAll");
            }
        }else if(clicked == result){
            if(IKeypadListener != null){
                IKeypadListener.listenKey("=");
            }
        }
    }
}
