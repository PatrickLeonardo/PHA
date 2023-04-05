package main;

import main.algorithm.keys.PHAKey;
import main.algorithm.utilities.bitManager;

public class MainExecution {
    public static void main(String[] args) {
        
        System.out.println("\n" + PHAKey.createPHAKey(4));
        bitManager.byteToBit((byte) 9);

    }
}