package pha.main.algorithm.key;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import pha.algorithm.key.PHAKeyCipher;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class PHAKeyCipherTest {
    
    @Test
    public void PHAKeyTest() throws IOException{

        File x = new File("");
        File y = new File("");
        assertTrue(PHAKeyCipher.createPHAKeys(x, y));
        
    }

}
