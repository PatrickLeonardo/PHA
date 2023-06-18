package test.main.algorithm.key;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import main.algorithm.key.SubBytes;
import main.algorithm.utilities.bitManager;
import main.hash.HashEqualityProbability;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class PHAKeyCipherTest {
    
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
            { {00000000}, {00000000}, {00000000}, {00000000} },
            { {00000000}, {00000000}, {00000000}, {00000000} },
            { {00000000}, {00000000}, {00000000}, {00000000} },
            { {00000000}, {00000000}, {00000000}, {00000000} }
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
        subBytes.generateInvertedKey();

        return PHAKey;
    }

    public void defineKeySpecTest(){ }

    @Test
    public void PHAKeyTest(){

        String PHAKey = PHAKeyCipherTest.createPHAKey(9);
        String expected = "00000000 00111110 01000100 01001000 00111110 01000100 01001000 01001010 01000100 01001000 01001010 01001100 01001000 01001010 01001100 01001110 ";
        assertEquals(expected, PHAKey);

    }

}