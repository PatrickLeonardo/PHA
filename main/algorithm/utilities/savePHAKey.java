package main.algorithm.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>
 * The {@code savePHAKey} class is a class for save the PHAKey in a text file with the encoded key.
 * This class is used only to handle with the encoded key file creation.
 * </p>
 */
public class savePHAKey {
    
    protected static void encodedPHAKey(){}

    /**
     * These method is used for write encoded key automatic in a text file. Example:
     * <blockquote><pre>
     *      savePHAKey.writeEncodedKey(encodedKey);
     * </blockquote></pre>
     * @param encodedKey
     */
    public static void writeEncodedKey(String encodedKey) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("encodedKey.txt"));
            bufferedWriter.write(encodedKey);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}