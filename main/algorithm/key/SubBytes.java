package main.algorithm.key;

public class SubBytes {
    
    String PHAKey;

    public SubBytes(String PHAKey){
        this.PHAKey = PHAKey;
    }

    private int[] StringMatrixToInteger(String matrix) {
        
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

}