package main;

import main.algorithm.keys.PHAKeyCipher;
import main.algorithm.utilities.bitManager;

public class MainExecution {
    public static void main(String[] args) {
        
        System.out.println("\n" + PHAKeyCipher.createPHAKey(9) + "\n");
        bitManager.byteToBit((byte) 9);

    }
}