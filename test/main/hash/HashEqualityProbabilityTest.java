package test.main.hash;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HashEqualityProbabilityTest {
    
    public static double getProbability(int numberOfProbability){
        
        double p = Math.pow((1.0/365), numberOfProbability);
        for(int i = (366 - numberOfProbability); i < 366; i++) p *= i;
        return 1 - p;

    }

    @Test
    public void getProbabilityTest(){

        double probability = (double)getProbability(10);
        assertEquals((Double)0.11694817771107746, (Double)probability);

    }

}