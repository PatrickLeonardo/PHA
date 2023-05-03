package test.main.algorithm.key;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class SubBytesTest {
    
    String PHAKey = "00000000 00111110 01000100 01001000 00111110 01000100 01001000 01001010 01000100 01001000 01001010 01001100 01001000 01001010 01001100 01001110 ";

    private static int[] StringMatrixToInteger(String matrix) {
        
        String[] stringMatrix;
        stringMatrix = matrix.split(" ");
        int[] integerMatrix = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for(int index = 0; index < stringMatrix.length; index++){
            try {
                integerMatrix[index] = Byte.parseByte(stringMatrix[index], 2);
            } catch (NumberFormatException e) {
                integerMatrix[index] ++;
            }
        }

        return integerMatrix;

    }

    public int[] generateRoundKey() {

        int[] integerMatrix = StringMatrixToInteger(PHAKey);
        int[] roundedMatrix = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        String inverseIntegerMatrixString = "";
        for(int index = 15; index >= 0; --index) inverseIntegerMatrixString += integerMatrix[index] + " ";
        
        String[] inverseIntegerMatrixArray = inverseIntegerMatrixString.split(" ");
        for(int index = 0; index <= 15; index++)  roundedMatrix[index] = Integer.valueOf(inverseIntegerMatrixArray[index]);

        return roundedMatrix;
    }

    @Test
    public void StringMatrixToIntegerTest(){
        
        int[] integerMatrix = StringMatrixToInteger(PHAKey);
        assertEquals(0, integerMatrix[0]);

    }

    @Test
    public void generateRoundKeyTest(){

        int[] roudedIntegerMatrix = generateRoundKey();
        assertEquals(78, roudedIntegerMatrix[0]);

    }

}