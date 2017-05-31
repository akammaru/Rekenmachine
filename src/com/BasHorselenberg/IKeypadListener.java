package com.BasHorselenberg;

/**
 * Created by Bas_Horselenberg on 22-5-2017.
 * this interface will be the connection between the keypad and the rest of the program. This class will rout through main.
 */
public interface IKeypadListener {
    void listenKey(String keypadString);
}
