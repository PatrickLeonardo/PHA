package main;

import main.algorithm.key.PHAKeyCipher;

public class MainExecution {
    public static void main(String[] args) {

        PHAKeyCipher.createPHAKey(9);
        
        // int line          = 0;
        // int column        = 1;
        // int prefix        = 9;
        // int prefix_length = String.valueOf(prefix).length(); // 1
        // int POW_PREFIX    = 1024;
        // int POW_SUFIX     = (int) Math.pow(10, prefix_length - 1); // 0
        // int value         = (int) Math.log10( Math.pow( ( POW_PREFIX * (line + column) ), prefix / POW_SUFIX )); // 27
        // System.out.println(value);

    }
}