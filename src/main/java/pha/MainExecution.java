package pha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import pha.algorithm.key.PHAKeyCipher;

public class MainExecution {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(final String[] args) throws IOException {

        final File publicKeyFile = new File("publicKeyFile.jks");
        final File privateKeyFile = new File("privateKeyFile.jks");

        try {
            publicKeyFile.createNewFile();
            privateKeyFile.createNewFile();
        } catch (final IOException ioException) {
            ioException.printStackTrace();
        }

        PHAKeyCipher.createKeyPair(publicKeyFile, privateKeyFile);

        final BufferedReader bfPublicKey = new BufferedReader(new FileReader(publicKeyFile));
        final BufferedReader bfPrivateKey = new BufferedReader(new FileReader(privateKeyFile));

        bfPublicKey.close();
        bfPrivateKey.close();

    }

}
