package main.algorithm.key;

import main.algorithm.utilities.bitManager;
import main.hash.HashEqualityProbability;

public class PHAKeyCipher {

    protected static String PHAKey;
    private final static Integer POW_PREFIX = 1024;
    private static Long POW_SUFIX;

    public static String createPHAKey(final Integer prefix){

        POW_SUFIX = (long)Math.pow(10, (String.valueOf(prefix).length()) - 1);
        
        try {
            int prefixHashCode = prefix.hashCode();
            double probability = new HashEqualityProbability().getProbability(prefixHashCode);
            
            if (probability >= 2){
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
           exception.printStackTrace();
        }

        byte[][][] matrix = {
            { {0x00}, {0x00}, {0x00}, {0x00} },
            { {0x00}, {0x00}, {0x00}, {0x00} },
            { {0x00}, {0x00}, {0x00}, {0x00} },
            { {0x00}, {0x00}, {0x00}, {0x00} }
        };

        for(int line = 0; line < 4; line++){
            for(int column = 0; column < 4; column++){
                
                matrix[line][column][0] = (byte)Math.log(Math.pow((POW_PREFIX * (line + column)), prefix / POW_SUFIX));
                if (Double.isNaN(matrix[line][column][0]) || Double.isInfinite(matrix[line][column][0])){
                    throw new java.lang.ArithmeticException();
                }
                if (String.valueOf(matrix[line][column][0]) != "null"){
                    PHAKey += bitManager.byteToBit(matrix[line][column][0]) + " ";
                }
            
            }
        }

        PHAKey = PHAKey.replaceAll("null", "");
        //PHAKey = PHAKey.replaceAll("\\.", "");
    
        SubBytes subBytes = new SubBytes(PHAKey);
        PHAKey = subBytes.generateRoundKey();

        return PHAKey;
    }

    public static void defineKeySpec(){ }

}