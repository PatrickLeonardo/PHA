package main.algorithm.keys;

import main.hash.HashEqualityProbability;

public class KeyPairs {

    public static void createPHAKey(final Integer prefix){

        try {
            int prefixHashCode = prefix.hashCode();
            double probability = new HashEqualityProbability().getProbability(prefixHashCode);
            
            if (probability >= 1){
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
           exception.printStackTrace();
        }

        double[][][] matrix = {
            { {0}, {1}, {2}, {3} },
            { {4}, {5}, {6}, {7} },
            { {8}, {9}, {10}, {11} },
            { {12}, {13}, {14}, {15} }
        };

        for(int line = 0; line < 4; line++){
            for(int column = 0; column < 4; column++){
                matrix[line][column][0] = Math.log(Math.pow(line, prefix) + 3);
                if (Double.isNaN(matrix[line][column][0]) || Double.isInfinite(matrix[line][column][0])){
                    throw new java.lang.ArithmeticException();
                }
                System.out.println("| " + matrix[line][column][0] + " |");
            }
        }

    }

    public static void defineKeySpec(){ }

}