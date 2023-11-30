package pha.algorithm.key;

import java.io.IOException;
import java.io.File;

import pha.algorithm.utilities.bitManager;
import pha.algorithm.utilities.savePHAKey;

/**
 * <p>{@code PHAKeyCipher} is the class in which part of the cipher for the encryption key is made, it is also used to create the key and perform its assembly. </p>
 */
public class PHAKeyCipher {

    public static StringBuilder PHAKey = new StringBuilder();
    private final static Integer POW_PREFIX = 1024;
    protected static Long POW_SUFFIX;

    /**
     * <p>Method used for create the encode key.</p>
     * <p>This key is used for encode and decode any message.</p>
     * @param prefix Integer Value for prefix.
     * @throws IOException
     */
    public static boolean createPHAKeys(File publicKeyFile, File privateKeyFile) throws IOException {

        // Suffix of square root
        POW_SUFFIX = (long)Math.pow(10, (0x00));

        byte[][][] matrix = KeyEnum.MATRIX.getValue();

        // Mouting indexes of the key
        for(int line = 0; line < 4; line++) {
            for(int column = 0; column < 4; column++) {
                
                matrix[line][column][0] = (byte)Math.log10(Math.pow((POW_PREFIX * (line + column)), POW_SUFFIX));
                if (Double.isInfinite(matrix[line][column][0])){
                    throw new java.lang.ArithmeticException();
                }
                if (!String.valueOf(matrix[line][column][0]).equals("null")) {
                    PHAKey.append(bitManager.byteToBit(matrix[line][column][0])).append(" ");
                }
                
            }
        }
        
        // Reverse key
        PHAKey = new SubBytes(PHAKey).generateInvertedKey();
        
        String encodedKey = PHAKey.substring(0, PHAKey.length() - 1);

        String encodedHashedKey = CreateHash.mountHexPHAKey(encodedKey);

        // Save the key
        savePHAKey.writeEncodedKey(publicKeyFile, privateKeyFile, encodedHashedKey);

        return true;
    }
    
}
