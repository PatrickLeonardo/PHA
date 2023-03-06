package test.main.hash;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HashEqualityProbabilityTest {

    public static void main(String[] args) {

        getProbabilityTest(10);

    }

    @Test
    public static double getProbabilityTest(int numberOfProbability){
        
        double p = Math.pow((1.0/365), numberOfProbability);
        for(int i = (366 - numberOfProbability); i < 366; i++) p *= i;
        
        assertEquals((Double)0.11694817771107746, (Double)getProbabilityTest(numberOfProbability));
        return 1 - p;

    }

}