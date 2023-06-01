package main.algorithm.key;

import main.algorithm.utilities.bitManager;

public class SubBytes {
    
    protected String PHAKey;

    public SubBytes(String PHAKey) {
        this.PHAKey = PHAKey;
    }

    private int[] StringMatrixToInteger(String matrix) {
        
        String[] stringMatrix;
        stringMatrix = matrix.split(" ");
        int[] integerMatrix = {
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            
        };

        for(int index = 0; index < stringMatrix.length; index++) {
            try {
                integerMatrix[index] = Byte.parseByte(stringMatrix[index], 2);
            } catch (NumberFormatException e) {
                integerMatrix[index] ++;
            }
        }

        return integerMatrix;

    }

    public String generateRoundKey() {

        int[] integerMatrix = StringMatrixToInteger(PHAKey);
        int[] roundedMatrix = {
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00
        };
        String roudedPHAKey = "";

        String inverseIntegerMatrixString = "";
        for(int index = 15; index >= 0x00; --index) {
            inverseIntegerMatrixString += integerMatrix[index] + " ";
        }

        String[] inverseIntegerMatrixArray = inverseIntegerMatrixString.split(" ");
        for(int index = 0; index <= 15; index++) {
            roundedMatrix[index] = Integer.valueOf(inverseIntegerMatrixArray[index]);
            roudedPHAKey += bitManager.byteToBit((byte)roundedMatrix[index]) + " ";
        }

        return roudedPHAKey;
    }

}