package com.BasHorselenberg;

/**
 * @author Bas_Horselenberg
 * this interface will be the connection between the keypad and the rest of the program. This class will rout through main.
 */
public interface IKeypadListener {
    void listenKey(String keypadValue);
}
