package pha.algorithm.key; 

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

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
    private static String[] randomValues;

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

    private static StringBuilder createPublicKey() {
         
        final StringBuilder encodedPublicKey = new StringBuilder().append(mountHexPHAKey("public"));
        
        return encodedPublicKey;

    }

    private static StringBuilder createPrivateKey() {
        
        final StringBuilder encodedPrivateKey = new StringBuilder().append(mountHexPHAKey("private"));
        
        return encodedPrivateKey;

    }

    public static StringBuilder mountHexPHAKey(final String type){
        

        final Integer sizeOfKey = (type == "private") ? 64 : 64;

        final StringBuilder PHAKeyHash = new StringBuilder();

        PHAKeyHash.append("0x");

        for(int byteIndex = 0; byteIndex < sizeOfKey; byteIndex++) {
            
            randomValues = generatePseudoNumberRamdom();            
            final String hexValue = String.valueOf(new BigInteger(randomValues[0]).toString(16));

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

}
