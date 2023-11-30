package pha.algorithm.utilities;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
    import java.io.File;

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
    public static boolean writeEncodedKey(File publicKeyFile, File privateKeyFile, String Key) throws IOException {

        try (OutputStream fileOutputStream = new FileOutputStream("encodedKey.jks")) {
            Writer writer = new OutputStreamWriter(fileOutputStream);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(Key);
            buffer.close();
            fileOutputStream.close();
        }

        return true;
        
    }

}
