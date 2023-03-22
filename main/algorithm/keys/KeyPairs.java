package main.algorithm.keys;

import main.hash.HashEqualityProbability;

public class KeyPairs {

    public static void createPHAKey(final Integer prefix){

        try {
            int prefixHashCode = prefix.hashCode();
            double probability = new HashEqualityProbability().getProbability(prefixHashCode);
            System.out.println(probability);
            if (probability >= 1){
                throw new IllegalArgumentException();
            };
        } catch (Exception exception) {
           exception.printStackTrace();
        }

    }

    public static void defineKeySpec(){ }

}