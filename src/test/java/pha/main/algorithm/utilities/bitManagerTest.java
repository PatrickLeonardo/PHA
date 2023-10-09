package pha.main.algorithm.utilities;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import pha.algorithm.utilities.bitManager;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class bitManagerTest {

    @Test
    public void byteToBitTest(){

        String byteConverted = bitManager.byteToBit((byte)9);
        assertEquals("00001001", byteConverted);

    }

}
