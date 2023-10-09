package pha.main.algorithm.key;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import pha.algorithm.key.SubBytes;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class SubBytesTest {
    
    @Test
    public void generateRoundKeyTest(){

        StringBuilder PHAKey = new StringBuilder();
        PHAKey.append("00000000 00111110 01000100 01001000 00111110 01000100 01001000 01001010 01000100 01001000 01001010 01001100 01001000 01001010 01001100 01001110");

        SubBytes subBytes = new SubBytes(PHAKey);
        StringBuilder InvertedKey = subBytes.generateInvertedKey();

        String expect = "01001110 01001100 01001010 01001000 01001100 01001010 01001000 01000100 01001010 01001000 01000100 00111110 01001000 01000100 00111110 00000000 ";

        assertEquals(expect, InvertedKey);

    }

}
