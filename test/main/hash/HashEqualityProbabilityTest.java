package test.main.hash;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import main.hash.HashEqualityProbability;

import static org.junit.Assert.assertEquals;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class HashEqualityProbabilityTest {
    
    @Test
    public void getProbabilityTest(){

        HashEqualityProbability hashEqualityProbability = new HashEqualityProbability();
        double probability = hashEqualityProbability.getProbability(10);
        assertEquals((Double)0.11694817771107746, (Double)probability);

    }

}