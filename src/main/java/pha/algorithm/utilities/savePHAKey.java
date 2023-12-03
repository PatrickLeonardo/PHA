package pha.algorithm.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * <p>
 * The {@code savePHAKey} class is a class for save the PHAKey in a text file with the encoded key.
 * This class is used only to handle with the encoded key file creation.
 * </p>
 */
public class savePHAKey {

    /**
     * These method is used for write encoded keys automatic in a file. Example:
     * <blockquote><pre>
     *     savePHAKey.writeKeyPair(publicKeyFile, privateKeyFile, "public key", "private key"); 
     * </blockquote></pre>
     * @param publicKeyFile A File for write the public key.
     * @param privateKeyFile A File for write the private key.
     * @param publicKey A String of public key.
     * @param privateKey A String of private key.<br>
     * @throws IOException
     */
    public static boolean writeKeyPair(final File publicKeyFile, final File privateKeyFile, final String publicKey, final String privateKey) throws IOException {

        try (OutputStream publicKeyFileOutputStream = new FileOutputStream(publicKeyFile)) {
            
            final Writer writer = new OutputStreamWriter(publicKeyFileOutputStream);
            final BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(publicKey);
            buffer.close();
            publicKeyFileOutputStream.close();
        
        } catch (final IOException e) {
            e.printStackTrace();
        }

        try (OutputStream privateKeyFileOutputStream = new FileOutputStream(privateKeyFile)) {
            
            final Writer writer = new OutputStreamWriter(privateKeyFileOutputStream);
            final BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(privateKey);
            buffer.close();
            privateKeyFileOutputStream.close();

        } catch (final IOException e) {
            e.printStackTrace();
        }
        
        return true;
        
    }

}
