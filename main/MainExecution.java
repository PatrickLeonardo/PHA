package main;

import main.algorithm.keys.KeyPairs;
import main.algorithm.utilities.bitManager;

public class MainExecution {
    public static void main(String[] args) {
        
        System.out.println("\n" + KeyPairs.createPHAKey(4) + "\n");
        bitManager.byteToBit((byte) 9);

    }
}