package test.main.algorithm.utilities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
