package main;

import main.algorithm.keys.KeyPairs;
import main.algorithm.utilities.bitManager;

public class MainExecution {
    public static void main(String[] args) {
        
        KeyPairs.createPHAKey(4);
        bitManager.byteToBit((byte) 9);

    }
}