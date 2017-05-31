package com.BasHorselenberg;

/**
 * Created by Bas_Horselenberg on 22-5-2017.
 * this class will hold all the logic for the calculator and will be responsible for the acctual math.
 */
public class CalcLogic {

    private String string1;
    private char operator;
    private String string2;

    /**
     * General constructor for CalcLogic class.
     */
    public CalcLogic() {
        string1 = "0";
        string2 = "0";
    }


    public void addCharacter(String input) {
        String regx1 = "(\\d)?(\\.)?";
        String regx2 = "(\\+)?(\\-)?(\\*)?(\\/)?";
        if (input.matches(regx1)) {
            if (string1.equals("0")) {
                string1 = input;
            } else {
                string1 = string1 + input;
            }
        } else if (input.matches(regx2)) {
            operator = input.charAt(0);
            string2 = string1;
            string1 = "0";
        }
        System.out.println(string1);
        System.out.println(operator);
        System.out.println(string2);
    }
}
