package com.BasHorselenberg;

import java.math.BigInteger;

/**
 * @author Bas_Horselenberg
 *         this class will hold all the logic for the calculator and will be responsible for the acctual math.
 */
public class CalcLogic implements IToKeypad {

    //String used to build the complete number, before converting to string.
    private String builder;
    private String operator;

    // basic vatiables for storage. to use in actual calculations.
    private int currentValue;
    private int storedValue;
    private int prevAnswer;

    // creating new interface instance for return to  keypad.
    private IToKeypad output;

    /**
     * General constructor for CalcLogic class.
     */
    public CalcLogic() {
        builder = "0";
        prevAnswer = 0;
    }

    /**
     * output for correct data and storing answer in variable for continues calculations
     *
     * @param answer   calcualated answer
     * @param operator operator
     */
    public void setResult(int answer, String operator) {
        String sum = currentValue + " " + operator + " " + storedValue + " =";
        String localResult = Integer.toString(answer);
        String[] send = new String[2];
        send[0] = sum;
        send[1] = localResult;
        output.stored(send);
        prevAnswer = answer;

    }

    /**
     * error message output
     *
     * @param mssg
     */
    public void setResult(String mssg) {
        String sum = currentValue + " + " + storedValue + " =";
        String[] send = new String[2];
        send[0] = sum;
        send[1] = mssg;
        output.stored(send);
    }

    /**
     * add calculation.
     *
     * @param num1 first int to be added.
     * @param num2 second int to be added.
     */
    private void add(int num1, int num2) {
        int localResult = num1 + num2;
        setResult(localResult, "+");
    }

    /**
     * subtractin calculation.
     *
     * @param num1 first int, will be subtracted from.
     * @param num2 second int, this is the ammount that will be subtracted.
     */
    private void subtr(int num1, int num2) {
        int localResult = num1 - num2;
        setResult(localResult, "-");
    }

    /**
     * multiply calculation.
     *
     * @param num1 int to be multiplied.
     * @param num2 the ammount num1 will be multiplied.
     */
    private void multiply(int num1, int num2) {
        int localResult = num1 * num2;
        setResult(localResult, "x");
    }

    /**
     * devide calculation.
     *
     * @param num1 number to be devided.
     * @param num2 number num1 will be devided by.
     */
    private void devide(int num1, int num2) {
        int localResult = num1 / num2;
        setResult(localResult, "/");
    }

    /**
     * method for all error handeling.
     *
     * @param errormssg number representing the error that should be returned.
     */
    private void error(int errormssg) {
        String mssg;
        switch (errormssg) {
            case 1:
                mssg = "fill in two numbers.";
                break;
            case 2:
                mssg = "Value is to high or low.";
                break;
            default:
                mssg = "Default error message";
                break;
        }
        setResult(mssg);
    }

    /**
     * create link to controler.
     *
     * @param listener
     */
    public void setOutput(IToKeypad listener) {
        this.output = listener;
    }

    /**
     * Builds a String to later convert it to in.
     *
     * @param input will to be added to the string.
     */
    public void buildString(String input) {
        //local checking variables.
        BigInteger checkBuilder;
        BigInteger intMax = new BigInteger(Integer.toString(Integer.MAX_VALUE));
        BigInteger intmin = new BigInteger(Integer.toString(Integer.MIN_VALUE));

        //checking for a number with regx1
        String regx1 = "(\\d)?(\\.)?";
        //checking for the operators with regx2
        String regx2 = "(\\+)?(\\-)?(\\*)?(\\/)?";
        if (input.equals("=")) {
            checkBuilder = new BigInteger(builder);
            int checkmax = checkBuilder.compareTo(intMax);
            int checkmin = checkBuilder.compareTo(intmin);
            if (checkmax <= 0 && checkmin >= 0) {
                System.out.println("check 1");
                currentValue = Integer.parseInt(builder);
                if (currentValue != 0 && storedValue != 0) {
                    System.out.println("check 2");
                    switch (operator) {
                        case "+":
                            add(currentValue, storedValue);
                            break;
                        case "-":
                            subtr(currentValue, storedValue);
                            break;
                        case "*":
                            multiply(currentValue, storedValue);
                            break;
                        case "/":
                            devide(currentValue, storedValue);
                            break;
                        default:
                            error(99);
                    }
                }
            } else {
                error(2);
            }
        } else if (input.matches(regx1)) {
            if (prevAnswer != 0) {
                storedValue = prevAnswer;
            }
            if (builder.equals("0")) {
                builder = input;
                update();
            } else {
                builder = builder + input;
                update();
            }
        } else if (input.matches(regx2)) {
            operator = input;
            checkBuilder = new BigInteger(builder);
            int checkmax = checkBuilder.compareTo(intMax);
            int checkmin = checkBuilder.compareTo(intmin);
            if (checkmax <= 0 && checkmin >= 0) {
                storedValue = Integer.parseInt(builder);
                builder = "0";
            }else{
                error(2);
            }
        }

    }

    /**
     * sends an update to the screen when ever a number is added.
     */
    private void update() {
        String send[] = new String[2];
        send[1] = builder;
        send[0] = Integer.toString(storedValue);
        output.stored(send);
    }

    /**
     * default method, must be implemented due to Interface.
     *
     * @param output
     */
    @Override
    public void stored(String[] output) {
        //empty
    }
}
