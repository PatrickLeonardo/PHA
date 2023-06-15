package main;

import main.algorithm.key.PHAKeyCipher;
import main.algorithm.utilities.savePHAKey;

public class MainExecution {
    public static void main(String[] args) {
    
        savePHAKey.writeEncodedKey(PHAKeyCipher.createPHAKey(9));

    }
}