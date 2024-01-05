package pha.algorithm.key; 

import java.io.File;
import java.io.IOException;

import pha.algorithm.utilities.bitManager;
import pha.algorithm.utilities.savePHAKey;

import java.util.Random;

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
    public static boolean createKeyPair(final File publicKeyFile, final File privateKeyFile) throws IOException {
        
        StringBuilder publicKeyHash = createPublicKey();
        StringBuilder privateKeyHash = createPrivateKey();

        // Reverse key
        // publicKeyHash = new SubBytes(publicKeyHash).generateInvertedKey();
        // privateKeyHash = new SubBytes(privateKeyHash).generateInvertedKey();
        
        String publicKey = publicKeyHash.toString();
        String privateKey = privateKeyHash.toString();

        // Save the key
            savePHAKey.writeKeyPair(publicKeyFile, privateKeyFile, publicKey, privateKey);

        return true;
    }

    private static StringBuilder createPublicKey() {
      
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
                
                //PHAKey.delete(PHAKey.length() - 1, PHAKey.length());

            }
        }
        
        final StringBuilder encodedPublicKey = new StringBuilder().append(mountHexPHAKey(PHAKey.toString()));
        
        return encodedPublicKey;

    }

    private static StringBuilder createPrivateKey() {

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
                
                //PHAKey.delete(PHAKey.length() - 1, PHAKey.length());

            }
        }
        
        final StringBuilder encodedPrivateKey = new StringBuilder().append(mountHexPHAKey(PHAKey.toString()));
        
        return encodedPrivateKey;

    }

    public static StringBuilder mountHexPHAKey(final String PHAKey){
    
        final String PHAKeyArray[] = PHAKey.split(" ");

        final StringBuilder PHAKeyHash = new StringBuilder();

        for(int byteIndex = 0; byteIndex < PHAKeyArray.length; byteIndex++) {

            final int intValue = Integer.parseInt(PHAKeyArray[byteIndex], 2);
            
            final String[] randomValue = generatePseudoNumberRamdom(1, intValue, 1000, new Random().nextInt(intValue + 8 ^ 256), 1);
            
            final String hexValue = "0x" + Integer.toHexString(Integer.valueOf(randomValue[0]));

            PHAKeyHash.append(hexValue);
        }
        
        return PHAKeyHash;
    }

    public static String[] generatePseudoNumberRamdom(final int inital, int modulas, final int multiplier, final int random, final int total) {
        
        modulas += 100;

        final StringBuilder resultBuilder = new StringBuilder();

        for(int index = 0; index < total; index++) {
            
            int pre_value, value = 0;

            try {
                pre_value = ((inital * multiplier) * random) % modulas;
                value = pre_value ^ random + modulas;
            } catch(final ArithmeticException exception) {
                exception.printStackTrace();
            } finally {
                resultBuilder.append(value);
                resultBuilder.append(" ");
            }

        }
         
        return resultBuilder.toString().split(" ");
        
    }

}
