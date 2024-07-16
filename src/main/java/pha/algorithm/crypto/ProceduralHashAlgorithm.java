package pha.algorithm.crypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;

public class ProceduralHashAlgorithm {

    public static String encryptData(final File publicKeyFile, final String input_data) throws InvalidKeyException, IOException {
        
        try {
            new ValidKey(publicKeyFile).validator(); 
        } catch (final InvalidKeyException exception) {
            System.out.println("\n|  Invalid Key...");
        } catch (final FileNotFoundException exception) {
            System.out.println("\n|  Key File not found...");
        }
         
        return ""; 

    }

    public static String decryptData(final File privateKeyFile, final String hash) throws InvalidKeyException, IOException {

        try {
            new ValidKey(privateKeyFile).validator();
        } catch (final InvalidKeyException exception) {
            System.out.println("\n|  Invalid Key...");
        } catch (final FileNotFoundException exception) {
            System.out.println("\n|  Key File not found...");
        }

        return "";

    }

}
