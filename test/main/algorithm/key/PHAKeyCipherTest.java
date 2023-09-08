package test.main.algorithm.key;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import main.algorithm.key.PHAKeyCipher;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class PHAKeyCipherTest {
    
    @Test
    public void PHAKeyTest() throws IOException{

        assertTrue(PHAKeyCipher.createPHAKey(9));
        
    }

}