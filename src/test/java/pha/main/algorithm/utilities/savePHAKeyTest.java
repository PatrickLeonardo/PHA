package pha.main.algorithm.utilities;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import pha.algorithm.utilities.savePHAKey;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class savePHAKeyTest {
    
    @Test
    public void PHAKeySaverTest() throws IOException{

        assertTrue(savePHAKey.writeEncodedKey("null"));

    }

}
