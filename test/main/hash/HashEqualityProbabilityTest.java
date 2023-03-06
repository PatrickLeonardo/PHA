package test.main.hash;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HashEqualityProbabilityTest {

    @Test
    public static void main(String[] args) {
        
        HashEqualityProbabilityTest hashEqualityProbability = new HashEqualityProbabilityTest();
        
        int numberOfProbability = 10;
        for (int i = 8; i > 0; i--) numberOfProbability *= 10;
        int prefix = 2;
        for (double i = 10; i > 0; i--) prefix *= 2;
        
        numberOfProbability += prefix;
        System.out.println(numberOfProbability);
        double probability = hashEqualityProbability.getProbability(numberOfProbability);
        System.out.println(probability);
        assertEquals((Double)1.0, (Double)probability);
        
    }

    public double getProbability(int number){
        
        System.out.println("\n" + 1.0/365);
        double p = Math.pow((1.0/365), number);
        for(int i = (366 - number); i < 366; i++) p *= i;
        return 1 - p;

    }

}