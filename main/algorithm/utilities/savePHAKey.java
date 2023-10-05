package main.algorithm.utilities;

import main.algorithm.key.CreateHash;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 * The {@code savePHAKey} class is a class for save the PHAKey in a text file with the encoded key.
 * This class is used only to handle with the encoded key file creation.
 * </p>
 */
public class savePHAKey {

    /**
     * These method is used for write encoded key automatic in a text file. Example:
     * <blockquote><pre>
     *      savePHAKey.writeEncodedKey(encodedKey);
     * </blockquote></pre>
     * @param Key String The encoded key object.
     * @throws IOException
     */
    public static boolean writeEncodedKey(String Key) throws IOException {

        String stringKey = new String(Key);
        String encodedKey = CreateHash.mountUnicodeInPHAKey(stringKey);
    
        byte[] key = new byte[encodedKey.length() * 2];
        for (int index = 0; index < encodedKey.length(); index++){
            char c = encodedKey.charAt(index);
            key[index * 2] = (byte) (c >> 8);
            key[index * 2 + 1] = (byte) c;
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream("encodedKey.jks")) {
            fileOutputStream.write(key);
            fileOutputStream.close();
        }

        return true;
        
    }

}