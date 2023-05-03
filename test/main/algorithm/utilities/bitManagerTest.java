package test.main.algorithm.utilities;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class bitManagerTest {

    public static String byteToBit(final byte sufixByte){
        String bit = "";
        for (int index = 7; index > -1; index--){
            bit += (byte)((sufixByte >> index) & 0x1);
        }
        return bit;
    }

    @Test
    public void byteToBitTest(){

        String byteConverted = byteToBit((byte)9);
        assertEquals("00001001", byteConverted);

    }

}