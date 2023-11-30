package pha;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import pha.algorithm.key.PHAKeyCipher;

public class MainExecution {
    public static void main(String[] args) throws IOException {
       
        File publicKeyFile = new File("publicKeyFile.jks");
        File privateKeyFile = new File("privateKeyFile.jks");
          
        try {
            publicKeyFile.createNewFile();
            privateKeyFile.createNewFile();
        }
        catch(IOException ioException) {
            ioException.printStackTrace();
        }

        PHAKeyCipher.createPHAKeys(publicKeyFile, privateKeyFile);
        
        BufferedReader bfPublicKey = new BufferedReader(new FileReader(publicKeyFile));
        BufferedReader bfPrivateKey = new BufferedReader(new FileReader(privateKeyFile));

        bfPublicKey.close();
        bfPrivateKey.close();
    
    }
    
}
