package pha.algorithm.key;

import java.io.File;
import java.io.IOException;

import pha.algorithm.utilities.bitManager;
import pha.algorithm.utilities.savePHAKey;

/**
 * <p>
 * {@code PHAKeyCipher} is the class in which part of the cipher for the
 * encryption key is made, it is also used to create the key and perform its
 * assembly.
 * </p>
 */
public class PHAKeyCipher {

    public static StringBuilder PHAKey = new StringBuilder();

    /**
     * <p>
     * Method used for create the encode keys.<br>
     * This keys are used for encode and decode any message.
     * </p>
     * 
     * @param publicKeyFile  for the write of the public key in file.
     * @param privateKeyFile for the write of the private key in file.<br>
     * @throws IOException
     */
    public static boolean createPHAKeys(final File publicKeyFile, final File privateKeyFile) throws IOException {

        final byte[][][] matrix = KeyEnum.MATRIX.getValue();

        // Mouting indexes of the key
        for (int line = 0; line < 4; line++) {
            for (int column = 0; column < 4; column++) {

                matrix[line][column][0] = 0x00;
                if (Double.isInfinite(matrix[line][column][0])) {
                    throw new java.lang.ArithmeticException();
                }
                if (!String.valueOf(matrix[line][column][0]).equals("null")) {
                    PHAKey.append(bitManager.byteToBit(matrix[line][column][0])).append(" ");
                }

                PHAKey.delete(PHAKey.length() - 1, PHAKey.length());

            }
        }

        // Reverse key
        PHAKey = new SubBytes(PHAKey).generateInvertedKey();

        final String encodedHashedPHAKey = CreateHash.mountHexPHAKey(PHAKey.toString());

        // Save the key
        savePHAKey.writeKeyPair(publicKeyFile, privateKeyFile, encodedHashedPHAKey, encodedHashedPHAKey);

        return true;
    }

}
