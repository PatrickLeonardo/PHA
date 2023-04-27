package main.algorithm.keys;

import main.algorithm.utilities.bitManager;
import main.hash.HashEqualityProbability;

public class PHAKeyCipher {

    protected static String PHAKey;
    private final static Integer POW_PREFIX = 1024;

    public static String createPHAKey(final Integer prefix){

        try {
            int prefixHashCode = prefix.hashCode();
            double probability = new HashEqualityProbability().getProbability(prefixHashCode);
            
            if (probability >= 1){
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
           exception.printStackTrace();
        }

        byte[][][] matrix = {
            { {00000000}, {00000000}, {00000000}, {00000000} },
            { {00000000}, {00000000}, {00000000}, {00000000} },
            { {00000000}, {00000000}, {00000000}, {00000000} },
            { {00000000}, {00000000}, {00000000}, {00000000} }
        };

        for(int line = 0; line < 4; line++){
            for(int column = 0; column < 4; column++){
                
                matrix[line][column][0] = (byte)Math.log(Math.pow((POW_PREFIX * (line + column) + prefix), prefix));
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
        subBytes.generateRoundKey();

        return PHAKey;
    }

    public static void defineKeySpec(){ }

}