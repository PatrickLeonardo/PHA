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
    
    protected static StringBuilder PHAKey = new StringBuilder();
    private final static Integer POW_PREFIX = 1024;
    protected static Long POW_SUFFIX;

    public static StringBuilder createPHAKey(final Integer prefix){

        POW_SUFFIX = (long)Math.pow(10, (String.valueOf(prefix).length()) - 1);
        
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
            { {0x0}, {0x0}, {0x0}, {0x0} },
            { {0x0}, {0x0}, {0x0}, {0x0} },
            { {0x0}, {0x0}, {0x0}, {0x0} },
            { {0x0}, {0x0}, {0x0}, {0x0} }
        };

        for(int line = 0; line < 4; line++){
            for(int column = 0; column < 4; column++){
                
                matrix[line][column][0] = (byte)Math.log(Math.pow((POW_PREFIX * (line + column)), prefix.doubleValue() / POW_SUFFIX));
                if (Double.isInfinite(matrix[line][column][0])){
                    throw new java.lang.ArithmeticException();
                }
                if (!String.valueOf(matrix[line][column][0]).equals("null")) {
                    PHAKey.append(bitManager.byteToBit(matrix[line][column][0])).append(" ");
                }
            
            }
        }

        SubBytes subBytes = new SubBytes(PHAKey);
        subBytes.generateInvertedKey();

        return PHAKey;
    }

    public void defineKeySpecTest(){ }

    @Test
    public void PHAKeyTest(){

        String PHAKey = String.valueOf(PHAKeyCipherTest.createPHAKey(9));
        String expected = "00000000 00111110 01000100 01001000 00111110 01000100 01001000 01001010 01000100 01001000 01001010 01001100 01001000 01001010 01001100 01001110 ";
        assertEquals(expected, PHAKey);

    }

}