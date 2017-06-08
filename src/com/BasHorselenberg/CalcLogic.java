package com.BasHorselenberg;

/**
 * @author Bas_Horselenberg
 * this class will hold all the logic for the calculator and will be responsible for the acctual math.
 */
public class CalcLogic implements IKeypadListener{

    // basic vatiables for storage. to use in actual calculations.
    private int currentValue;
    private int storedValue;

    // creating new interface instance for return to  keypad.
    private IKeypadListener result;

    /**
     * General constructor for CalcLogic class.
     */
    public CalcLogic() {

    }

    /**
     * interface  needs this method to be pressend. its used in other ways.
     * @param keypadArray array with variables to passe
     */
    @Override
    public void listenKey(String[] keypadArray) {
        //nothing
    }

    /**
     * retrieves the data, converts it to useable data types and stores it in a local variables.
     *
     * @param data an array with 3 vaules. the first and second String, containing an Int. the 3rd string contains a char for the operator.
     */
    public void getData(String[] data){
        int data0 = Integer.parseInt(data[0]);
        int data1 = Integer.parseInt(data[1]);
        char data2 = 'x';
        if(data[2].charAt(0) != 'x'){
            data2 = data[2].charAt(0);
        }else{
            data2 = '+';
        }
        currentValue = data1;
        storedValue = data0;

        System.out.println("First value " + data0 + ". \nSecond Value " + data1 + ". \nOperator: " + data2);

        switch(data2){
            case '+':
                add(currentValue, storedValue);
                break;
            case '-':
                subtr(currentValue, storedValue);
                break;
            case '*':
                multiply(currentValue, storedValue);
                break;
            case '/':
                devide(currentValue, storedValue);
                break;
            default:
                error(99);

        }
    }

    /**
     * data connection to Frame to Screen.
     * @param result array with 2 Strings for printing on screen.
     */
    public void setLogicListener(IKeypadListener result){ this.result = result; }

    /**
     * output for correct data
     * @param answer calcualated answer
     * @param operator operator
     */
    public void setResult(int answer, String operator){
        String sum = currentValue + " " + operator + " " + storedValue + " =";
        String localResult = Integer.toString(answer);
        String[] send = new String[2];
        send[0] = sum;
        send[1] = localResult;
        result.listenKey(send);
    }

    /**
     * error message output
     * @param mssg
     */
    public void setResult(String mssg){
        String sum = currentValue + " + " + storedValue + " =";
        String[] send = new String[2];
        send[0] = sum;
        send[1] = mssg;
        result.listenKey(send);
    }

    /**
     * add calculation.
     * @param num1 first int to be added.
     * @param num2 second int to be added.
     */
    private void add(int num1, int num2){
        int localResult = num1 + num2;
        setResult(localResult, "+");
    }

    /**
     * subtractin calculation.
     * @param num1 first int, will be subtracted from.
     * @param num2 second int, this is the ammount that will be subtracted.
     */
    private void subtr(int num1,int num2){
        int localResult = num1 - num2;
        setResult(localResult, "-");
    }

    /**
     * multiply calculation.
     * @param num1 int to be multiplied.
     * @param num2 the ammount num1 will be multiplied.
     */
    private void multiply(int num1,int num2){
        int localResult = num1 * num2;
        setResult(localResult, "x");
    }

    /**
     * devide calculation.
     * @param num1 number to be devided.
     * @param num2 number num1 will be devided by.
     */
    private void devide(int num1,int num2){
        int localResult = num1 / num2;
        setResult(localResult, "/");
    }

    private void error(int errormssg){
        String mssg;
        switch(errormssg){

            default:
                mssg = "Default error message";
                break;
        }
    }

}
