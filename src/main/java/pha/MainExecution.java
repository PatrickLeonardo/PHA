package pha;

import java.io.IOException;

import pha.algorithm.key.PHAKeyCipher;

public class MainExecution {
    public static void main(String[] args) throws IOException {
       
        // Create pha key with a prefix (9)
        PHAKeyCipher.createPHAKey(9);
       
    }

}
