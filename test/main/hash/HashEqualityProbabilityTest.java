package test.main.hash;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import static org.junit.Assert.assertEquals;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
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