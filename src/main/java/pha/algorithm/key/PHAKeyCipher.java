package pha.algorithm.key;

import java.io.IOException;

import pha.algorithm.utilities.bitManager;
import pha.algorithm.utilities.savePHAKey;
import pha.hash.HashEqualityProbability;

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
    public static boolean createPHAKey(final Integer prefix) throws IOException {

        // verify prefix
        try {
            int prefixHashCode = prefix.hashCode();
            double probability = new HashEqualityProbability().getProbability(prefixHashCode);
            
            if (probability >= 2){
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
           exception.printStackTrace();
        }

        // suffix of square root
        POW_SUFFIX = (long)Math.pow(10, (String.valueOf(prefix).length()) - 1);

        byte[][][] matrix = KeyEnum.MATRIX.getValue();

        // mouting indexes of the key
        for(int line = 0; line < 4; line++){
            for(int column = 0; column < 4; column++){
                
                matrix[line][column][0] = (byte)Math.log10(Math.pow((POW_PREFIX * (line + column)), prefix.doubleValue() / POW_SUFFIX));
                if (Double.isInfinite(matrix[line][column][0])){
                    throw new java.lang.ArithmeticException();
                }
                if (!String.valueOf(matrix[line][column][0]).equals("null")) {
                    PHAKey.append(bitManager.byteToBit(matrix[line][column][0])).append(" ");
                }

            }
        }
    
        // reverse key
        PHAKey = new SubBytes(PHAKey).generateInvertedKey();
 
        String encodedKey = PHAKey.substring(0, PHAKey.length() - 1);

        String encodedHashedKey = CreateHash.mountHexPHAKey(encodedKey, prefix);

        // save the key
        savePHAKey.writeEncodedKey(encodedHashedKey);

        return true;
    }

}
