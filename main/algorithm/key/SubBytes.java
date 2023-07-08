package main.algorithm.key;

import main.algorithm.utilities.bitManager;

/**
 * <p>The {@code SubBytes} class is inspired by the SubBytes method of AES encoding
 * In which operations and value management are performed to obtain appropriate results for coding security and byte inversion.
 */
public class SubBytes {
    
    protected StringBuilder PHAKey;

    public SubBytes(StringBuilder PHAKey) {
        this.PHAKey = PHAKey;
    }

    /**
     * <p>This method is used only to transform the String matrix into an Integer matrix.</p>
     * @return int[] Representation of the String matrix in the Integer matrix.
     */
    private int[] StringMatrixToInteger(StringBuilder matrix) {

        String[] stringMatrix;
        stringMatrix = matrix.toString().split(" ");
        int[] integerMatrix = {
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
        };

        for(int index = 0; index < stringMatrix.length; ++index) {
            try {
                integerMatrix[index] = Byte.parseByte(stringMatrix[index], 2);
            } catch (NumberFormatException NumberFormatException) {
                NumberFormatException.printStackTrace();
            }
        }

        return integerMatrix;

    }

    /**
     * <p>Is used for generate the rotation of the key (in integer matrix).
     * This is make with the inversion of the values, utilizing loops.
     * @return String Inverted key.
     */
    public StringBuilder generateInvertedKey() {

        int[] integerMatrix = StringMatrixToInteger(PHAKey);
        int[] roundedMatrix = {
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00
        };
        StringBuilder roudedPHAKey = new StringBuilder();

        StringBuilder inverseIntegerMatrixString = new StringBuilder();
        for(int index = 15; index >= 0x00; --index) {
            inverseIntegerMatrixString.append(integerMatrix[index]).append(" ");
        }

        String[] inverseIntegerMatrixArray = inverseIntegerMatrixString.toString().split(" ");
        for(int index = 0; index <= 15; index++) {
            roundedMatrix[index] = Integer.parseInt(inverseIntegerMatrixArray[index]);
            roudedPHAKey.append(bitManager.byteToBit((byte)roundedMatrix[index])).append(" ");
        }

        return roudedPHAKey;
    }

}