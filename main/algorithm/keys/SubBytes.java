package main.algorithm.keys;

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
            integerMatrix[index] = Byte.parseByte(stringMatrix[index], 2);
        }

        return integerMatrix;

    }

    public void generateRoundKey() {

        int[] integerMatrix = StringMatrixToInteger(PHAKey);
        for(int index : integerMatrix) System.out.print(index + " ");

    }
    
}