package pha.algorithm.key; 

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

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
    public static boolean createKeyPair(final File publicKeyFile, final File privateKeyFile) throws IOException {
        
        final StringBuilder publicKeyHash = createPublicKey();
        final StringBuilder privateKeyHash = createPrivateKey();

        // Reverse key
        // publicKeyHash = new SubBytes(publicKeyHash).generateInvertedKey();
        // privateKeyHash = new SubBytes(privateKeyHash).generateInvertedKey();
        
        final String publicKey = publicKeyHash.toString();
        final String privateKey = privateKeyHash.toString();

        // Save the key
        if(savePHAKey.writeKeyPair(publicKeyFile, privateKeyFile, publicKey, privateKey)){
            System.out.println("\n| Public and Private Key are created with successfull");
        }

        return true;
    }

    public static StringBuilder mountHexPHAKey(final String PHAKey){
    
        final String PHAKeyArray[] = PHAKey.split(" ");

        final StringBuilder PHAKeyHash = new StringBuilder();

        for(int byteIndex = 0; byteIndex < PHAKeyArray.length; byteIndex++) {
            
            final String[] randomValue = generatePseudoNumberRamdom();            
            final String hexValue = "0x" + String.valueOf(new BigInteger(randomValue[0]).toString(16));

            PHAKeyHash.append(hexValue);
        }
        
        return PHAKeyHash;
    }

    public static String[] generatePseudoNumberRamdom() {
        
        final StringBuilder resultBuilder = new StringBuilder();
        final SecureRandom r = new SecureRandom();
        BigInteger p, q, n, m, e, d;

        for(int index = 0; index < 8; index++) {

            try {
                
                p = new BigInteger(256 / 2, 1000, r);
                q = new BigInteger(256 / 2, 1000, r);
                n = q.multiply(p);
                m = n.gcd(q).subtract(p).add(BigInteger.ONE);
                e = new BigInteger("256");
                d = e.modInverse(m.abs());
                
                resultBuilder.append(d);
                resultBuilder.append(" ");

            } catch(final ArithmeticException exception) {
                exception.printStackTrace();
            }

        }
        
        return resultBuilder.toString().split(" ");
        
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

}
