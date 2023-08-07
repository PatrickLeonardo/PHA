package test.main.algorithm.utilities;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import main.algorithm.utilities.savePHAKey;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class savePHAKeyTest {
    
    @Test
    public void PHAKeySaverTest(){

        assertTrue(savePHAKey.writeEncodedKey("null"));

    }

}